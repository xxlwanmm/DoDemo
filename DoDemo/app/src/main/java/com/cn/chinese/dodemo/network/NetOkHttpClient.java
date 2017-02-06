package com.cn.chinese.dodemo.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class NetOkHttpClient {
    private static OkHttpClient instance;

    public static OkHttpClient getInstance() {
        if (null == instance) {
            instance = new OkHttpClient.Builder()
                    .addInterceptor(new NetOauthInterceptor())
                    .addInterceptor(new NetLoggingInterceptor())
                    .build();
        }
        return instance;
    }

    public static class NetOauthInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws java.io.IOException {
            Request originalRequest = chain.request();
            Request requestWithToken = null;

            Request.Builder builder = originalRequest.newBuilder();

            if (null != builder) {
                requestWithToken = builder.build();
            }

            Response response = chain.proceed((requestWithToken != null ? requestWithToken : originalRequest));
            return response;
        }

    }

    public static class NetLoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws java.io.IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            return response;
        }
    }

}
