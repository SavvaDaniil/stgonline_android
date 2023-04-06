package com.example.stgonline.Component;

import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class RequestComponent {

    private final String BASE_DOMAIN = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    public JsonAnswerStatusModel makeRequest(String urlPartStr, String method, String jwt, String postDataStr){
        JsonAnswerStatusModel jsonAnswerStatusModel = null;
        String responseString;
        try {
            URL url = new URL(BASE_DOMAIN + urlPartStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            if(jwt != null){
                httpURLConnection.setRequestProperty("Authorization", "Bearer " + jwt);
            }
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            
            ...

            
            if(httpURLConnection.getResponseCode() == HttpsURLConnection.HTTP_OK){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                
                ...

                responseString = stringBuilder.toString();
                jsonAnswerStatusModel = new Gson().fromJson(responseString, JsonAnswerStatusModel.class);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
        }
        return jsonAnswerStatusModel;
    }
}
