package com.example.stgonline.ViewModel.PurchaseSubscription;

import com.example.stgonline.Abstract.ViewModel.Purchase.PurchaseAbstractViewModel;
import com.example.stgonline.ViewModel.Payment.PaymentMicroViewModel;
import com.example.stgonline.ViewModel.Subscription.SubscriptionLiteViewModel;

import java.util.Date;

public class PurchaseSubscriptionLiteViewModel extends PurchaseAbstractViewModel {

    private SubscriptionLiteViewModel subscriptionLiteViewModel;

    public PurchaseSubscriptionLiteViewModel(
            int id,
            int active,
            int userId,
            boolean isExpired,
            Date dateOfAdd,
            Date dateOfActivation,
            Date dateOfMustBeUsedTo,
            PaymentMicroViewModel paymentMicroViewModel,
            boolean isAppPaymentAvailable,
            SubscriptionLiteViewModel subscriptionLiteViewModel
    ) {
        super(id, active, userId, isExpired, dateOfAdd, dateOfActivation, dateOfMustBeUsedTo, paymentMicroViewModel, isAppPaymentAvailable);
        this.subscriptionLiteViewModel = subscriptionLiteViewModel;
    }

    public SubscriptionLiteViewModel getSubscriptionLiteViewModel() {
        return subscriptionLiteViewModel;
    }

    public void setSubscriptionLiteViewModel(SubscriptionLiteViewModel subscriptionLiteViewModel) {
        this.subscriptionLiteViewModel = subscriptionLiteViewModel;
    }
}
