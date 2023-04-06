package com.example.stgonline.ViewModel.PurchaseLesson;

import com.example.stgonline.Abstract.ViewModel.Purchase.PurchaseAbstractViewModel;
import com.example.stgonline.Model.Payment.PaymentMicroModel;
import com.example.stgonline.ViewModel.Lesson.LessonMicroViewModel;
import com.example.stgonline.ViewModel.Payment.PaymentMicroViewModel;

import java.util.Date;

public class PurchaseLessonLiteViewModel extends PurchaseAbstractViewModel {

    private LessonMicroViewModel lessonMicroViewModel;

    public PurchaseLessonLiteViewModel(
            int id,
            int active,
            int userId,
            boolean isExpired,
            Date dateOfAdd,
            Date dateOfActivation,
            Date dateOfMustBeUsedTo,
            PaymentMicroViewModel paymentMicroViewModel,
            boolean isAppPaymentAvailable,
            LessonMicroViewModel lessonMicroViewModel
    ) {
        super(id, active, userId, isExpired, dateOfAdd, dateOfActivation, dateOfMustBeUsedTo, paymentMicroViewModel, isAppPaymentAvailable);
        this.lessonMicroViewModel = lessonMicroViewModel;
    }

    public LessonMicroViewModel getLessonMicroViewModel() {
        return lessonMicroViewModel;
    }

    public void setLessonMicroViewModel(LessonMicroViewModel lessonMicroViewModel) {
        this.lessonMicroViewModel = lessonMicroViewModel;
    }
}
