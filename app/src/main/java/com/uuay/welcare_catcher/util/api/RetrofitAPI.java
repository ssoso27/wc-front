package com.uuay.welcare_catcher.util.api;

import com.uuay.welcare_catcher.model.Account;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @Headers("Content-Type: application/json")
    @POST("accounts/join")
    Call<String> join(@Body Account account);
}
