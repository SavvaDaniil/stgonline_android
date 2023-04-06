package com.example.stgonline.ViewModel.Subscription;

public class SubscriptionLiteViewModel {

    private int id;
    private String name;
    private int price;
    private int days;
    private boolean prolongation;
    private String priceStr;

    public SubscriptionLiteViewModel(int id, String name, int price, int days, boolean prolongation, String priceStr) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.days = days;
        this.prolongation = prolongation;
        this.priceStr = priceStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isProlongation() {
        return prolongation;
    }

    public void setProlongation(boolean prolongation) {
        this.prolongation = prolongation;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }
}
