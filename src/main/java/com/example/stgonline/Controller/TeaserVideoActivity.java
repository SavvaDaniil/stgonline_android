package com.example.stgonline.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.stgonline.R;

public class TeaserVideoActivity extends AppCompatActivity {

    private VideoView _videoLessonTeaserView;
    private ImageButton _btnClose;
    private String _lessonTeaserSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaser_video);

        _btnClose = (ImageButton) findViewById(R.id.btnClose);
        _btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releasePlayer();
                finish();
            }
        });

        _videoLessonTeaserView = (VideoView) findViewById(R.id.videoLessonTeaserView);

        Bundle extras = getIntent().getExtras();
        _lessonTeaserSrc = extras.getString("lessonTeaserSrc");
        if(_lessonTeaserSrc != null){

            Uri uri = Uri.parse(_lessonTeaserSrc);
            _videoLessonTeaserView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(_videoLessonTeaserView);
           
            ...

            _videoLessonTeaserView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    _videoLessonTeaserView.start();
                }
            });

        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            _videoLessonTeaserView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    private void releasePlayer() {
        _videoLessonTeaserView.stopPlayback();
    }
}