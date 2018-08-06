package com.kestrel9.android.mystudykotlin.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * MyStudyKotlin
 * Class: RetrofitCreator
 * Created by kestr on 2018-08-04.
 *
 * Description:
 */
object RetrofitCreator {

    fun <T : Any> createRetrofit(defaultUrl: String, tClass: Class<T>): T {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(defaultUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(tClass)
    }
}
