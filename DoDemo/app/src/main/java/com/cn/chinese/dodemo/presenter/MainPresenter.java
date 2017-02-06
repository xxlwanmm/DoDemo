package com.cn.chinese.dodemo.presenter;

import com.cn.chinese.dodemo.TestBean;
import com.cn.chinese.dodemo.data.DemoDataManager;
import com.cn.chinese.dodemo.view.MainView;

import android.util.Log;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView> {

    public void getNetWork(){
        DemoDataManager.getInstance().getTest("101010100")
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<TestBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("ww","aaa");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ww","bbb");
                    }

                    @Override
                    public void onNext(TestBean responseBean) {
                        Log.e("ww","AAA");
                    }
                });
    }

}
