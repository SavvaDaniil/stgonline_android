package com.example.stgonline.Model.Lesson;

import android.content.Context;
import android.widget.ImageView;

public class LessonPosterWebDataModel {

    private int lessonId;
    ...

    public LessonPosterWebDataModel(int lessonId, ImageView imageView, String url) {
        this.lessonId = lessonId;
        ...
    }

    public int getLessonId() {
        return lessonId;
    }
    
    ...
}
