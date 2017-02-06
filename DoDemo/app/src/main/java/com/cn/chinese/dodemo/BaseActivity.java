package com.cn.chinese.dodemo;

import com.cn.chinese.dodemo.presenter.BasePresenter;
import com.cn.chinese.dodemo.view.BaseView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends FragmentActivity implements
        BaseView {
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        bindPresenter();
    }

    protected abstract int getLayoutId();

    protected P getPresenter() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        return mPresenter;
    }

    protected abstract V getMVPview();

    protected abstract P createPresenter();

    protected void bindPresenter() {
        if (getPresenter() != null) {
            getPresenter().attachView(getMVPview());
        }
    }
}
