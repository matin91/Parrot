package com.rocklobstre.parrot.data.viewmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * POJO for the Reminder Reason
 * Created by Matin on 10/04/2017.
 */

public class Reason {
    @SerializedName("reasonId")
    @Expose
    private String reasonId;

    @SerializedName("reasonMessage")
    @Expose
    private String reasonMessage;

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
