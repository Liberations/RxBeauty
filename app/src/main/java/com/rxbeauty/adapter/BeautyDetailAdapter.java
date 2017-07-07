package com.rxbeauty.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rxbeauty.R;
import com.rxbeauty.model.BeautyDetailEntity;

import java.util.List;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 12:59
 *
 * @version 1.0
 */
public class BeautyDetailAdapter extends BaseQuickAdapter<BeautyDetailEntity.TngouBean> {


	public BeautyDetailAdapter(int layoutResId, List<BeautyDetailEntity.TngouBean> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder baseViewHolder, BeautyDetailEntity.TngouBean tngouBean) {
		baseViewHolder.setText(R.id.tv_title,tngouBean.getTitle());
		Log.e("BeautyDetailEntity","http://tnfs.tngou.net/image"+tngouBean.getImg()+"_180x120");
		Glide.with(baseViewHolder.getConvertView().getContext())
				.load("http://tnfs.tngou.net/image"+tngouBean.getImg())
		        .placeholder(R.mipmap.loading)
				.error(R.mipmap.failed)
				.into((ImageView) baseViewHolder.getView(R.id.iv_img));
	}
}
