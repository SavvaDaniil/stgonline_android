package com.example.stgonline.Service;

import com.example.stgonline.Component.RequestComponent;
import com.example.stgonline.Model.JsonAnswerStatusModel;

public class PaymentService {

    private RequestComponent _requestComponent;

    public PaymentService(){
        _requestComponent = new RequestComponent();
    }

    public JsonAnswerStatusModel initNew(int lessonId, int subscriptionId, int courseId, String jwt){
        String urlStr = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
        String jsonInputString = "{\"XXXXXXXXXXXXXXXXXXXXXXXXXX\": "+0 + "...}";
        return this._requestComponent.makeRequest(urlStr, "POST", jwt, jsonInputString);
    }

}
