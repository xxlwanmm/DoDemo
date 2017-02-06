package com.cn.chinese.dodemo.data;

import com.cn.chinese.dodemo.fastjson.FastJsonConverterFactory;
import com.cn.chinese.dodemo.network.NetOkHttpClient;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public final class ApiFactory {
    public static final String ENDPOINT = "http://www.weather.com.cn/";
    private static final Retrofit retrofit;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .client(NetOkHttpClient.getInstance())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }

}