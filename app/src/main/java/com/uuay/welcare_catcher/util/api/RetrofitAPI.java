package com.uuay.welcare_catcher.util.api;

import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.model.Facility;
import com.uuay.welcare_catcher.model.RequestLogin;
import com.uuay.welcare_catcher.model.RequestToggle;
import com.uuay.welcare_catcher.model.WelfareService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
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

    @GET("accounts/duplicate-email")
    Call<String> duplicateEmail(@Query("email") String email);

    @Headers("Content-Type: application/json")
    @POST("accounts/login")
    Call<Account> login(@Body RequestLogin requestLogin);

    @GET("services")
    Call<List<WelfareService>> findServices(
            @Query("keyword") String keyword
            , @Query("size") int size
            , @Query("page") int page
    );

    @Headers("Content-Type: application/json")
    @POST("receive-services/toggle")
    Call<Boolean> toggle(@Body RequestToggle requestToggle);

    @GET("receive-services/account/{id}")
    Call<List<WelfareService>> receivedList(
            @Path("id") Long id
            , @Query("size") int size
            , @Query("page") int page
    );
}
