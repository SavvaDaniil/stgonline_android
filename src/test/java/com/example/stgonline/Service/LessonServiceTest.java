package com.example.stgonline.Service;

import android.util.Log;

import com.example.stgonline.Model.JsonAnswerStatusModel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LessonServiceTest {

    private LessonService _lessonService;
    @Before
    public void init(){
        System.out.println("LessonServiceTest init");
        _lessonService = new LessonService();
    }

    @Test
    public void getLiteById(){
        int lessonId = 23;
        JsonAnswerStatusModel jsonAnswerStatusModel = _lessonService.getLiteById(lessonId, null);
        assertNotNull(jsonAnswerStatusModel.getLessonLiteViewModel());
        System.out.println(jsonAnswerStatusModel.getLessonLiteViewModel().toString());
    }

    @Test
    public void search(){
        JsonAnswerStatusModel jsonAnswerStatusModel = _lessonService.search(0, null);
        assertNotNull(jsonAnswerStatusModel.getLessonPreviewViewModels());
    }

    @Test
    public void checkAccess(){
        JsonAnswerStatusModel jsonAnswerStatusModel = _lessonService.checkAccess(0, null);
        assertNotNull(jsonAnswerStatusModel.getLessonPreviewViewModels());
    }
}
