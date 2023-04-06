package com.example.stgonline.Model.Lesson;

import com.example.stgonline.Model.Subscription.SubscriptionLiteModel;

import java.util.ArrayList;

public class LessonBuyModel {

    public int id;
    public LessonLiteModel lessonLiteViewModel;
    ...
    public boolean is_app_buy_available = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LessonLiteModel getLessonLiteViewModel() {
        return lessonLiteViewModel;
    }

    public void setLessonLiteViewModel(LessonLiteModel lessonLiteViewModel) {
        this.lessonLiteViewModel = lessonLiteViewModel;
    }

    ...

    public boolean isIs_app_buy_available() {
        return is_app_buy_available;
    }

    public void setIs_app_buy_available(boolean is_app_buy_available) {
        this.is_app_buy_available = is_app_buy_available;
    }
}
