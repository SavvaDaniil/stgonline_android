package com.example.stgonline.Controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.stgonline.Component.GlobalVariables;
import com.example.stgonline.Model.Lesson.LessonLiteModel;
import com.example.stgonline.Model.Lesson.LessonPosterWebDataModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.LessonDownloadPosterTask;


public class LessonAboutFragment extends Fragment {

    private ImageView _lessonPosterImageView;
    private AppCompatButton _btnInitLessonAbout;
    private AppCompatButton _btnTeaser;
    private TextView _labelLessonShortName;
    private TextView _labelLessonTeacherName;
    private LinearLayout _dataLessonPrice;
    private TextView _labelLessonPrice;

    private LessonLiteModel _lessonLiteModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson_about, container, false);

        _lessonPosterImageView = (ImageView) view.findViewById(R.id.lesson_poster_image_view);
        _btnInitLessonAbout = (AppCompatButton) view.findViewById(R.id.btnInitLessonAbout);
        _btnInitLessonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LessonAboutActivity) getActivity()).checkAccessInit();
            }
        });
        _btnTeaser = (AppCompatButton) view.findViewById(R.id.btnTeaser);
        _labelLessonShortName = (TextView) view.findViewById(R.id.labelLessonShortName);
        
        ...

        _btnTeaser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ...

                Intent lessonTeaserIntent = new Intent(getActivity(), TeaserVideoActivity.class);
                lessonTeaserIntent.putExtra("lessonTeaserSrc", ...);
                startActivity(lessonTeaserIntent);
            }
        });

        return view;
    }

    public void setLessonLiteModel(LessonLiteModel lessonLiteModel){
        _lessonLiteModel = lessonLiteModel;

        if(GlobalVariables.lessonPosterByLessonIdDataCashes.containsKey(_lessonLiteModel.getId())){
            _lessonPosterImageView.setImageBitmap(GlobalVariables.lessonPosterByLessonIdDataCashes.get(_lessonLiteModel.getId()));
        } else if(_lessonLiteModel.getPoster_src() != null) {
            LessonDownloadPosterTask lessonDownloadPosterTask = new LessonDownloadPosterTask();
            lessonDownloadPosterTask.execute(
                new LessonPosterWebDataModel(
                    _lessonLiteModel.getId(),
                    _lessonPosterImageView,

                    ...
                    
                )
            );
        }

        _labelLessonShortName.setText(_lessonLiteModel.getShort_name());
        _labelLessonTeacherName.setText(_lessonLiteModel.getTeacher_name());
        _dataLessonPrice.setVisibility(_lessonLiteModel.isActive() ? View.GONE : View.VISIBLE);
        if(!_lessonLiteModel.isActive()){
            _labelLessonPrice.setText(_lessonLiteModel.getPrice_str());
            _btnInitLessonAbout.setText("Приобрести");
        } else {
            _btnInitLessonAbout.setText("Начать заниматься");
        }
    }
}