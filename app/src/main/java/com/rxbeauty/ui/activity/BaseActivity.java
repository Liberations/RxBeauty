package com.rxbeauty.ui.activity;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:56
 * @version 1.0
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.rxbeauty.BeautyAPP;
import com.rxbeauty.presenter.BasePresenter;
import com.rxbeauty.ui.view.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements MvpView {
	protected T mPresenter;
	protected Activity mContext;
	private Unbinder mUnbinder;



	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayout());
		mUnbinder = ButterKnife.bind(this);
		mContext = this;
		if (mPresenter != null){
			mPresenter.attachView(this);
		}else {
			mPresenter=getPresenter();
		}

		BeautyAPP.getInstance().addActivity(this);
		initData();
		initEvent();

	}

	@Override
	protected void onStart() {
		super.onStart();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mPresenter != null)
			mPresenter.detachView();
		mUnbinder.unbind();
		BeautyAPP.getInstance().removeActivity(this);
	}

	protected void setToolBar(Toolbar toolbar, String title) {
		toolbar.setTitle(title);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});
	}

	protected abstract int getLayout();
	protected abstract void initData();
	protected abstract T getPresenter();
	protected abstract void initEvent();


}
