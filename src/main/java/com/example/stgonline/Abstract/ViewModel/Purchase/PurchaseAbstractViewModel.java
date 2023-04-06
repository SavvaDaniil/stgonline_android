package com.example.stgonline.Abstract.ViewModel.Purchase;

import com.example.stgonline.Model.Payment.PaymentMicroModel;
import com.example.stgonline.ViewModel.Payment.PaymentMicroViewModel;

import java.util.Date;

public class PurchaseAbstractViewModel {

    private int id;
    private int active;

    private int userId;

    private boolean isExpired;
    private Date dateOfAdd;
    private Date dateOfActivation;
    private Date dateOfMustBeUsedTo;

    private PaymentMicroViewModel paymentMicroViewModel;
    private boolean isAppPaymentAvailable = false;

    public PurchaseAbstractViewModel(int id, int active, int userId, boolean isExpired, Date dateOfAdd, Date dateOfActivation, Date dateOfMustBeUsedTo, PaymentMicroViewModel paymentMicroViewModel, boolean isAppPaymentAvailable) {
        this.id = id;
        this.active = active;
        this.userId = userId;
        this.isExpired = isExpired;
        this.dateOfAdd = dateOfAdd;
        this.dateOfActivation = dateOfActivation;
        this.dateOfMustBeUsedTo = dateOfMustBeUsedTo;
        this.paymentMicroViewModel = paymentMicroViewModel;
        this.isAppPaymentAvailable = isAppPaymentAvailable;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    public Date getDateOfActivation() {
        return dateOfActivation;
    }

    public void setDateOfActivation(Date dateOfActivation) {
        this.dateOfActivation = dateOfActivation;
    }

    public Date getDateOfMustBeUsedTo() {
        return dateOfMustBeUsedTo;
    }

    public void setDateOfMustBeUsedTo(Date dateOfMustBeUsedTo) {
        this.dateOfMustBeUsedTo = dateOfMustBeUsedTo;
    }

    public PaymentMicroViewModel getPaymentMicroViewModel() {
        return paymentMicroViewModel;
    }

    public void setPaymentMicroViewModel(PaymentMicroViewModel paymentMicroViewModel) {
        this.paymentMicroViewModel = paymentMicroViewModel;
    }

    public boolean isAppPaymentAvailable() {
        return isAppPaymentAvailable;
    }

    public void setAppPaymentAvailable(boolean appPaymentAvailable) {
        isAppPaymentAvailable = appPaymentAvailable;
    }
}
