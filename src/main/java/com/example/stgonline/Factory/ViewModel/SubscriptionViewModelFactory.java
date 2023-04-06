package com.example.stgonline.Factory.ViewModel;

import com.example.stgonline.Model.Subscription.SubscriptionLiteModel;
import com.example.stgonline.ViewModel.Subscription.SubscriptionLiteViewModel;

public class SubscriptionViewModelFactory {

    public SubscriptionLiteViewModel createLiteFromModel(SubscriptionLiteModel subscriptionLiteModel){
        if(subscriptionLiteModel == null)return null;
        return new SubscriptionLiteViewModel(
            subscriptionLiteModel.getId(),
            subscriptionLiteModel.getName(),
            ...
        );
    }
}
