package com.dthvinh.dto;

import com.dthvinh.enums.Activity;

public class RecordResponse {
    public String timezone;
    public String time;
    public String activity;

    public RecordResponse(String timezone, String time, Activity activity) {
        this.timezone = timezone;
        this.time = time;
        this.activity = activity.getValue();
    }
}
