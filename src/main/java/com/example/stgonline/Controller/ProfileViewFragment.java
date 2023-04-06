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

import com.example.stgonline.Component.ActivityLoadingState;
import com.example.stgonline.DTO.User.UserProfileMicroEditDTO;
import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.Model.User.UserProfileModel;
import com.example.stgonline.R;


public class ProfileViewFragment extends Fragment {

    private boolean _isLoading = false;
    private UserFacade _userFacade;
    private EditText _inputUsername;
    private EditText _inputPasswordNew;
    private EditText _inputPasswordNewAgain;
    private EditText _inputPasswordCurrent;
    private AppCompatButton _btnProfileSave;
    private TextView _labelWarning;

    private UserProfileModel _userProfileModel;
    private int _userId;

    public ProfileViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _userFacade = new UserFacade(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_view, container, false);

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
        _inputPasswordNew = (EditText) view.findViewById(R.id.inputPasswordNew);
        _inputPasswordNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearWarning();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        _inputPasswordNewAgain = (EditText) view.findViewById(R.id.inputPasswordNewAgain);
        _inputPasswordNewAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearWarning();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        _inputPasswordCurrent = (EditText) view.findViewById(R.id.inputPasswordCurrent);
        _inputPasswordCurrent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearWarning();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        _btnProfileSave = (AppCompatButton) view.findViewById(R.id.btnProfileSave);
        _btnProfileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInit();
            }
        });

        return view;
    }

    private void clearWarning(){
        ...
    }


    private void saveInit(){
        if(_isLoading)return;
        String username = _inputUsername.getText().toString();
        String passwordNew = _inputPasswordNew.getText().toString();
        String passwordNewAgain = _inputPasswordNewAgain.getText().toString();
        String passwordCurrent = _inputPasswordCurrent.getText().toString();
        if(username.isEmpty()){
            _labelWarning.setText("Поле \"логин\" обязательно для заполнения");
            return;
        } else if(!passwordNew.isEmpty() && !passwordNew.equals(passwordNewAgain)){
            _labelWarning.setText("Пароли не совпадают");
            return;
        } else if(!passwordNew.isEmpty() && passwordCurrent.isEmpty()){
            _labelWarning.setText("Введите пожалуйста текущий пароль");
            return;
        }

        UserProfileUpdateAsync userProfileUpdateAsync = new UserProfileUpdateAsync();
        userProfileUpdateAsync.execute(
            ...
        );
    }

    public void setUserProfileModel(UserProfileModel userProfileModel){
        _userProfileModel = userProfileModel;
        _inputUsername.setText(_userProfileModel.getUsername());
        _userId = _userProfileModel.getId();
    }

    private class UserProfileUpdateAsync extends AsyncTask<UserProfileMicroEditDTO, String, JsonAnswerStatusModel> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoading = true;
            _labelWarning.setText("Идет сохранение...");
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(UserProfileMicroEditDTO... userProfileMicroEditDTOs) {
            if(userProfileMicroEditDTOs.length == 0)return null;
            return _userFacade.profileUpdate(userProfileMicroEditDTOs[0]);
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoading = false;
            if(jsonAnswerStatusModel == null) {
                _labelWarning.setText("Ошибка сети");
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getAccess_token() != null){
                _userFacade.login(jsonAnswerStatusModel.getAccess_token());
                _labelWarning.setText("Успешно сохранено");
            } else if(jsonAnswerStatusModel.getStatus().equals("success")){
                _labelWarning.setText("Успешно сохранено");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_auth")){
                _userFacade.logout();
                ((MainActivity)getActivity()).changeAuthListener();
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("username_already_exist")){
                _labelWarning.setText("Логин уже зарегистрирован в базе");
            } else if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("wrong")){
                _labelWarning.setText("Текущий пароль введен не верно");
            } else {
                _labelWarning.setText("Ошибка сети");
            }
        }
    }
}