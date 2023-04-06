package com.example.stgonline.Model.Lesson;

public class LessonPreviewModel {

    private int id;
    private String name;
    private String short_name;
    private boolean active;
    ...

    public LessonPreviewModel(int id, String name, String short_name, boolean active, ...) {
        this.id = id;
        this.name = name;
        this.short_name = short_name;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    ...
}
