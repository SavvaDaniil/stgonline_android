package com.example.stgonline.Model.Payment;

public class PaymentNewResultModel {

    public String payment_url;
    public int error_code;
    ...

    public String getPayment_url() {
        return payment_url;
    }

    public void setPayment_url(String payment_url) {
        this.payment_url = payment_url;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    ...
}
