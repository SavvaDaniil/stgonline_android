package com.example.stgonline.Factory.ViewModel;

import com.example.stgonline.Component.DateConverterComponent;
import com.example.stgonline.Model.PurchaseLesson.PurchaseLessonLiteModel;
import com.example.stgonline.Model.PurchaseSubscription.PurchaseSubscriptionLiteModel;
import com.example.stgonline.ViewModel.PurchaseSubscription.PurchaseSubscriptionLiteViewModel;

public class PurchaseSubscriptionViewModelFactory {

    private PaymentViewModelFactory paymentViewModelFactory;
    private SubscriptionViewModelFactory subscriptionViewModelFactory;

    public PurchaseSubscriptionViewModelFactory(){
        this.paymentViewModelFactory = new PaymentViewModelFactory();
        this.subscriptionViewModelFactory = new SubscriptionViewModelFactory();
    }

    public PurchaseSubscriptionLiteViewModel createLiteFromModel(PurchaseSubscriptionLiteModel purchaseSubscriptionLiteModel){
        return new PurchaseSubscriptionLiteViewModel(
                purchaseSubscriptionLiteModel.getId(),
                purchaseSubscriptionLiteModel.getActive(),
                purchaseSubscriptionLiteModel.getUser_id(),
                ...
        );
    }
}
