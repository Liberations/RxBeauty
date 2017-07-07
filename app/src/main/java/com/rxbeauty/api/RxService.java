package com.rxbeauty.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:03
 *
 * @version 1.0
 */
public class RxService {
	private static final String BASETESTURL = "http://www.tngou.net";
	private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor
			(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
	private static Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(BASETESTURL)
			.client(okHttpClient)
			.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.build();

	private RxService() {

	}

	public static <T> T createApi(Class<T> clazz) {

		return retrofit.create(clazz);
	}
}
