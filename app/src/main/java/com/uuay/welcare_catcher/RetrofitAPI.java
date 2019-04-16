package com.uuay.welcare_catcher;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @Headers("Content-Type: application/json")
    @POST("accounts/join")
    Call<String> join(@Body Account account);
}
