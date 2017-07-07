package com.rxbeauty.ui.activity;

import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.rxbeauty.R;
import com.rxbeauty.adapter.BeautyDetailAdapter;
import com.rxbeauty.listener.EndLessOnScrollListener;
import com.rxbeauty.model.BeautyDetailEntity;
import com.rxbeauty.presenter.BeautyDetailPresenter;
import com.rxbeauty.ui.view.BeautyDetailView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 13:43
 *
 * @version 1.0
 */
public class BeautyDetailActivity extends BaseActivity<BeautyDetailPresenter> implements BeautyDetailView, SwipeRefreshLayout.OnRefreshListener {

	BeautyDetailPresenter mBeautyDetailPresenter;
	BeautyDetailAdapter mBeautyDetailAdapter;
	private int page = 1;
	private int id = 1;
	List<BeautyDetailEntity.TngouBean> mBeautyDetailEntityList;
	@BindView(R.id.rv_beauty_detail)
	RecyclerView mRvBeautyDetail;
	@BindView(R.id.layout_swipe_refresh)
	SwipeRefreshLayout mRefreshLayout;

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
		return R.layout.activity_beauty_detail;
	}

	@Override
	protected void initData() {
		id = getIntent().getIntExtra("id", 1);
		mBeautyDetailEntityList = new ArrayList<>();
		mBeautyDetailAdapter = new BeautyDetailAdapter(R.layout.item_beauty_detail_list, mBeautyDetailEntityList);
		mRvBeautyDetail.setLayoutManager(new GridLayoutManager(this, 2));
		mRvBeautyDetail.setAdapter(mBeautyDetailAdapter);
		mBeautyDetailPresenter.attachView(this);
		mBeautyDetailAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		loadData(true);

	}

	private void loadData(boolean isRefresh) {
		if(isRefresh){
			page=1;
		}
		mBeautyDetailPresenter.loadBeautyDetail(id, page, 6);
	}

	@Override
	protected BeautyDetailPresenter getPresenter() {
		mBeautyDetailPresenter = new BeautyDetailPresenter();
		return mBeautyDetailPresenter;
	}

	@Override
	protected void initEvent() {
		mRefreshLayout.setOnRefreshListener(this);

	}


	@Override
	public void refresh(List<BeautyDetailEntity.TngouBean> datas) {
		Log.e("refresh加载成功", datas.toString());
		mRefreshLayout.setRefreshing(false);
		mBeautyDetailEntityList.clear();
		mBeautyDetailEntityList.addAll(datas);
		mBeautyDetailAdapter.notifyDataSetChanged();
	}

	@Override
	public void loadMore(List<BeautyDetailEntity.TngouBean> datas) {
		Log.e("loadMore加载成功", datas.toString());
		mBeautyDetailEntityList.addAll(datas);
		mBeautyDetailAdapter.notifyDataSetChanged();
	}


	@Override
	public void onRefresh() {
		loadData(true);
	}
}
