package com.example.stgonline.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stgonline.Component.ActivityLoadingState;
import com.example.stgonline.DTO.User.UserLoginDTO;
import com.example.stgonline.Facade.LessonFacade;
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Interface.ITryAgain;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.UserService;

public class ProfileFragment extends Fragment {

    private FragmentManager _fragmentManager;
    private ProfileViewFragment _profileViewFragment;
    private LoadingFragment _loadingFragment;
    private ErrorFragment _errorFragment;
    private ITryAgain _iTryAgain;

    private ImageButton _btnLogout;
    private boolean _isLoading = false;
    private UserFacade _userFacade;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _fragmentManager = getActivity().getSupportFragmentManager();
        _userFacade = new UserFacade(getContext());

        _profileViewFragment = new ProfileViewFragment();
        _loadingFragment = new LoadingFragment();
        _errorFragment = new ErrorFragment();

        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerViewProfile, _profileViewFragment, ProfileViewFragment.class.getSimpleName());
        
        ...

        fragmentTransaction.commit();
        this.changeState(ActivityLoadingState.HIDE_ALL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        _btnLogout = (ImageButton)view.findViewById(R.id.btnLogout);
        _btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutPrepare();
            }
        });

        return view;
    }

    private void changeState(ActivityLoadingState activityLoadingState){
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        switch (activityLoadingState){
            case ERROR:
                fragmentTransaction.hide(_profileViewFragment);
                fragmentTransaction.show(_errorFragment);
                if(_iTryAgain == null){
                    _iTryAgain = new ITryAgain() {
                        @Override
                        public void tryAgain() {
                            profileGetInit();
                        }
                    };
                    _errorFragment.setTryAgainFunctionToBtnTryAgain(_iTryAgain);
                }
                fragmentTransaction.hide(_loadingFragment);
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


    private void logoutPrepare(){
        if(_isLoading)return;
        new AlertDialog.Builder(getContext())
        .setTitle("Вы уверены, что хотите выйти из аккаунта?")
        .setNeutralButton("Выйти из аккаунта", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                
                ...

            }
        })
        .setPositiveButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Отмена выхода", Toast.LENGTH_LONG).show();
            }
        })
        .show();
    }

    private void logoutInit(){
        if(_userFacade == null)_userFacade = new UserFacade(getContext());
        _userFacade.logout();
        ((MainActivity)getActivity()).changeAuthListener();
        System.out.println("_userFacade.isAuth(): " + _userFacade.isAuth());
    }

    public void profileGetInit(){
        if(_isLoading)return;
        UserProfileGetAsync userProfileGetAsync = new UserProfileGetAsync();
        userProfileGetAsync.execute();
    }

    private class UserProfileGetAsync extends AsyncTask<String, String, JsonAnswerStatusModel>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoading = true;
            changeState(ActivityLoadingState.LOADING);
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(String... strings) {
            return _userFacade.profileGet();
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoading = false;
            if(jsonAnswerStatusModel == null) {
                changeState(ActivityLoadingState.ERROR);
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getUserProfileViewModel() != null){
                _profileViewFragment.setUserProfileModel(...);
                changeState(ActivityLoadingState.SUCCESS);
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_auth")){
                _userFacade.logout();
                ((MainActivity)getActivity()).changeAuthListener();
            } else {
                changeState(ActivityLoadingState.ERROR);
            }
        }
    }

}