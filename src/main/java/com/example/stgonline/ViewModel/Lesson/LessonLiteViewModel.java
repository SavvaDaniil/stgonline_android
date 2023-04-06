package com.example.stgonline.ViewModel.Lesson;

public class LessonLiteViewModel {
    private int id;
    private String name;
    private String shortName;
    private String musicName;
    private int price;
    private String priceStr;
    private boolean isAiAvailable;

    private String levelName;
    private String lessonTypeName;
    private String styleName;
    private String teacherName;

    private String posterSrc;
    private String teaserSrc;

    private boolean isAppPaymentAvailable;

    public LessonLiteViewModel(int id, String name, String shortName, String musicName, int price, String priceStr, boolean isAiAvailable, String levelName, String lessonTypeName, String styleName, String teacherName, String posterSrc, String teaserSrc, boolean isAppPaymentAvailable) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.musicName = musicName;
        this.price = price;
        this.priceStr = priceStr;
        this.isAiAvailable = isAiAvailable;
        this.levelName = levelName;
        this.lessonTypeName = lessonTypeName;
        this.styleName = styleName;
        this.teacherName = teacherName;
        this.posterSrc = posterSrc;
        this.teaserSrc = teaserSrc;
        this.isAppPaymentAvailable = isAppPaymentAvailable;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public boolean isAiAvailable() {
        return isAiAvailable;
    }

    public void setAiAvailable(boolean aiAvailable) {
        isAiAvailable = aiAvailable;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLessonTypeName() {
        return lessonTypeName;
    }

    public void setLessonTypeName(String lessonTypeName) {
        this.lessonTypeName = lessonTypeName;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPosterSrc() {
        return posterSrc;
    }

    public void setPosterSrc(String posterSrc) {
        this.posterSrc = posterSrc;
    }

    public String getTeaserSrc() {
        return teaserSrc;
    }

    public void setTeaserSrc(String teaserSrc) {
        this.teaserSrc = teaserSrc;
    }

    public boolean isAppPaymentAvailable() {
        return isAppPaymentAvailable;
    }

    public void setAppPaymentAvailable(boolean appPaymentAvailable) {
        isAppPaymentAvailable = appPaymentAvailable;
    }
}
