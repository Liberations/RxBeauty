package com.rxbeauty.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rxbeauty.R;
import com.rxbeauty.model.BeautyEntity;

import java.util.List;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 11:42
 *
 * @version 1.0
 */
public class BeautyAdapter extends BaseQuickAdapter<BeautyEntity.TngouBean> {

	public BeautyAdapter(int layoutResId, List<BeautyEntity.TngouBean> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder baseViewHolder, BeautyEntity.TngouBean tngouBean) {
		baseViewHolder.setText(R.id.keyword,tngouBean.getKeywords()+"");
		baseViewHolder.setOnClickListener(R.id.cardView, new OnItemChildClickListener());
	}
}
