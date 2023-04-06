package com.example.stgonline.Controller;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stgonline.DTO.User.UserLoginDTO;
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.Model.Lesson.LessonPreviewModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.UserService;



public class AuthLoginFragment extends Fragment {

    private boolean _isLoading = false;
    private TextView _labelWarning;
    private EditText _inputUsername;
    private EditText _inputPassword;
    private AppCompatButton _btnLogin;
    private UserService _userService;


    public AuthLoginFragment() {
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
        View view = inflater.inflate(R.layout.fragment_auth_login, container, false);

        _labelWarning = (TextView) view.findViewById(R.id.labelWarning);
        _inputUsername = (EditText) view.findViewById(R.id.inputUsername);
        _inputUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearWarning();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        _inputPassword = (EditText) view.findViewById(R.id.inputPassword);
        _inputPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearWarning();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        _btnLogin = (AppCompatButton) view.findViewById(R.id.btnLogin);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginInit();
            }
        });

        return view;
    }

    private void clearWarning(){
        ...
    }

    private void loginInit(){
        if(_isLoading)return;
        String username = _inputUsername.getText().toString();
        String password = _inputPassword.getText().toString();
        if(username.isEmpty() || password.isEmpty()){
            _labelWarning.setText("Оба поля обязательны для заполнения");
            return;
        }
        this.clearWarning();
        UserLoginTask userLoginTask = new UserLoginTask();
        if(_userService == null)_userService = new UserService();
        userLoginTask.execute(new UserLoginDTO(username, password));
    }

    private class UserLoginTask extends AsyncTask<UserLoginDTO, String, JsonAnswerStatusModel>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoading = true;
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(UserLoginDTO... userLoginDTOs) {
            if(userLoginDTOs.length == 0)return null;
            return _userService.login(userLoginDTOs[0]);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoading = false;
            if(jsonAnswerStatusModel == null) {
                _labelWarning.setText("Ошибка сети");
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getAccess_token() != null){
                System.out.println("access_token: " + jsonAnswerStatusModel.getAccess_token());
                UserFacade userFacade = new UserFacade(getContext());
                userFacade.login(...);
                ((AuthenticationActivity)getActivity()).finishAfterChangeAuth();

            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("wrong")){
                _labelWarning.setText("Неправильно введены логин или пароль");
            } else {
                _labelWarning.setText("Ошибка сети");
            }
        }
    }
}