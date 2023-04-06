package com.example.stgonline.Facade;

import android.content.Context;

import com.example.stgonline.DTO.Payment.PaymentNewDTO;
import com.example.stgonline.Entity.UserData;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.Repository.UserDataRepository;
import com.example.stgonline.Service.PaymentService;

public class PaymentFacade {

    private Context context;
    private PaymentService paymentService;
    public PaymentFacade(Context context){
        this.context = context;
        this.paymentService = new PaymentService();
    }

    public JsonAnswerStatusModel initNew(PaymentNewDTO paymentNewDTO){
        UserDataRepository userDataRepository = new UserDataRepository(this.context);
        UserData userData = userDataRepository.findByName("jwt");
        if(userData == null || userData.getValue() == null)return new JsonAnswerStatusModel("error", "not_auth");

        return this.paymentService.initNew(
            paymentNewDTO.getLessonId(),
            paymentNewDTO.getSubscriptionId(),
            
            ...
        );
    }

}
