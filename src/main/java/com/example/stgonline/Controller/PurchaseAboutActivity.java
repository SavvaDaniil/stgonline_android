package com.example.stgonline.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.stgonline.Abstract.ViewModel.Purchase.PurchaseAbstractViewModel;
import com.example.stgonline.Component.DateConverterComponent;
import com.example.stgonline.R;
import com.example.stgonline.ViewModel.PurchaseLesson.PurchaseLessonLiteViewModel;
import com.example.stgonline.ViewModel.PurchaseSubscription.PurchaseSubscriptionLiteViewModel;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseAboutActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private PurchaseAbstractViewModel purchaseAbstractViewModel;
    private TextView purchaseAboutTitle;
    private TextView purchaseAboutName;
    private TextView purchaseAboutPaymentId;
    private TextView purchaseAboutDateOfPayed;
    private TextView purchaseAboutPaymentPrice;
    private TextView purchaseAboutPurchaseId;
    private TextView purchaseAboutDays;
    private TextView purchaseAboutDateOfActivation;
    private TextView purchaseAboutDateOfMustBeUsedTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_about);

        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        purchaseAboutTitle = (TextView) findViewById(R.id.purchaseAboutTitle);
        purchaseAboutTitle.setText(bundle.getString("XXXXXXXXXXXXXXXXXXX"));
        purchaseAboutName = (TextView) findViewById(R.id.purchaseAboutName);
        purchaseAboutName.setText(bundle.getString("XXXXXXXXXXXXXXXXXXX"));
        
        ...
    }



}