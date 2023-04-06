package com.example.stgonline.Factory.ViewModel;

import com.example.stgonline.Model.Lesson.LessonMicroModel;
import com.example.stgonline.ViewModel.Lesson.LessonMicroViewModel;

public class LessonViewModelFactory {

    public LessonMicroViewModel createMicroFromModel(LessonMicroModel lessonMicroModel){
        if(lessonMicroModel == null)return null;
        return new LessonMicroViewModel(
            lessonMicroModel.getId(),
            lessonMicroModel.getName(),
            lessonMicroModel.getDays(),
            ...
        );
    }
}
