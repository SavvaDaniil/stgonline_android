package com.example.stgonline.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.stgonline.Component.AuthForgetStepState;
import com.example.stgonline.R;
import com.example.stgonline.Service.UserService;

public class AuthenticationActivity extends AppCompatActivity {

    private ImageButton _btnBack;
    private AppCompatButton _btnFooterMenuLogin;
    private AppCompatButton _btnFooterMenuRegistration;
    private AppCompatButton _btnFooterMenuForget;

    private FragmentManager _fragmentManager;
    private AuthLoginFragment _authLoginFragment;
    private AuthRegistrationFragment _authRegistrationFragment;
    private AuthForgetFragment _authForgetFragment;

    private boolean _isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        _btnBack = (ImageButton) findViewById(R.id.btn_back);
        _btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_isLoading)return;
                finish();
            }
        });

        _btnFooterMenuLogin = (AppCompatButton) findViewById(R.id.btnFooterMenuLogin);
        _btnFooterMenuLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(AuthState.LOGIN);
            }
        });
        _btnFooterMenuRegistration = (AppCompatButton) findViewById(R.id.btnFooterMenuRegistration);
        _btnFooterMenuRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(AuthState.REGISTRATION);
            }
        });
        _btnFooterMenuForget = (AppCompatButton) findViewById(R.id.btnFooterMenuForget);
        _btnFooterMenuForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(AuthState.FORGET);
            }
        });

        _authLoginFragment = new AuthLoginFragment();
        _authRegistrationFragment = new AuthRegistrationFragment();
        _authForgetFragment = new AuthForgetFragment();
        _fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerView, _authLoginFragment, AuthLoginFragment.class.getSimpleName())
                .addToBackStack(AuthLoginFragment.class.getSimpleName());
        
        ...

        fragmentTransaction.commit();
        this.changeState(AuthState.LOGIN);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void changeState(AuthState authState){
        if(_isLoading)return;
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        switch(authState){
            case LOGIN:
                _btnFooterMenuLogin.setTextColor(getResources().getColor(R.color.black_custom));
                _btnFooterMenuLogin.setBackground(getResources().getDrawable(R.drawable.bgd_fill_main_color));
                fragmentTransaction.show(_authLoginFragment);

                ...

                break;
            case REGISTRATION:
                ...
                break;
            case FORGET:
                ...
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private enum AuthState {
        LOGIN,
        REGISTRATION,
        FORGET
    }

    public void setForgetId(int forgetId){
        _authForgetFragment.setForgetId(forgetId);
    }

    public void changeForgetState(AuthForgetStepState authForgetStepState){
        _authForgetFragment.changeState(authForgetStepState);
    }

    public void finishAfterChangeAuth(){
        Intent data = new Intent();
        setResult(RESULT_OK, data);
        finish();
    }
}