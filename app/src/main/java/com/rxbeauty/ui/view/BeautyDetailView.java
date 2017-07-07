package com.rxbeauty.ui.view;

import com.rxbeauty.model.BeautyDetailEntity;

import java.util.List;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 13:00
 *
 * @version 1.0
 */
public interface  BeautyDetailView extends MvpView {
	void refresh(List<BeautyDetailEntity.TngouBean> data);

	void loadMore(List<BeautyDetailEntity.TngouBean>  data);
}
