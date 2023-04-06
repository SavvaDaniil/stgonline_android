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
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.UserService;

public class AuthForgetStep1Fragment extends Fragment {

    private boolean _isLoading = false;
    private EditText _inputCode;
    private AppCompatButton _btnInit;
    private AppCompatButton _btnCansel;
    private TextView _labelWarning;
    private UserService _userService;
    private int _forgetId;
    public AuthForgetStep1Fragment() {
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
        View view = inflater.inflate(R.layout.fragment_auth_forget_step1, container, false);

        _inputCode = (EditText) view.findViewById(R.id.inputCode);
        _inputCode.addTextChangedListener(new TextWatcher() {
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
                forgetStep1Init();
            }
        });
        _btnCansel = (AppCompatButton) view.findViewById(R.id.btnCansel);
        _btnCansel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cansel();
            }
        });
        _labelWarning = (TextView) view.findViewById(R.id.labelWarning);

        return view;
    }

    public void setForgetId(int forgetId){
        _forgetId = forgetId;
    }

    private void cansel(){
        _forgetId = 0;
        ((AuthenticationActivity)getActivity()).changeForgetState(AuthForgetStepState.STEP0);
    }

    private void clearWarning(){
        ...
    }

    private void forgetStep1Init(){
        if(_isLoading)return;
        String code = _inputCode.getText().toString();
        if(code.isEmpty()){
            _labelWarning.setText("Введите пожалуйста полученный код");
            return;
        }
        if(_userService == null)_userService = new UserService();
        ...
    }

    private class ForgetStep1Async extends AsyncTask<UserForgetDTO, String, JsonAnswerStatusModel> {

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
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getAccess_token() != null){
                
                ...

            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_found")){
                _labelWarning.setText("Пользователь не найден");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("max_limit_try")){
                _labelWarning.setText("Подождите пожалуйста 20 минут");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("2_left")){
                _labelWarning.setText("Неверно, осталось 2 попытки");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("1_left")){
                _labelWarning.setText("Неверно, осталось 1 попытка");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("0_left")){
                _labelWarning.setText("Неверно, попытки исчерпаны");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("out_of_limit")){
                _labelWarning.setText("Попытки исчерпаны, начните сначала");
            } else {
                _labelWarning.setText("Ошибка сети");
            }
        }
    }
}