package com.example.stgonline.Controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.stgonline.Abstract.ViewModel.Purchase.PurchaseAbstractViewModel;
import com.example.stgonline.Adapter.PurchaseViewListViewAdapter;
import com.example.stgonline.Model.Subscription.SubscriptionLiteModel;
import com.example.stgonline.R;
import com.example.stgonline.ViewModel.Lesson.LessonMicroViewModel;
import com.example.stgonline.ViewModel.Payment.PaymentMicroViewModel;
import com.example.stgonline.ViewModel.PurchaseLesson.PurchaseLessonLiteViewModel;
import com.example.stgonline.ViewModel.PurchaseSubscription.PurchaseSubscriptionLiteViewModel;
import com.example.stgonline.ViewModel.Subscription.SubscriptionLiteViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseAbonementsViewFragment extends Fragment {

    private ListView purchaseViewListViewPurchaseLites;
    private PurchaseViewListViewAdapter purchaseViewListViewAdapter;
    private ArrayList<PurchaseAbstractViewModel> purchaseAbstractViewModels = new ArrayList<PurchaseAbstractViewModel>();

    public PurchaseAbonementsViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        System.out.println("PurchaseAbonementsViewFragment onCreateView");

        View view = inflater.inflate(R.layout.fragment_purchase_abonements_view, container, false);

        purchaseViewListViewPurchaseLites = (ListView) view.findViewById(R.id.purchaseViewListViewPurchaseLites);
        purchaseViewListViewAdapter = new PurchaseViewListViewAdapter(getActivity(), this.purchaseAbstractViewModels);
        purchaseViewListViewPurchaseLites.setAdapter(purchaseViewListViewAdapter);

        purchaseViewListViewPurchaseLites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("PurchaseAbonementsViewFragment onItemClick position: " + position);
                ...
            }
        });

        return view;
    }

    private void setupUI(){
        if(purchaseViewListViewPurchaseLites != null)return;

    }

    public void setup(
            ArrayList<PurchaseLessonLiteViewModel> purchaseLessonLiteViewModels,
            ArrayList<PurchaseSubscriptionLiteViewModel> purchaseSubscriptionLiteViewModels
    ){
        if(purchaseViewListViewPurchaseLites == null){
            System.out.println("PurchaseAbonementsViewFragment purchaseViewListViewPurchaseLites IS NULL");
        }
        //System.out.println("PurchaseAbonementsViewFragment setup");
        this.purchaseAbstractViewModels.clear();
        ArrayList<PurchaseAbstractViewModel> purchaseAbstractViewModels = new ArrayList<PurchaseAbstractViewModel>();
        
        ...

        Collections.sort(purchaseAbstractViewModels, (a, b) ->  b.getDateOfAdd().compareTo(a.getDateOfAdd()));
        this.purchaseAbstractViewModels.addAll(purchaseAbstractViewModels);
    }

    private void openPurachaseAboutByPositionInArrayList(int position){

        Intent purchaseAboutIntent = new Intent(getActivity(), PurchaseAboutActivity.class);

        if(purchaseAbstractViewModels.get(position) instanceof PurchaseLessonLiteViewModel){
            purchaseAboutIntent.putExtra("title", "Оплата доступа к уроку:");
            if(((PurchaseLessonLiteViewModel) purchaseAbstractViewModels.get(position)).getLessonMicroViewModel() != null){
                LessonMicroViewModel lessonMicroViewModel = ((PurchaseLessonLiteViewModel) purchaseAbstractViewModels.get(position))
                        .getLessonMicroViewModel();
                purchaseAboutIntent.putExtra("XXXXXXXXXX", ... );
                purchaseAboutIntent.putExtra("XXXXXXXXXX", ... );
            }

        } else if(purchaseAbstractViewModels.get(position) instanceof PurchaseSubscriptionLiteViewModel){
            SubscriptionLiteViewModel subscriptionLiteViewModel = ((PurchaseSubscriptionLiteViewModel) purchaseAbstractViewModels.get(position))
                    .getSubscriptionLiteViewModel();
            purchaseAboutIntent.putExtra("title", "Оплата доступа:");

            ...

        }
        if(purchaseAbstractViewModels.get(position).getPaymentMicroViewModel() != null){
            PaymentMicroViewModel paymentMicroViewModel = purchaseAbstractViewModels.get(position).getPaymentMicroViewModel();
            purchaseAboutIntent.putExtra("paymentId", Integer.toString(paymentMicroViewModel.getId()));

            ...

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            String dateOfPayedStr = (paymentMicroViewModel != null
                    ? simpleDateFormat.format(paymentMicroViewModel.getDateOfPayed())
                    : "<ошибка даты оплаты>");
            purchaseAboutIntent.putExtra("XXXXXXXXXXXXXXXXXX", ...);
        }
        purchaseAboutIntent.putExtra("purchaseId", Integer.toString(purchaseAbstractViewModels.get(position).getId()));

        SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat("dd.MM.yyyy");
        purchaseAboutIntent.putExtra("XXXXXXXXXXXXXXXXXX", (purchaseAbstractViewModels.get(position).getDateOfActivation() != null
                ? simpleDateFormatForDate.format(purchaseAbstractViewModels.get(position).getDateOfActivation())
                : "- не активировано"));

        startActivity(purchaseAboutIntent);
    }
}