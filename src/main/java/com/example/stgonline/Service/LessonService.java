package com.example.stgonline.Service;

import com.example.stgonline.Component.RequestComponent;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LessonService {

    private RequestComponent _requestComponent;
    public LessonService(){
        _requestComponent = new RequestComponent();
    }

    public JsonAnswerStatusModel getVideo(int lessonId, String jwt){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this._requestComponent.makeRequest(urlStr, "POST", jwt, jsonInputString);
    }

    public JsonAnswerStatusModel buy(int lessonId, String jwt){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this._requestComponent.makeRequest(urlStr, "POST", jwt, jsonInputString);
    }

    public JsonAnswerStatusModel checkAccess(int lessonId, String jwt){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this._requestComponent.makeRequest(urlStr, "POST", jwt, jsonInputString);
    }

    public JsonAnswerStatusModel getLiteById(int lessonId, String jwt){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this._requestComponent.makeRequest(urlStr, "POST", jwt, jsonInputString);
    }

    public JsonAnswerStatusModel search(int skip, String jwt){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this._requestComponent.makeRequest(urlStr, "POST", jwt, jsonInputString);
    }

}
