package com.example.stgonline.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.stgonline.Component.ActivityLoadingState;
import com.example.stgonline.Component.GlobalVariables;
import com.example.stgonline.Facade.LessonFacade;
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Interface.ITryAgain;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.Model.Lesson.LessonLiteModel;
import com.example.stgonline.Model.Lesson.LessonPosterWebDataModel;
import com.example.stgonline.Model.Lesson.LessonPreviewModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.LessonDownloadPosterTask;
import com.example.stgonline.Service.LessonService;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LessonAboutActivity extends AppCompatActivity {

    private ImageButton _btnBack;
    private TextView _lessonAboutHeaderTitle;

    private FragmentManager _fragmentManager = getSupportFragmentManager();
    private LessonAboutFragment _lessonAboutFragment;
    private LoadingFragment _loadingFragment;
    private ErrorFragment _errorFragment;
    private ITryAgain _iTryAgain;
    private boolean _isLoadingActivity;
    private boolean _isLoadingCheckAccess = false;

    private int _lessonId;
    private LessonLiteModel _lessonLiteModel;
    private LessonFacade _lessonFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_about);

        _lessonFacade = new LessonFacade(this);
        Bundle extras = getIntent().getExtras();
        _lessonId = extras.getInt("lessonId");

        _btnBack = (ImageButton) findViewById(R.id.btn_back);
        _btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        _lessonAboutHeaderTitle = (TextView) findViewById(R.id.lessonAboutHeaderTitle);
        _lessonAboutHeaderTitle.setText(extras.getString("lessonShortName"));

        _lessonAboutFragment = new LessonAboutFragment();
        _loadingFragment = new LoadingFragment();
        _errorFragment = new ErrorFragment();

        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerView, _lessonAboutFragment, LessonAboutFragment.class.getSimpleName());

        ...

        fragmentTransaction.commit();
        this.changeState(ActivityLoadingState.LOADING);

        this.getLiteByIdInit();
    }

    private void getLiteByIdInit(){
        if(_isLoadingActivity)return;
        LessonGetLiteTask lessonGetLiteTask = new LessonGetLiteTask();
        lessonGetLiteTask.execute();
    }

    private class LessonGetLiteTask extends AsyncTask<String, String, JsonAnswerStatusModel> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoadingActivity = true;
            changeState(ActivityLoadingState.LOADING);
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(String... strings) {
            return _lessonFacade.getLiteById(_lessonId);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoadingActivity = false;
            if(jsonAnswerStatusModel == null) {
                changeState(ActivityLoadingState.ERROR);
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getLessonLiteViewModel() != null){
                ...
                changeState(ActivityLoadingState.SUCCESS);
            } else {
                changeState(ActivityLoadingState.ERROR);
            }
        }
    }

    private void changeState(ActivityLoadingState activityLoadingState){
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        switch (activityLoadingState){
            case LOADING:
                fragmentTransaction.hide(_lessonAboutFragment);
                fragmentTransaction.hide(_errorFragment);

                ...

                break;
            case ERROR:

                ...

                if(_iTryAgain == null){
                    _iTryAgain = new ITryAgain() {
                        @Override
                        public void tryAgain() {
                            getLiteByIdInit();
                        }
                    };
                    _errorFragment.setTryAgainFunctionToBtnTryAgain(_iTryAgain);
                }

                ...

                break;
            case SUCCESS:

                ...

                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void close(){
        if(_isLoadingActivity)return;
        finish();
    }

    public void checkAccessInit(){
        if(_isLoadingCheckAccess)return;
        UserFacade userFacade = new UserFacade(this);
        if(!userFacade.isAuth()){
            //Открытие auth
            Intent intentAuthenticationActivity = new Intent(this, AuthenticationActivity.class);
            startActivityForResult(intentAuthenticationActivity, 1);
            return;
        }

        LessonCheckAccessTask lessonCheckAccessTask = new LessonCheckAccessTask();
        lessonCheckAccessTask.execute(_lessonId);
    }

    public void getVideoInit(){
        if(_isLoadingCheckAccess)return;
        LessonGetVideoTask lessonGetVideoTask = new LessonGetVideoTask();
        lessonGetVideoTask.execute(_lessonId);
    }

    private class LessonCheckAccessTask extends AsyncTask<Integer, String, JsonAnswerStatusModel>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoadingCheckAccess = true;
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(Integer... lessonids) {
            if(lessonids.length == 0)return null;
            return _lessonFacade.checkAccess(lessonids[0]);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoadingCheckAccess = false;
            if(jsonAnswerStatusModel == null) {
                Toast.makeText(LessonAboutActivity.this, "Ошибка сети", Toast.LENGTH_SHORT).show();
            } else if(jsonAnswerStatusModel.getStatus().equals("success")){
                
                ...

            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_available")){
                openLessonBuyActivity();
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("excluzive")){

            } else {
                Toast.makeText(LessonAboutActivity.this, "Ошибка сети", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openLessonBuyActivity(){
        Intent intentLessonBuyActivity = new Intent(this, LessonBuyActivity.class);
        intentLessonBuyActivity.putExtra("lessonId", _lessonId);
        startActivityForResult(intentLessonBuyActivity, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            this.getLiteByIdInit();
        }
    }

    private class LessonGetVideoTask extends AsyncTask<Integer, String, JsonAnswerStatusModel>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoadingCheckAccess = true;
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(Integer... lessonids) {
            if(lessonids.length == 0)return null;
            return _lessonFacade.getVideo(lessonids[0]);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoadingCheckAccess = false;
            if(jsonAnswerStatusModel == null) {
                Toast.makeText(LessonAboutActivity.this, "Ошибка сети", Toast.LENGTH_SHORT).show();
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getLessonVideoViewModel() != null){

            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_auth")){
                Toast.makeText(LessonAboutActivity.this, "Ошибка авторизации", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LessonAboutActivity.this, "Ошибка сети", Toast.LENGTH_SHORT).show();
            }
        }
    }
}