package com.example.stgonline.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.example.stgonline.Abstract.ViewModel.Purchase.PurchaseAbstractViewModel;
import com.example.stgonline.Component.GlobalVariables;
import com.example.stgonline.Model.Lesson.LessonPosterWebDataModel;
import com.example.stgonline.Model.Lesson.LessonPreviewModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.LessonDownloadPosterTask;
import com.example.stgonline.ViewModel.PurchaseLesson.PurchaseLessonLiteViewModel;
import com.example.stgonline.ViewModel.PurchaseSubscription.PurchaseSubscriptionLiteViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseViewListViewAdapter extends ArrayAdapter<PurchaseAbstractViewModel> {

    private final Activity context;
    private ArrayList<PurchaseAbstractViewModel> purchaseAbstractViewModels;

    public PurchaseViewListViewAdapter(Activity context, ArrayList<PurchaseAbstractViewModel> purchaseAbstractViewModels) {
        super(context, R.layout.purchase_preview_list_view_row, purchaseAbstractViewModels);

        this.context = context;
        this.purchaseAbstractViewModels = purchaseAbstractViewModels;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.purchase_preview_list_view_row, null,true);

        TextView purchasePreviewTitle = (TextView) rowView.findViewById(R.id.purchasePreviewTitle);
        String paymentIdStr = "#<ERROR>";
        if(purchaseAbstractViewModels.get(position).getPaymentMicroViewModel() != null){
            paymentIdStr = "#" + purchaseAbstractViewModels.get(position).getPaymentMicroViewModel().getId() + " ";
        }

        String purchaseName = "<ERROR NAME OF PURCHASE>";
        if(purchaseAbstractViewModels.get(position) instanceof PurchaseLessonLiteViewModel){

            ...

        } else if(purchaseAbstractViewModels.get(position) instanceof PurchaseSubscriptionLiteViewModel){

            ...

        }

        purchasePreviewTitle.setText(paymentIdStr + purchaseName);

        LinearLayout purchasePreviewBlockState = (LinearLayout) rowView.findViewById(R.id.purchasePreviewBlockState);
        TextView purchasePreviewLabelState = (TextView) rowView.findViewById(R.id.purchasePreviewLabelState);
        if(purchaseAbstractViewModels.get(position).getDateOfActivation() == null){
            purchasePreviewLabelState.setText("не акт");
        } else if(purchaseAbstractViewModels.get(position).isExpired()){
            purchasePreviewLabelState.setText("исч");
            purchasePreviewBlockState.setBackground(getContext().getResources().getDrawable(...));
        }

        return rowView;
    };
}
