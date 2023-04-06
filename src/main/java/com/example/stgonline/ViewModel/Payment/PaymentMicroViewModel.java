package com.example.stgonline.ViewModel.Payment;

import java.util.Date;

public class PaymentMicroViewModel {

    private int id;
    private int userId;
    private int price;
    private int status;
    private Date dateOfPayed;

    public PaymentMicroViewModel(int id, int userId, int price, int status, Date dateOfPayed) {
        this.id = id;
        this.userId = userId;
        this.price = price;
        this.status = status;
        this.dateOfPayed = dateOfPayed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDateOfPayed() {
        return dateOfPayed;
    }

    public void setDateOfPayed(Date dateOfPayed) {
        this.dateOfPayed = dateOfPayed;
    }
}
