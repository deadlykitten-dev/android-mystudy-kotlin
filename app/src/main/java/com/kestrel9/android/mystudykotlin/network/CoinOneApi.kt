package com.kestrel9.android.mystudykotlin.network

import com.kestrel9.android.mystudykotlin.contract.API

/**
 * MyStudyKotlin
 * Class: CoinOneApi
 * Created by kestr on 2018-07-20.
 *
 * Description:
 */
object CoinOneApi {
    val coinOneApiService: CoinOneApiService by lazy {
        RetrofitCreator.createRetrofit(API, CoinOneApiService::class.java)
    }
}
