package com.cn.chinese.dodemo.presenter;

import com.cn.chinese.dodemo.view.BaseView;

public abstract class BasePresenter<V extends BaseView> implements IPresenter {
    V mView;

    public BasePresenter() {
    }

    @Override
    public void attachView(BaseView view) {
        mView = (V) view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public V getMVPview() {
        return mView;
    }

    @Override
    public boolean isViewAttached() {
        return null != mView;
    }
}
