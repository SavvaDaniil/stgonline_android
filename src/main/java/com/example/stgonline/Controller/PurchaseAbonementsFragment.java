package com.example.stgonline.Controller;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.stgonline.Component.ActivityLoadingState;
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Interface.ITryAgain;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.R;
import com.example.stgonline.ViewModel.JsonAnswerStatus;

public class PurchaseAbonementsFragment extends Fragment {

    private FragmentManager fragmentManager;
    private PurchaseAbonementsViewFragment _purchaseAbonementsViewFragment;
    private LoadingFragment loadingFragment;
    private ErrorFragment errorFragment;
    private ITryAgain iTryAgain;
    private boolean isLoading = false;
    private UserFacade userFacade;

    public PurchaseAbonementsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentManager = getActivity().getSupportFragmentManager();
        userFacade = new UserFacade(getContext());

        _purchaseAbonementsViewFragment = new PurchaseAbonementsViewFragment();
        loadingFragment = new LoadingFragment();
        errorFragment = new ErrorFragment();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_purchase_abonements, container, false);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.show(purchaseAbonementsViewFragment);
        fragmentTransaction.add(R.id.containerViewPurchasePreviews, loadingFragment, LoadingFragment.class.getSimpleName());
        
        ...

        fragmentTransaction.commit();
        //this.changeState(ActivityLoadingState.HIDE_ALL);

        return view;
    }

    private void changeState(ActivityLoadingState activityLoadingState){
        System.out.println("PurchaseAbonementsFragment changeState: " + activityLoadingState);


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (activityLoadingState){
            case ERROR:
                fragmentTransaction.hide(_purchaseAbonementsViewFragment);
                
                ...

                if(iTryAgain == null){
                    iTryAgain = new ITryAgain() {
                        @Override
                        public void tryAgain() {
                            //profileGetInit();
                        }
                    };
                    errorFragment.setTryAgainFunctionToBtnTryAgain(iTryAgain);
                }
                
                ...

                break;
            case LOADING:
                
                ...

                break;
            case SUCCESS:
            
                ...

                break;
            case HIDE_ALL:
            
                ...

                break;
            default:
                break;
        }
        fragmentTransaction.commit();

    }
    public void hideAll(){
        this.changeState(ActivityLoadingState.HIDE_ALL);
    }

    public void getListOfPurchaseLitesInit(){
        if(isLoading)return;
        ListPurchaseLitesTask listPurchaseLitesTask = new ListPurchaseLitesTask();
        listPurchaseLitesTask.execute();
    }

    private class ListPurchaseLitesTask extends AsyncTask<String, String, JsonAnswerStatus>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            isLoading = true;
            changeState(ActivityLoadingState.LOADING);
        }

        @Override
        protected JsonAnswerStatus doInBackground(String... strings) {
            return userFacade.listPurchaseLites();
        }

        @Override
        protected void onPostExecute(JsonAnswerStatus jsonAnswerStatus) {
            super.onPostExecute(jsonAnswerStatus);

            isLoading = false;
            if(jsonAnswerStatus == null) {

                ...

            } else if(jsonAnswerStatus.getStatus().equals("success") && jsonAnswerStatus.getPurchaseLessonLiteViewModels() != null
                    && jsonAnswerStatus.getPurchaseSubscriptionLiteViewModels() != null){

                _purchaseAbonementsViewFragment.setup(
                    
                    ...

                );
                changeState(ActivityLoadingState.SUCCESS);
            } else if(jsonAnswerStatus.getStatus().equals("error") && jsonAnswerStatus.getErrors().equals("not_auth")){
                userFacade.logout();
                ((MainActivity)getActivity()).changeAuthListener();
            } else {

                ...

            }
        }
    }

}