package com.example.stgonline.Controller;

import android.os.AsyncTask;
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

import com.example.stgonline.Component.AuthForgetStepState;
import com.example.stgonline.DTO.User.UserForgetDTO;
import com.example.stgonline.DTO.User.UserLoginDTO;
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.UserService;

public class AuthForgetStep0Fragment extends Fragment {

    private boolean _isLoading = false;
    private EditText _inputUsername;
    private AppCompatButton _btnInit;
    private TextView _labelWarning;
    private UserService _userService;
    public AuthForgetStep0Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _userService = new UserService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth_forget_step0, container, false);
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
        _btnInit = (AppCompatButton) view.findViewById(R.id.btnInit);
        _btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgetStep0Init();
            }
        });
        _labelWarning = (TextView) view.findViewById(R.id.labelWarning);

        return view;
    }

    private void clearWarning(){
        ...
    }

    private void forgetStep0Init(){
        if(_isLoading)return;
        String username = _inputUsername.getText().toString();
        if(username.isEmpty()){
            _labelWarning.setText("Введите пожалуйста электронную почту");
            return;
        }
        ForgetStep0Async forgetStep0Async = new ForgetStep0Async();
        forgetStep0Async.execute(new UserForgetDTO(0, username));
    }

    private class ForgetStep0Async extends AsyncTask<UserForgetDTO, String, JsonAnswerStatusModel>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoading = true;
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(UserForgetDTO... userForgetDTOs) {
            if(userForgetDTOs.length == 0)return null;
            return _userService.forget(userForgetDTOs[0]);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoading = false;
            if(jsonAnswerStatusModel == null) {
                _labelWarning.setText("Ошибка сети");
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getForget_id() != 0){
                ...

            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_found")){
                _labelWarning.setText("Пользователь не найден");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("max_limit_try")){
                _labelWarning.setText("Подождите пожалуйста 20 минут");
            } else {
                _labelWarning.setText("Ошибка сети");
            }
        }
    }
}