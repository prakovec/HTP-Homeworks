package com.prakovec.java.model;

/**
 * Created by Admin on 06.12.2014.
 */
public enum Status {
    PROCESSED(" In progress."),
    RECIVED(" Received from the sender."),
    SENT(" Sent to the recipient."),
    DECLINED(" Rejected and sent to the sender.");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
