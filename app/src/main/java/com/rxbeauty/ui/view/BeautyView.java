package com.rxbeauty.ui.view;

import com.rxbeauty.model.BeautyEntity;

import java.util.List;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:13
 *
 * @version 1.0
 */
public interface BeautyView extends MvpView {

	void loadComplete(List<BeautyEntity.TngouBean>  data);
}
