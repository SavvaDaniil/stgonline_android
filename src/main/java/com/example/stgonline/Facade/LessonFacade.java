package com.example.stgonline.Facade;

import android.content.Context;

import com.example.stgonline.Entity.UserData;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.Repository.UserDataRepository;
import com.example.stgonline.Service.LessonService;

public class LessonFacade {

    private Context _context;
    private LessonService lessonService;
    public LessonFacade(Context context){
        this.lessonService = new LessonService();
        _context = context;
    }

    public JsonAnswerStatusModel getVideo(int lessonId){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        if(userData == null || userData.getValue() == null)return new JsonAnswerStatusModel("error", "not_auth");

        return this.lessonService.getVideo(lessonId, userData.getValue());
    }

    public JsonAnswerStatusModel buyModelGet(int lessonId){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        if(userData == null || userData.getValue() == null)return new JsonAnswerStatusModel("error", "not_auth");

        return this.lessonService.buy(lessonId, userData.getValue());
    }

    public JsonAnswerStatusModel checkAccess(int lessonId){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        String jwt = (userData != null ? userData.getValue() : null);

        return this.lessonService.checkAccess(lessonId, jwt);
    }

    public JsonAnswerStatusModel getLiteById(int lessonId){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        String jwt = (userData != null ? userData.getValue() : null);

        return this.lessonService.getLiteById(lessonId, jwt);
    }

    public JsonAnswerStatusModel search(int skip){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        String jwt = (userData != null ? userData.getValue() : null);

        return this.lessonService.search(skip, jwt);
    }
}
