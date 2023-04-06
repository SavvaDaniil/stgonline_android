package com.example.stgonline.DTO.Lesson;

import com.example.stgonline.DTO.Video.VideoLiteModel;

public class LessonVideoModel {

    public int id;
    public VideoLiteModel videoLiteViewModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VideoLiteModel getVideoLiteViewModel() {
        return videoLiteViewModel;
    }

    public void setVideoLiteViewModel(VideoLiteModel videoLiteViewModel) {
        this.videoLiteViewModel = videoLiteViewModel;
    }
}
