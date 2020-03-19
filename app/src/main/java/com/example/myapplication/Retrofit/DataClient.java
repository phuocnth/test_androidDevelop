package com.example.myapplication.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataClient {
    @GET("employee")
    Call<Object> getDataEmployees ();
}



