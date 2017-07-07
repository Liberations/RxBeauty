package com.rxbeauty.presenter;

import com.rxbeauty.api.BeautyApi;
import com.rxbeauty.api.RxService;
import com.rxbeauty.model.BeautyEntity;
import com.rxbeauty.ui.view.BeautyView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:18
 *
 * @version 1.0
 */
public class BeautyPresenter extends BasePresenter<BeautyView> {
	@Override
	public void attachView(BeautyView mvpView) {
		super.attachView(mvpView);
	}

	@Override
	public void detachView() {
		super.detachView();
	}

	public void loadBeauty() {
		RxService.createApi(BeautyApi.class)
				.getBeauty()
				.subscribeOn(Schedulers.io())
				.map(new Func1<BeautyEntity, List<BeautyEntity.TngouBean>>() {

					@Override
					public List<BeautyEntity.TngouBean> call(BeautyEntity beautyEntity) {
						return beautyEntity.getTngou();
					}
				})
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<List<BeautyEntity.TngouBean>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {
						getMvpView().showError(e.toString(), null);
					}

					@Override
					public void onNext(List<BeautyEntity.TngouBean> tngouBeen) {
						getMvpView().loadComplete(tngouBeen);
					}
				});
	}
}
