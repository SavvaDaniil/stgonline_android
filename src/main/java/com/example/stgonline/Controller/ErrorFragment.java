package com.example.stgonline.Controller;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stgonline.Interface.ITryAgain;
import com.example.stgonline.R;

public class ErrorFragment extends Fragment {

    private View _inflaterView;
    private AppCompatButton _btnTryAgain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_error, container, false);
        _btnTryAgain = (AppCompatButton) view.findViewById(R.id.btnTryAgain);

        return view;
    }

    public void setTryAgainFunctionToBtnTryAgain(ITryAgain iTryAgain){
        _btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTryAgain.tryAgain();
            }
        });
    }
}