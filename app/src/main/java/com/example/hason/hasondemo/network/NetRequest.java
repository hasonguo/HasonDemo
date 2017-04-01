package com.example.hason.hasondemo.network;


import okhttp3.OkHttpClient;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by hason on 17/2/23.
 */

public class NetRequest {
    private static String baseUrl="http://gank.io/api/";
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static retrofit2.Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static RetrofitHttpClient sycTrade;
    public static RetrofitHttpClient getRetrofitHttpClient() {
        if (sycTrade == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(baseUrl)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sycTrade = retrofit.create(RetrofitHttpClient.class);
        }
        return sycTrade;
    }


}
