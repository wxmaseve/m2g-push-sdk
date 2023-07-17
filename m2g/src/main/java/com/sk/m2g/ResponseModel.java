package com.sk.m2g;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ResponseModel {
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Map data;

    public String getMessage() {
        return message;
    }
}
