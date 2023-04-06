package com.example.stgonline.ViewModel.Subscription;

import com.example.stgonline.Abstract.ProductForBuyingAbstract;

public class SubscriptionProductForBuying extends ProductForBuyingAbstract {

    public SubscriptionProductForBuying(int id, String name, int price, String priceStr) {
        super(id, name, price, priceStr);
    }

    public SubscriptionProductForBuying(int id, String name, int price, String priceStr, boolean isActiveForBuying) {
        super(id, name, price, priceStr, isActiveForBuying);
    }
}
