package com.cn.chinese.dodemo.presenter;

import com.cn.chinese.dodemo.view.BaseView;

public interface IPresenter {

    void attachView(BaseView view);

    void detachView();

    BaseView getMVPview();

    boolean isViewAttached();
}
