package com.sk.m2g;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class M2gPush {
    public static synchronized void registerToken(String appKey) {
        Log.d("dev", "registerToken called");
        ApiService apiService = ApiClient.getClient();

        //get fcm token
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.w("dev", "Fetching FCM registration token failed", task.getException());
                return;
            }

            // Get the FCM token
            String token = task.getResult();
            Log.d("dev", "FCM registration token: " + token);

            RegisterTokenRequestBody requestBody = new RegisterTokenRequestBody(token, appKey);

            Call<ResponseModel> call = apiService.registerToken(requestBody);
            call.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    if (response.isSuccessful()) {
                        ResponseModel apiResponse = response.body();
                        String responseBody = apiResponse.getMessage();

                        Log.d("dev", "api success :"+responseBody);
                    } else {
                        // handle error
                        Log.e("dev", "api failure");
                    }
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    // handle network failure
                    String failureMessage = "API request failed: " + t.getMessage();
                    Log.e("dev", failureMessage);
                }
            });
        });
    }
}
