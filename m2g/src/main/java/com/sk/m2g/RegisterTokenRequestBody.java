package com.sk.m2g;

public class RegisterTokenRequestBody {
    private String token;
    private String appKey;

    public RegisterTokenRequestBody(String token, String appKey) {
        this.token = token;
        this.appKey = appKey;
    }
}
