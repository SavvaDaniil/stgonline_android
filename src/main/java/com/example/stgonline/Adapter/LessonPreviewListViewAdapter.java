package com.example.stgonline.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.stgonline.Component.GlobalVariables;
import com.example.stgonline.Model.Lesson.LessonPosterWebDataModel;
import com.example.stgonline.Model.Lesson.LessonPreviewModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.LessonDownloadPosterTask;

import java.util.ArrayList;
import java.util.Locale;

public class LessonPreviewListViewAdapter extends ArrayAdapter<LessonPreviewModel> {

    private final Activity _context;
    private ArrayList<LessonPreviewModel> _lessonPreviewModels;

    public LessonPreviewListViewAdapter(Activity context, ArrayList<LessonPreviewModel> lessonPreviewModels) {
        super(context, R.layout.lesson_preview_list_view_row, lessonPreviewModels);

        this._context = context;
        this._lessonPreviewModels = lessonPreviewModels;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=_context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.lesson_preview_list_view_row, null,true);

        TextView labelLessonTypeName = (TextView) rowView.findViewById(R.id.labelLessonTypeName);
        labelLessonTypeName.setText(_lessonPreviewModels.get(position).getLesson_type_name().toLowerCase());

        
        ...

        if(_lessonPreviewModels.get(position).getShort_name().length() > 20){
            int paddingDp = 60;
            float density = getContext().getResources().getDisplayMetrics().density;
            int paddingPixel = (int)(paddingDp * density);
            
            ...

        }

        ImageView lessonPosterImageView = (ImageView) rowView.findViewById(R.id.lesson_poster_image_view);

        if(GlobalVariables.lessonPosterByLessonIdDataCashes.containsKey(_lessonPreviewModels.get(position).getId())){
            lessonPosterImageView.setImageBitmap(GlobalVariables.lessonPosterByLessonIdDataCashes.get(_lessonPreviewModels.get(position).getId()));
        } else {
            LessonDownloadPosterTask lessonDownloadPosterTask = new LessonDownloadPosterTask();
            lessonDownloadPosterTask.execute(
                new LessonPosterWebDataModel(
                    
                    ...

                )
            );
        }

        return rowView;
    };

}
