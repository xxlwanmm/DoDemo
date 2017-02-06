package com.cn.chinese.dodemo;

import com.cn.chinese.dodemo.presenter.MainPresenter;
import com.cn.chinese.dodemo.view.MainView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity<MainPresenter,MainView> implements
        MainView{

    private MainPresenter mainPresenter;
    private Button bt;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getNetWork();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainView getMVPview() {
        return this;
    }

    @Override
    protected MainPresenter createPresenter() {
        mainPresenter = new MainPresenter();
        return mainPresenter;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
