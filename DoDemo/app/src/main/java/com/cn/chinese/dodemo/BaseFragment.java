package com.cn.chinese.dodemo;

import com.cn.chinese.dodemo.presenter.BasePresenter;
import com.cn.chinese.dodemo.view.BaseView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class BaseFragment<P extends BasePresenter, V extends BaseView> extends Fragment {

    private P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        bindPresenter();
        return view;
    }

    protected void bindPresenter() {
        if (getPresenter() != null) {
            getPresenter().attachView(getMVPview());
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPages();
    }

    protected P getPresenter() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        return mPresenter;
    }

    protected abstract P createPresenter();

    protected abstract V getMVPview();

    protected abstract int getLayoutId();

    protected abstract void initPages();
}
