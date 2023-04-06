package com.example.stgonline.Service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.example.stgonline.Component.GlobalVariables;
import com.example.stgonline.Model.Lesson.LessonPosterWebDataModel;
import com.example.stgonline.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.ContentValues.TAG;

public class LessonDownloadPosterTask extends AsyncTask<LessonPosterWebDataModel, Integer, Bitmap> {

    private int lessonId;
    ImageView imageView = null;
    private InputStream _urlInputStream;


    @Override
    protected Bitmap doInBackground(LessonPosterWebDataModel... lessonPosterWebDataModels) {
        lessonId = lessonPosterWebDataModels[0].getLessonId();
        imageView = lessonPosterWebDataModels[0].getImageView();

        try {
            URL url = new URL(lessonPosterWebDataModels[0].getUrl());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            
            ...
        } catch (IOException e) {
            Log.w(TAG,"failed to load image from " + lessonPosterWebDataModels[0].getUrl(), e);
        } catch (Exception e) {
            Log.w(TAG,"failed to load image from " + lessonPosterWebDataModels[0].getUrl(), e);
        } finally {
            if (this._urlInputStream != null) {
                try {
                    this._urlInputStream.close();
                } catch (IOException e) {

                } finally {
                    this._urlInputStream = null;
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap != null){
            this.imageView.setImageBitmap(bitmap);
            GlobalVariables.lessonPosterByLessonIdDataCashes.put(lessonId, bitmap);
        }
    }
}
