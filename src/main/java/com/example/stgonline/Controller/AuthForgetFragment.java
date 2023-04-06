package com.example.stgonline.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stgonline.Component.AuthForgetStepState;
import com.example.stgonline.R;


public class AuthForgetFragment extends Fragment {

    private AuthForgetStepState _authForgetStepStateCurrent = AuthForgetStepState.STEP0;
    private AuthForgetStep0Fragment _authForgetStep0Fragment;
    private AuthForgetStep1Fragment _authForgetStep1Fragment;
    private FragmentManager _fragmentManager;


    public AuthForgetFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auth_forget, container, false);

        _fragmentManager = getActivity().getSupportFragmentManager();
        _authForgetStep0Fragment = new AuthForgetStep0Fragment();
        _authForgetStep1Fragment = new AuthForgetStep1Fragment();

        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerView, _authForgetStep0Fragment, AuthForgetStep0Fragment.class.getSimpleName())
                .addToBackStack(AuthForgetStep0Fragment.class.getSimpleName());
        ...
        fragmentTransaction.commit();
        this.changeState(AuthForgetStepState.HIDE_ALL);


        return view;
    }

    public void setIsVisible(boolean isVisible){
        this.changeState(isVisible ? _authForgetStepStateCurrent : AuthForgetStepState.HIDE_ALL);
    }

    public void setForgetId(int forgetId){
        _authForgetStep1Fragment.setForgetId(forgetId);
    }

    public void changeState(AuthForgetStepState authForgetStepState){
        if(_fragmentManager == null){
            return;
        }
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        switch (authForgetStepState){
            case HIDE_ALL:
                fragmentTransaction.hide(_authForgetStep0Fragment);
                fragmentTransaction.hide(_authForgetStep1Fragment);
                break;
            case STEP0:
                ...
                break;
            case STEP1:
                ...
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

}