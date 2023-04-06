package com.example.stgonline.Service;

import com.example.stgonline.Component.RequestComponent;
import com.example.stgonline.DTO.User.UserForgetDTO;
import com.example.stgonline.DTO.User.UserLoginDTO;
import com.example.stgonline.DTO.User.UserProfileMicroEditDTO;
import com.example.stgonline.DTO.User.UserRegistrationDTO;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class UserService {

    private RequestComponent requestComponent;
    public UserService(){
        this.requestComponent = new RequestComponent();
    }

    public JsonAnswerStatusModel listPurchaseLites(String jwt){
        String urlStr = "/api/v2/user/app/list_all_purchase_lites";
        return this.requestComponent.makeRequest(urlStr, "POST", jwt, null);
    }
    
    public JsonAnswerStatusModel profileUpdate(String jwt, UserProfileMicroEditDTO userProfileMicroEditDTO){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this.requestComponent.makeRequest(urlStr, "POST", jwt, jsonInputString);
    }

    public JsonAnswerStatusModel profileGet(String jwt){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this.requestComponent.makeRequest(urlStr, "POST", jwt, null);
    }

    public JsonAnswerStatusModel registration(UserRegistrationDTO userRegistrationDTO){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this.requestComponent.makeRequest(urlStr, "POST", null, jsonInputString);
    }

    public JsonAnswerStatusModel login(UserLoginDTO userLoginDTO){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this.requestComponent.makeRequest(urlStr, "POST", null, jsonInputString);
    }
    public JsonAnswerStatusModel forget(UserForgetDTO userForgetDTO){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this.requestComponent.makeRequest(urlStr, "POST", null, jsonInputString);
    }

}
