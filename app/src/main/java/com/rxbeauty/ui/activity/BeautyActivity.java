package com.rxbeauty.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rxbeauty.R;
import com.rxbeauty.adapter.BeautyAdapter;
import com.rxbeauty.model.BeautyEntity;
import com.rxbeauty.presenter.BeautyPresenter;
import com.rxbeauty.ui.view.BeautyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:51
 *
 * @version 1.0
 */
public class BeautyActivity extends BaseActivity<BeautyPresenter> implements BeautyView, BaseQuickAdapter.OnRecyclerViewItemChildClickListener {

	@BindView(R.id.rv_beauty)
	RecyclerView mRvBeauty;
	private BeautyPresenter beautyPresenter;
	private List<BeautyEntity.TngouBean> mTngouBeanList;
	BeautyAdapter mBeautyAdapter;

	@Override
	public void showLoading(String msg) {

	}

	@Override
	public void hideLoading() {

	}

	@Override
	public void showError(String msg, View.OnClickListener onClickListener) {

	}


	@Override
	public void showNetError(View.OnClickListener onClickListener) {

	}

	@Override
	protected int getLayout() {
		return R.layout.activity_beauty;
	}


	@Override
	protected void initData() {
		mTngouBeanList = new ArrayList<>();
		mBeautyAdapter = new BeautyAdapter(R.layout.item_beauty_list, mTngouBeanList);
		mBeautyAdapter.openLoadAnimation();
		mRvBeauty.setLayoutManager(new GridLayoutManager(this, 1));
		beautyPresenter.attachView(this);
		beautyPresenter.loadBeauty();
		mRvBeauty.setAdapter(mBeautyAdapter);
	}

	@Override
	protected BeautyPresenter getPresenter() {
		beautyPresenter = new BeautyPresenter();
		return beautyPresenter;
	}

	@Override
	protected void initEvent() {
		mBeautyAdapter.setOnRecyclerViewItemChildClickListener(this);

	}


	@Override
	public void loadComplete(List<BeautyEntity.TngouBean> datas) {
		mTngouBeanList.clear();
		mTngouBeanList.addAll(datas);
		mBeautyAdapter.notifyDataSetChanged();

	}


	@Override
	public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
		startActivity(new Intent(this,BeautyDetailActivity.class).putExtra("id",i+1%7));
	}
}
