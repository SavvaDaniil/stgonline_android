package com.example.stgonline.Facade;

import android.content.Context;

import com.example.stgonline.DTO.User.UserProfileMicroEditDTO;
import com.example.stgonline.Entity.UserData;
import com.example.stgonline.Factory.ViewModel.PurchaseLessonViewModelFactory;
import com.example.stgonline.Factory.ViewModel.PurchaseSubscriptionViewModelFactory;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.Model.PurchaseLesson.PurchaseLessonLiteModel;
import com.example.stgonline.Model.PurchaseSubscription.PurchaseSubscriptionLiteModel;
import com.example.stgonline.Repository.UserDataRepository;
import com.example.stgonline.Service.UserService;
import com.example.stgonline.ViewModel.JsonAnswerStatus;
import com.example.stgonline.ViewModel.PurchaseLesson.PurchaseLessonLiteViewModel;
import com.example.stgonline.ViewModel.PurchaseSubscription.PurchaseSubscriptionLiteViewModel;

import java.util.ArrayList;

public class UserFacade {

    private Context _context;

    public UserFacade(Context context){
        _context = context;
    }

    public JsonAnswerStatus listPurchaseLites(){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        if(userData == null || userData.getValue() == null){
            return new JsonAnswerStatus("error", "not_auth");
        }
        UserService userService = new UserService();
        JsonAnswerStatusModel jsonAnswerStatusModel = userService.listPurchaseLites(userData.getValue());
        if(jsonAnswerStatusModel == null)return null;
        if(jsonAnswerStatusModel.getStatus().equals("error") && jsonAnswerStatusModel.getErrors().equals("not_auth")){
            return new JsonAnswerStatus("error", "not_auth");
        }

        PurchaseLessonViewModelFactory purchaseLessonViewModelFactory = new PurchaseLessonViewModelFactory();
        PurchaseSubscriptionViewModelFactory purchaseSubscriptionViewModelFactory = new PurchaseSubscriptionViewModelFactory();

        
        ...

        return new JsonAnswerStatus(
                jsonAnswerStatusModel.getStatus(),
                jsonAnswerStatusModel.getErrors(),
                purchaseLessonLiteViewModels,
                purchaseSubscriptionLiteViewModels
        );
    }

    public JsonAnswerStatusModel profileUpdate(UserProfileMicroEditDTO userProfileMicroEditDTO){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        if(userData == null || userData.getValue() == null){
            return new JsonAnswerStatusModel("error", "not_auth");
        }
        UserService userService = new UserService();
        return userService.profileUpdate(userData.getValue(), userProfileMicroEditDTO);
    }
    public JsonAnswerStatusModel profileGet(){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        if(userData == null || userData.getValue() == null){
            return new JsonAnswerStatusModel("error", "not_auth");
        }
        UserService userService = new UserService();
        return userService.profileGet(userData.getValue());
    }

    public boolean isAuth(){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        
        ...

        if(userData.getValue() != null)return true;
        return false;
    }

    public void login(String jwt){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        UserData userData = userDataRepository.findByName("jwt");
        
        ...
    }

    public void logout(){
        UserDataRepository userDataRepository = new UserDataRepository(_context);
        userDataRepository.listAll();
        
        ...
    }
}
