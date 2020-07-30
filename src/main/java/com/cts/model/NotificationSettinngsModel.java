package com.cts.model;

public class NotificationSettinngsModel {

    private String key;

    private String notificationFrequency;

    private String notificationCriteria;

    private String alertType;

    private String alertMessage;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNotificationFrequency() {
        return notificationFrequency;
    }

    public void setNotificationFrequency(String notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

    public String getNotificationCriteria() {
        return notificationCriteria;
    }

    public void setNotificationCriteria(String notificationCriteria) {
        this.notificationCriteria = notificationCriteria;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
}
