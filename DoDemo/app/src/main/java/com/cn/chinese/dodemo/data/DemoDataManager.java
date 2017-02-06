package com.cn.chinese.dodemo.data;

import java.util.HashMap;
import java.util.Map;

import com.cn.chinese.dodemo.TestBean;

import android.util.Log;
import rx.Observable;
import rx.functions.Action1;

public class DemoDataManager {
    private static DemoDataManager instance;
    private RemoteDataManager remoteDataManager;
    private Map<String, String> mapConfig = new HashMap<>();

    private DemoDataManager(){
        remoteDataManager = RemoteDataManager.getInstance();
    }
    public static DemoDataManager getInstance(){
        if(null == instance){
            instance = new DemoDataManager();
        }
        return instance;
    }

    public Observable<TestBean> getTest(String cityCode){
        return remoteDataManager.getTest(cityCode)
                .doOnNext(new Action1<TestBean>() {
                    @Override
                    public void call(TestBean bean) {
                        Log.e("ww","BBB");
                    }
                });
    }
}
