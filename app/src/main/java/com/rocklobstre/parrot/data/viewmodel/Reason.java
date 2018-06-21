package com.rocklobstre.parrot.data.viewmodel;

/**
 * POJO for the Reminder Reason
 * Created by Ryan on 10/04/2017.
 */

public class Reason {

    private String reasonId;
    private String reasonMessage;

    public Reason() {
    }

    public Reason(String reasonId, String reasonMessage) {
        this.reasonId = reasonId;
        this.reasonMessage = reasonMessage;
    }

    public String getReasonId() {
        return reasonId;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }
}
