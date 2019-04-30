package com.uuay.welcare_catcher.util.api;

import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.model.Facility;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @Headers("Content-Type: application/json")
    @POST("accounts/join")
    Call<String> join(@Body Account account);

    @GET("facilities")
    Call<List<Facility>> findFacilities(
            @Query("keyword") String keyword
            , @Query("size") int size
            , @Query("page") int page
    );
}
