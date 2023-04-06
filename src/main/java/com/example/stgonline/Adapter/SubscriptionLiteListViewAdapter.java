package com.example.stgonline.Adapter;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stgonline.Abstract.ProductForBuyingAbstract;
import com.example.stgonline.Component.GlobalVariables;
import com.example.stgonline.Model.Lesson.LessonPosterWebDataModel;
import com.example.stgonline.Model.Lesson.LessonPreviewModel;
import com.example.stgonline.Model.Subscription.SubscriptionLiteModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.LessonDownloadPosterTask;

import java.util.ArrayList;

public class SubscriptionLiteListViewAdapter extends ArrayAdapter<ProductForBuyingAbstract> {

    private final Activity _context;
    private ArrayList<ProductForBuyingAbstract> _productsForBuying;

    public SubscriptionLiteListViewAdapter(Activity context, ArrayList<ProductForBuyingAbstract> productsForBuying) {
        super(context, R.layout.subscription_lite_view_row, productsForBuying);

        this._context = context;
        this._productsForBuying = productsForBuying;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=_context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.subscription_lite_view_row, null,true);

        TextView subscriptionLiteViewRowTitle = (TextView) rowView.findViewById(R.id.subscriptionLiteViewRowTitle);
        subscriptionLiteViewRowTitle.setText(_productsForBuying.get(position).getName());
        
        ...

        if(_productsForBuying.get(position).isActiveForBuying()){
            LinearLayout subscriptionLiteViewRowBlock = (LinearLayout) rowView.findViewById(R.id.subscriptionLiteViewRowBlock);
            subscriptionLiteViewRowBlock.setBackground(getContext().getResources().getDrawable(...));
        }

        return rowView;
    };
}
