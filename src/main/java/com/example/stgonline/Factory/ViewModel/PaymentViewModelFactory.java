package com.example.stgonline.Factory.ViewModel;

import com.example.stgonline.Component.DateConverterComponent;
import com.example.stgonline.Model.Payment.PaymentMicroModel;
import com.example.stgonline.ViewModel.Payment.PaymentMicroViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentViewModelFactory {

    public PaymentMicroViewModel createMicroFromModel(PaymentMicroModel paymentMicroModel){
        if(paymentMicroModel == null)return null;

        return new PaymentMicroViewModel(
                paymentMicroModel.getId(),
                paymentMicroModel.getUser_id(),
                ...
        );
    }

}
