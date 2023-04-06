package com.example.stgonline.ViewModel;

import com.example.stgonline.ViewModel.PurchaseLesson.PurchaseLessonLiteViewModel;
import com.example.stgonline.ViewModel.PurchaseSubscription.PurchaseSubscriptionLiteViewModel;

import java.util.ArrayList;

public class JsonAnswerStatus {

    private String status;
    private String errors;
    private ArrayList<PurchaseLessonLiteViewModel> purchaseLessonLiteViewModels;
    private ArrayList<PurchaseSubscriptionLiteViewModel> purchaseSubscriptionLiteViewModels;

    public JsonAnswerStatus(String status, String errors) {
        this.status = status;
        this.errors = errors;
    }

    public JsonAnswerStatus(String status, String errors, ArrayList<PurchaseLessonLiteViewModel> purchaseLessonLiteViewModels, ArrayList<PurchaseSubscriptionLiteViewModel> purchaseSubscriptionLiteViewModels) {
        this.status = status;
        this.errors = errors;
        this.purchaseLessonLiteViewModels = purchaseLessonLiteViewModels;
        this.purchaseSubscriptionLiteViewModels = purchaseSubscriptionLiteViewModels;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }


    public ArrayList<PurchaseLessonLiteViewModel> getPurchaseLessonLiteViewModels() {
        return purchaseLessonLiteViewModels;
    }

    public void setPurchaseLessonLiteViewModels(ArrayList<PurchaseLessonLiteViewModel> purchaseLessonLiteViewModels) {
        this.purchaseLessonLiteViewModels = purchaseLessonLiteViewModels;
    }

    public ArrayList<PurchaseSubscriptionLiteViewModel> getPurchaseSubscriptionLiteViewModels() {
        return purchaseSubscriptionLiteViewModels;
    }

    public void setPurchaseSubscriptionLiteViewModels(ArrayList<PurchaseSubscriptionLiteViewModel> purchaseSubscriptionLiteViewModels) {
        this.purchaseSubscriptionLiteViewModels = purchaseSubscriptionLiteViewModels;
    }
}
