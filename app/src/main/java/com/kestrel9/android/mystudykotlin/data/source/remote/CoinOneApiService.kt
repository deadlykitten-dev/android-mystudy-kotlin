package com.kestrel9.android.mystudykotlin.data.source.remote

import com.kestrel9.android.mystudykotlin.data.OrderBookResponse
import com.kestrel9.android.mystudykotlin.data.TickerResponse
import com.kestrel9.android.mystudykotlin.data.TradesResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * MyStudyKotlin
 * Class: CoinOneApiService
 * Created by kestr on 2018-08-05.
 *
 * Description:
 */
interface CoinOneApiService {
    @GET("/ticker/")
    fun tickerResponseCall(): Call<TickerResponse>

    @GET("/orderbook/")
    fun orderBookResponseCall(): Call<OrderBookResponse>

    @GET("/trades/")
    fun tradesResponseCall(): Call<TradesResponse>
}