package com.example.stgonline.Factory.ViewModel;

import com.example.stgonline.Component.DateConverterComponent;
import com.example.stgonline.Model.PurchaseLesson.PurchaseLessonLiteModel;
import com.example.stgonline.ViewModel.PurchaseLesson.PurchaseLessonLiteViewModel;

public class PurchaseLessonViewModelFactory {

    private PaymentViewModelFactory paymentViewModelFactory;
    private LessonViewModelFactory lessonViewModelFactory;
    public PurchaseLessonViewModelFactory(){
        this.paymentViewModelFactory = new PaymentViewModelFactory();
        this.lessonViewModelFactory = new LessonViewModelFactory();
    }

    public PurchaseLessonLiteViewModel createLiteFromModel(PurchaseLessonLiteModel purchaseLessonLiteModel){
        return new PurchaseLessonLiteViewModel(
            purchaseLessonLiteModel.getId(),
            purchaseLessonLiteModel.getActive(),
            purchaseLessonLiteModel.getUser_id(),
            ...
        );
    }

}
