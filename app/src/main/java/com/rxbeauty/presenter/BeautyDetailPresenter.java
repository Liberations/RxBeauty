package com.rxbeauty.presenter;

import com.rxbeauty.api.BeautyApi;
import com.rxbeauty.api.RxService;
import com.rxbeauty.model.BeautyDetailEntity;
import com.rxbeauty.ui.view.BeautyDetailView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.rxbeauty.model.BeautyDetailEntity.TngouBean;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 13:02
 *
 * @version 1.0
 */
public class BeautyDetailPresenter extends BasePresenter<BeautyDetailView> {
	@Override
	public void attachView(BeautyDetailView mvpView) {
		super.attachView(mvpView);
	}

	@Override
	public void detachView() {
		super.detachView();
	}

	public void loadBeautyDetail(int id, final int page, int rows){
		RxService.createApi(BeautyApi.class)
				.getBeautyDetail(id,page,rows)
				.subscribeOn(Schedulers.io())
				.map(new Func1<BeautyDetailEntity, List<BeautyDetailEntity.TngouBean>>() {
					@Override
					public List<TngouBean> call(BeautyDetailEntity beautyDetailEntity) {
						return beautyDetailEntity.getTngou();
					}
				}).observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<List<BeautyDetailEntity.TngouBean>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {
						getMvpView().showError(e.toString(), null);
					}

					@Override
					public void onNext(List<BeautyDetailEntity.TngouBean> tngouBeen) {
						if(page==1){
							getMvpView().refresh(tngouBeen);
						}else {
							getMvpView().loadMore(tngouBeen);
						}
					}
				});
	}
}
