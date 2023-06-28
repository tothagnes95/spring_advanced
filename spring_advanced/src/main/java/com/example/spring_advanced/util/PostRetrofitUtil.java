package com.example.spring_advanced.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRetrofitUtil {
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance () {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
