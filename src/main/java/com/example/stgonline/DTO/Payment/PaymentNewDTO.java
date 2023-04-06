package com.example.stgonline.DTO.Payment;

public class PaymentNewDTO {

    private int lessonId;
    private int subscriptionId;
    private int courseId;

    private int isWithChat;

    public PaymentNewDTO(int lessonId, int subscriptionId, int courseId, int isWithChat) {
        this.lessonId = lessonId;
        this.subscriptionId = subscriptionId;
        this.courseId = courseId;
        this.isWithChat = isWithChat;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getIsWithChat() {
        return isWithChat;
    }
}
