package com.example.stgonline.Model.Lesson;

public class LessonLiteModel {

    private int id;
    private String name;
    private String short_name;
    private String music_name;
    
    ...

    public LessonLiteModel(int id, String name, String short_name, String music_name ...) {
        this.id = id;
        this.name = name;
        this.short_name = short_name;
        this.music_name = music_name;
        
        ...
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    ...
    
}
