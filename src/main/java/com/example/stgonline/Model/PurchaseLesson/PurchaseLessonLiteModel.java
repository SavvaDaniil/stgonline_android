package com.example.stgonline.Model.PurchaseLesson;

import com.example.stgonline.Model.Lesson.LessonMicroModel;
import com.example.stgonline.Model.Payment.PaymentMicroModel;

public class PurchaseLessonLiteModel {

    public int id;
    public int active;

    public int user_id;
    
    ...

    public PaymentMicroModel paymentMicroViewModel;
    public LessonMicroModel lessonMicroViewModel;
    public boolean is_app_payment_available = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    ...

    public PaymentMicroModel getPaymentMicroViewModel() {
        return paymentMicroViewModel;
    }

    public void setPaymentMicroViewModel(PaymentMicroModel paymentMicroViewModel) {
        this.paymentMicroViewModel = paymentMicroViewModel;
    }

    public LessonMicroModel getLessonMicroViewModel() {
        return lessonMicroViewModel;
    }

    public void setLessonMicroViewModel(LessonMicroModel lessonMicroViewModel) {
        this.lessonMicroViewModel = lessonMicroViewModel;
    }

    public boolean isIs_app_payment_available() {
        return is_app_payment_available;
    }

    public void setIs_app_payment_available(boolean is_app_payment_available) {
        this.is_app_payment_available = is_app_payment_available;
    }
}
