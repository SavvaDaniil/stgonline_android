package com.example.stgonline.Model;

import com.example.stgonline.DTO.Lesson.LessonVideoModel;
import com.example.stgonline.Model.Lesson.LessonBuyModel;
import com.example.stgonline.Model.Lesson.LessonLiteModel;
import com.example.stgonline.Model.Lesson.LessonPreviewModel;
import com.example.stgonline.Model.Payment.PaymentNewResultModel;
import com.example.stgonline.Model.PurchaseLesson.PurchaseLessonLiteModel;
import com.example.stgonline.Model.PurchaseSubscription.PurchaseSubscriptionLiteModel;
import com.example.stgonline.Model.Subscription.SubscriptionLiteModel;
import com.example.stgonline.Model.User.UserProfileModel;

import java.util.ArrayList;

public class JsonAnswerStatusModel {
    private String status;
    private String errors;
    private String access_token;
    private int forget_id;
    private ArrayList<LessonPreviewModel> lessonPreviewViewModels;
    private LessonLiteModel lessonLiteViewModel;
    private UserProfileModel userProfileViewModel;
    private LessonBuyModel lessonBuyViewModel;
    public ArrayList<SubscriptionLiteModel> subscriptionLiteViewModels;
    public PaymentNewResultModel paymentNewResultViewModel;
    public LessonVideoModel lessonVideoViewModel;
    public ArrayList<PurchaseLessonLiteModel> purchaseLessonLiteViewModels;
    public ArrayList<PurchaseSubscriptionLiteModel> purchaseSubscriptionLiteViewModels;

    public JsonAnswerStatusModel() {}

    public JsonAnswerStatusModel(String status, String errors) {
        this.status = status;
        this.errors = errors;
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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getForget_id() {
        return forget_id;
    }

    public void setForget_id(int forget_id) {
        this.forget_id = forget_id;
    }

    public ArrayList<LessonPreviewModel> getLessonPreviewViewModels() {
        return lessonPreviewViewModels;
    }

    public void setLessonPreviewViewModels(ArrayList<LessonPreviewModel> lessonPreviewViewModels) {
        this.lessonPreviewViewModels = lessonPreviewViewModels;
    }

    public LessonLiteModel getLessonLiteViewModel() {
        return lessonLiteViewModel;
    }

    public void setLessonLiteViewModel(LessonLiteModel lessonLiteViewModel) {
        this.lessonLiteViewModel = lessonLiteViewModel;
    }

    public UserProfileModel getUserProfileViewModel() {
        return userProfileViewModel;
    }

    public void setUserProfileViewModel(UserProfileModel userProfileViewModel) {
        this.userProfileViewModel = userProfileViewModel;
    }

    public LessonBuyModel getLessonBuyViewModel() {
        return lessonBuyViewModel;
    }

    public void setLessonBuyViewModel(LessonBuyModel lessonBuyViewModel) {
        this.lessonBuyViewModel = lessonBuyViewModel;
    }

    public ArrayList<SubscriptionLiteModel> getSubscriptionLiteViewModels() {
        return subscriptionLiteViewModels;
    }

    public void setSubscriptionLiteViewModels(ArrayList<SubscriptionLiteModel> subscriptionLiteViewModels) {
        this.subscriptionLiteViewModels = subscriptionLiteViewModels;
    }

    public PaymentNewResultModel getPaymentNewResultViewModel() {
        return paymentNewResultViewModel;
    }

    public void setPaymentNewResultViewModel(PaymentNewResultModel paymentNewResultViewModel) {
        this.paymentNewResultViewModel = paymentNewResultViewModel;
    }

    public LessonVideoModel getLessonVideoViewModel() {
        return lessonVideoViewModel;
    }

    public void setLessonVideoViewModel(LessonVideoModel lessonVideoViewModel) {
        this.lessonVideoViewModel = lessonVideoViewModel;
    }

    public ArrayList<PurchaseLessonLiteModel> getPurchaseLessonLiteViewModels() {
        return purchaseLessonLiteViewModels;
    }

    public void setPurchaseLessonLiteViewModels(ArrayList<PurchaseLessonLiteModel> purchaseLessonLiteViewModels) {
        this.purchaseLessonLiteViewModels = purchaseLessonLiteViewModels;
    }

    public ArrayList<PurchaseSubscriptionLiteModel> getPurchaseSubscriptionLiteViewModels() {
        return purchaseSubscriptionLiteViewModels;
    }

    public void setPurchaseSubscriptionLiteViewModels(ArrayList<PurchaseSubscriptionLiteModel> purchaseSubscriptionLiteViewModels) {
        this.purchaseSubscriptionLiteViewModels = purchaseSubscriptionLiteViewModels;
    }
}
