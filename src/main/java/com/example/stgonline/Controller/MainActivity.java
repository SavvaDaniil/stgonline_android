package com.example.stgonline.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.stgonline.Facade.UserFacade;
import com.example.stgonline.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton _tabMenuLessons, _tabMenuPurchaseAbonements, _tabMenuProfile;
    private UserFacade _userFacade;
    private FragmentManager _fragmentManager = getSupportFragmentManager();
    //private MainContainerState mainContainerStateCurrent = MainContainerState.LESSONS;

    private LessonsFragment _lessonsFragment;
    private PurchaseAbonementsFragment _purchaseAbonementsFragment;
    private ProfileFragment _profileFragment;

    private boolean _isNeedUpdateBecauseOfRelogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _userFacade = new UserFacade(this);
        _tabMenuLessons = (ImageButton) findViewById(R.id.tabMenuLessons);
        _tabMenuPurchaseAbonements = (ImageButton) findViewById(R.id.tabMenuPurchaseAbonements);
        _tabMenuProfile = (ImageButton) findViewById(R.id.tabMenuProfile);

        _lessonsFragment = new LessonsFragment();
        _purchaseAbonementsFragment = new PurchaseAbonementsFragment();
        _profileFragment = new ProfileFragment();

        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerView, _lessonsFragment, LessonsFragment.class.getSimpleName());
        
        ...

        fragmentTransaction.commit();

        _tabMenuLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTabMenu(TabMenuState.LESSONS);
            }
        });

        _tabMenuPurchaseAbonements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!_userFacade.isAuth()){
                    openAuthActivity();
                    return;
                }
                changeTabMenu(TabMenuState.PURCHASE_ABONEMENTS);
            }
        });

        _tabMenuProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!_userFacade.isAuth()){
                    openAuthActivity();
                    return;
                }
                changeTabMenu(TabMenuState.PROFILE);
            }
        });

    }

    private void openAuthActivity(){
        Intent intentAuthenticationActivity = new Intent(this, AuthenticationActivity.class);
        //startActivity(intentAuthenticationActivity);
        startActivityForResult(intentAuthenticationActivity, 1);
    }

    /*
    private void changeFragment(MainContainerState mainContainerState){

    }
    */

    private void changeTabMenu(TabMenuState tabMenuState){
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        switch (tabMenuState){
            case LESSONS:
                _profileFragment.hideAll();
                _purchaseAbonementsFragment.hideAll();
                fragmentTransaction.show(_lessonsFragment);

                ...

                _tabMenuLessons.setImageResource(R.drawable.home_active);
                _tabMenuPurchaseAbonements.setImageResource(R.drawable.to_do_list);
                
                ...

                break;
            case PURCHASE_ABONEMENTS:
                _profileFragment.hideAll();
                _purchaseAbonementsFragment.getListOfPurchaseLitesInit();
                
                ...

                break;
            case PROFILE:
                _purchaseAbonementsFragment.hideAll();
                _profileFragment.profileGetInit();
                
                ...

                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private enum TabMenuState {
        LESSONS,
        PURCHASE_ABONEMENTS,
        PROFILE
    }

    public void setIsNeedUpdateBecauseOfRelogin(boolean _isNeedUpdateBecauseOfRelogin) {
        this._isNeedUpdateBecauseOfRelogin = _isNeedUpdateBecauseOfRelogin;
    }

    public void changeAuthListener(){
        this.changeTabMenu(TabMenuState.LESSONS);
        _lessonsFragment.searchInitFromStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //System.out.println("MainActivity onActivityResult requestCode: " + requestCode + " resultCode: " + resultCode);
        if(requestCode == 1 && resultCode == RESULT_OK){
            //System.out.println("MainActivity onActivityResult change auth");
            this.changeAuthListener();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity onResume");
    }


    private enum MainContainerState {
        LESSONS,
        PURCHASES,
        PROFILE
    }
}

