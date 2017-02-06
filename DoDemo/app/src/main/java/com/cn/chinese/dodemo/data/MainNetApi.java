package com.cn.chinese.dodemo.data;

import com.cn.chinese.dodemo.TestBean;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

public interface MainNetApi {
    @GET("data/cityinfo/{CityCode}.html")
    Observable<TestBean> getTest(@Path("CityCode") String cityCode);
}
