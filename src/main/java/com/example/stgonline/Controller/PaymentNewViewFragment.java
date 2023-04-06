package com.example.stgonline.Controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.stgonline.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class PaymentNewViewFragment extends Fragment {

    private WebView paymentNewWebView;

    public PaymentNewViewFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_new_view, container, false);

        paymentNewWebView = (WebView) view.findViewById(R.id.paymentNewWebView);
        paymentNewWebView.setWebViewClient(new WebViewClient());
        
        ...

        paymentNewWebView.addJavascriptInterface(new WepAppInterface(), "XXXXXXXXXXXXXXXXXXXXXXXXXXX");

        return view;
    }


    public void setup(String payment_url){
        paymentNewWebView.loadUrl(payment_url);
    }

    public void paymentSuccessfullyPayed(){
        ((LessonBuyActivity) getActivity()).setPaymentPayedSuccessfully(true);
    }

    public void closeBecauseOfPaymentSuccessfullyPayed(){
        paymentSuccessfullyPayed();
        ((LessonBuyActivity) getActivity()).close();
    }

    private class WepAppInterface {

        @JavascriptInterface
        public void XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX(){
            closeBecauseOfPaymentSuccessfullyPayed();
        }

    }
}