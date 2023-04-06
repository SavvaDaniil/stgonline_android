package com.example.stgonline.ViewModel.Lesson;

public class LessonMicroViewModel {

    private int id;
    private String name;
    private int days;
    private int price;
    private int active;
    private int isVisible;
    private int orderInList;
    private String posterSrc;

    public LessonMicroViewModel(
            int id,
            String name,
            int days,
            int price,
            int active,
            int isVisible,
            int orderInList,
            String posterSrc
    ) {
        this.id = id;
        this.name = name;
        this.days = days;
        this.price = price;
        this.active = active;
        this.isVisible = isVisible;
        this.orderInList = orderInList;
        this.posterSrc = posterSrc;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getOrderInList() {
        return orderInList;
    }

    public void setOrderInList(int orderInList) {
        this.orderInList = orderInList;
    }

    public String getPosterSrc() {
        return posterSrc;
    }

    public void setPosterSrc(String posterSrc) {
        this.posterSrc = posterSrc;
    }
}
