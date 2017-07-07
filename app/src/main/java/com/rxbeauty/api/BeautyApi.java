package com.rxbeauty.api;

import com.rxbeauty.model.BeautyDetailEntity;
import com.rxbeauty.model.BeautyEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface BeautyApi {
	@GET("/tnfs/api/classify")
	Observable<BeautyEntity> getBeauty();

	@GET("/tnfs/api/list")
	Observable<BeautyDetailEntity> getBeautyDetail(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);
}
