package com.sk.m2g;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/message/push/token") // Replace "api-endpoint" with your actual API endpoint
    Call<ResponseModel> getData(@Query("param1") String param1, @Query("param2") String param2);

    @POST("/message/push/token") // Replace "api-endpoint" with your actual API endpoint
    Call<ResponseModel> registerToken(@Body RegisterTokenRequestBody requestBody);
}
