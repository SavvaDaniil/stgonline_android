package com.example.stgonline.Controller;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.stgonline.Abstract.ProductForBuyingAbstract;
import com.example.stgonline.Adapter.SubscriptionLiteListViewAdapter;
import com.example.stgonline.DTO.Payment.PaymentNewDTO;
import com.example.stgonline.Model.Lesson.LessonBuyModel;
import com.example.stgonline.Model.Lesson.LessonLiteModel;
import com.example.stgonline.Model.Subscription.SubscriptionLiteModel;
import com.example.stgonline.R;
import com.example.stgonline.ViewModel.Lesson.LessonProductForBuying;
import com.example.stgonline.ViewModel.Subscription.SubscriptionProductForBuying;

import java.util.ArrayList;
import java.util.List;


public class LessonBuyViewFragment extends Fragment {

    private int _lessonId = 0;
    private TextView _lessonBuyTitle;
    private ListView _subscriptionLitesListView;
    private SubscriptionLiteListViewAdapter _subscriptionLiteListViewAdapter;
    private ArrayList<ProductForBuyingAbstract> _productsForBuying = new ArrayList<ProductForBuyingAbstract>();
    private AppCompatButton _btnBuy;
    private int _productIdForBuyingChosen = 0;
    private boolean _isAlreadyLaunched = false;

    public LessonBuyViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson_buy_view, container, false);
        _lessonBuyTitle = (TextView) view.findViewById(R.id.lessonBuyTitle);
        _subscriptionLitesListView = (ListView) view.findViewById(R.id.subscriptionLitesListView);
        _subscriptionLiteListViewAdapter = new SubscriptionLiteListViewAdapter(getActivity(), _productsForBuying);
        _subscriptionLitesListView.setAdapter(_subscriptionLiteListViewAdapter);
        _subscriptionLitesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeActiveProductForBuying(_productsForBuying.get(position).getId());
            }
        });
        _btnBuy = (AppCompatButton) view.findViewById(R.id.btnBuy);
        _btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LessonBuyActivity) getActivity()).buy(
                    new PaymentNewDTO(

                        ...

                    )
                );
            }
        });

        return view;
    }

    private void changeActiveProductForBuying(int productForBuyingId){
        _productIdForBuyingChosen = productForBuyingId;
        for(int i = 0; i < _productsForBuying.size(); i++){
            _productsForBuying.get(i).setActiveForBuying(_productsForBuying.get(i).getId() == productForBuyingId);
        }
        _subscriptionLiteListViewAdapter.notifyDataSetChanged();
    }

    public void _setLessonBuyTitle(String title){
        _lessonBuyTitle.setText("Оплата доступа к уроку: \n" + title);
    }

    public void setProductsForBuying(ArrayList<SubscriptionLiteModel> subscriptionLiteModels, LessonLiteModel lessonLiteModel){

        if(subscriptionLiteModels != null){
            for(SubscriptionLiteModel subscriptionLiteModel : subscriptionLiteModels){
                _productsForBuying.add(
                        new SubscriptionProductForBuying(
                                ...
                        )
                );
                if(!_isAlreadyLaunched){
                    _productIdForBuyingChosen = subscriptionLiteModel.getId();
                    _isAlreadyLaunched = true;
                }
            }
        }

        if(lessonLiteModel != null){
            _lessonId = lessonLiteModel.getId();
            _setLessonBuyTitle(lessonLiteModel.getShort_name());
            _productsForBuying.add(
                new LessonProductForBuying(
                    0,
                    "Разовый доступ на " + lessonLiteModel.getDays() + " дней",
                    
                    ...
                    
                )
            );
        }
    }

}