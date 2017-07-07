package com.rxbeauty.presenter;

import com.rxbeauty.ui.view.MvpView;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:07
 *
 * @version 1.0
 */
public interface Presenter<V extends MvpView> {

	void attachView(V mvpView);

	void detachView();
}
