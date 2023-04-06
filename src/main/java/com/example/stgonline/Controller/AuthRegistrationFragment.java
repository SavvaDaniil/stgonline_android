package com.example.stgonline.Controller;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stgonline.DTO.User.UserLoginDTO;
import com.example.stgonline.DTO.User.UserRegistrationDTO;
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.UserService;


public class AuthRegistrationFragment extends Fragment {

    private boolean _isLoading = false;
    private TextView _labelWarning;
    private EditText _inputUsername;
    private EditText _inputPassword;
    private EditText _inputPasswordAgain;
    private AppCompatButton _btnRegistration;
    private UserService _userService;

    public AuthRegistrationFragment() {
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
        View view = inflater.inflate(R.layout.fragment_auth_registration, container, false);

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
        _inputPasswordAgain = (EditText) view.findViewById(R.id.inputPasswordAgain);
        _inputPasswordAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearWarning();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        _btnRegistration = (AppCompatButton) view.findViewById(R.id.btnRegistration);
        _btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationInit();
            }
        });

        return view;
    }

    private void clearWarning(){
        ...
    }
    private void registrationInit(){
        if(_isLoading)return;
        String username = _inputUsername.getText().toString();
        String password = _inputPassword.getText().toString();
        String passwordAgain = _inputPasswordAgain.getText().toString();
        if(username.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()){
            _labelWarning.setText("Все поля обязательны для заполнения");
            return;
        } else if(!password.equals(passwordAgain)){
            _labelWarning.setText("Пароли не совпадают");
            return;
        }
        this.clearWarning();
        UserRegistrationClass userRegistrationClass = new UserRegistrationClass();
        if(_userService == null)_userService = new UserService();
        userRegistrationClass.execute(new UserRegistrationDTO(...));
    }

    private class UserRegistrationClass extends AsyncTask<UserRegistrationDTO, String, JsonAnswerStatusModel> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoading = true;
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(UserRegistrationDTO... userRegistrationDTOs) {
            if(userRegistrationDTOs.length == 0)return null;
            return _userService.registration(userRegistrationDTOs[0]);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoading = false;
            if(jsonAnswerStatusModel == null) {
                //changeState(LessonsFragment.LessonPreviewsState.ERROR);
                _labelWarning.setText("Ошибка сети");
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getAccess_token() != null){
                System.out.println("access_token: " + jsonAnswerStatusModel.getAccess_token());
                UserFacade userFacade = new UserFacade(getContext());
                userFacade.login(jsonAnswerStatusModel.getAccess_token());
                ((AuthenticationActivity)getActivity()).finishAfterChangeAuth();

            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("username_already_exist")){
                _labelWarning.setText("Логин уже зарегистрирован");
            } else {
                _labelWarning.setText("Ошибка сети");
            }
        }
    }
}