package com.cn.chinese.dodemo.data;

import com.cn.chinese.dodemo.TestBean;

import rx.Observable;

public class RemoteDataManager {
    private static RemoteDataManager remoteDataManager;

    private RemoteDataManager() {}

    public static RemoteDataManager getInstance(){
        if(null == remoteDataManager){
            remoteDataManager = new RemoteDataManager();
        }

        return remoteDataManager;
    }

    public Observable<TestBean> getTest(String cityCode){
        MainNetApi questionApi = ApiFactory.createService(MainNetApi.class);
        return questionApi.getTest(cityCode);
    }
}
