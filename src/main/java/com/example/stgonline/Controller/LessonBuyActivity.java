package com.example.stgonline.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.stgonline.Component.ActivityLoadingState;
import com.example.stgonline.Component.ActivityPaymentState;
import com.example.stgonline.DTO.Payment.PaymentNewDTO;
import com.example.stgonline.Facade.LessonFacade;
import com.example.stgonline.Facade.PaymentFacade;
import com.example.stgonline.Interface.ITryAgain;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.PaymentService;

public class LessonBuyActivity extends AppCompatActivity {

    private ImageButton _btnBack;
    private FragmentManager _fragmentManager = getSupportFragmentManager();
    private LessonBuyViewFragment _lessonBuyViewFragment;
    private PaymentNewViewFragment paymentNewViewFragment;
    private LoadingFragment _loadingFragment;
    private ErrorFragment _errorFragment;
    private ITryAgain _iTryAgain;
    private boolean _isLoadingActivity;
    private int _lessonId;
    private LessonFacade _lessonFacade;
    private PaymentFacade paymentFacade;
    private boolean isPaymentPayedSuccessfully = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("LessonBuyActivity onCreate");
        setContentView(R.layout.activity_lesson_buy);

        _lessonFacade = new LessonFacade(this);
        paymentFacade = new PaymentFacade(this);
        Bundle extras = getIntent().getExtras();
        _lessonId = extras.getInt("lessonId");

        _btnBack = (ImageButton) findViewById(R.id.btn_back);
        _btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });

        _lessonBuyViewFragment = new LessonBuyViewFragment();
        paymentNewViewFragment = new PaymentNewViewFragment();
        _loadingFragment = new LoadingFragment();
        _errorFragment = new ErrorFragment();

        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerViewLessonBuy, _lessonBuyViewFragment, LessonBuyViewFragment.class.getSimpleName());
        
        ...

        fragmentTransaction.commit();
        this.changeState(ActivityPaymentState.LOADING);

        this.getBuyViewModelById();
    }

    public void close(){
        if(_isLoadingActivity)return;
        if(isPaymentPayedSuccessfully){
            Intent data = new Intent();
            setResult(RESULT_OK, data);
        }
        finish();
    }

    private void getBuyViewModelById(){
        if(_isLoadingActivity)return;
        LessonBuyViewModelGetTask lessonBuyViewModelGetTask = new LessonBuyViewModelGetTask();
        lessonBuyViewModelGetTask.execute(_lessonId);
    }

    private void changeState(ActivityPaymentState activityPaymentState){
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        switch (activityPaymentState){
            case LOADING:
                fragmentTransaction.hide(_lessonBuyViewFragment);
                fragmentTransaction.hide(paymentNewViewFragment);
                
                ...

                fragmentTransaction.show(_loadingFragment);
                break;
            case ERROR:
                
                ...

                fragmentTransaction.show(_errorFragment);
                if(_iTryAgain == null){
                    _iTryAgain = new ITryAgain() {
                        @Override
                        public void tryAgain() {
                            getBuyViewModelById();
                        }
                    };
                    _errorFragment.setTryAgainFunctionToBtnTryAgain(_iTryAgain);
                }
                
                ...

                break;
            case CHOOSE_PAYMENT_METHOD:
                
                ...

                break;
            case PAYMENT_START:

                ...
                
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    public void buy(PaymentNewDTO paymentNewDTO){
        if(_isLoadingActivity)return;
        PaymentNewTask paymentNewTask = new PaymentNewTask();
        paymentNewTask.execute(paymentNewDTO);
    }

    private class LessonBuyViewModelGetTask extends AsyncTask<Integer, String, JsonAnswerStatusModel>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoadingActivity = true;
            changeState(ActivityPaymentState.LOADING);
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(Integer... integers) {
            if(integers.length == 0)return null;
            return _lessonFacade.buyModelGet(_lessonId);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoadingActivity = false;
            if(jsonAnswerStatusModel == null) {
                changeState(ActivityPaymentState.ERROR);
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getLessonBuyViewModel() != null){
                _lessonBuyViewFragment.setProductsForBuying(
                    ...
                );
                changeState(ActivityPaymentState.CHOOSE_PAYMENT_METHOD);
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getSubscriptionLiteViewModels() != null){
                _lessonBuyViewFragment.setProductsForBuying(
                    ...
                );
                changeState(ActivityPaymentState.CHOOSE_PAYMENT_METHOD);
            } else {
                changeState(ActivityPaymentState.ERROR);
            }
        }
    }

    private class PaymentNewTask extends AsyncTask<PaymentNewDTO, String, JsonAnswerStatusModel>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoadingActivity = true;
            changeState(ActivityPaymentState.LOADING);
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(PaymentNewDTO... paymentNewDTOs) {
            if(paymentNewDTOs.length == 0)return null;
            return paymentFacade.initNew(paymentNewDTOs[0]);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoadingActivity = false;
            if(jsonAnswerStatusModel == null) {
                changeState(ActivityPaymentState.ERROR);
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getPaymentNewResultViewModel() != null){

                if(jsonAnswerStatusModel.getPaymentNewResultViewModel().getPayment_url() != null){
                    
                    ...

                    changeState(ActivityPaymentState.PAYMENT_START);
                } else {
                    Toast.makeText(LessonBuyActivity.this, "Неизвестная ошибка на сервере", Toast.LENGTH_LONG).show();
                    changeState(ActivityPaymentState.CHOOSE_PAYMENT_METHOD);
                }
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_auth")){

                changeState(ActivityPaymentState.ERROR);
            } else {
                changeState(ActivityPaymentState.ERROR);
            }
        }
    }

    public void setPaymentPayedSuccessfully(boolean paymentPayedSuccessfully) {
        isPaymentPayedSuccessfully = paymentPayedSuccessfully;
    }
}