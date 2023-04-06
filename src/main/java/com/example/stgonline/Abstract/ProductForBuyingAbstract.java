package com.example.stgonline.Abstract;

public abstract class ProductForBuyingAbstract {

    private int id;
    private String name;
    private int price;
    private String priceStr;
    private boolean isActiveForBuying = false;

    public ProductForBuyingAbstract(int id, String name, int price, String priceStr) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceStr = priceStr;
    }

    public ProductForBuyingAbstract(int id, String name, int price, String priceStr, boolean isActiveForBuying) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceStr = priceStr;
        this.isActiveForBuying = isActiveForBuying;
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

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public boolean isActiveForBuying() {
        return isActiveForBuying;
    }

    public void setActiveForBuying(boolean activeForBuying) {
        isActiveForBuying = activeForBuying;
    }
}
