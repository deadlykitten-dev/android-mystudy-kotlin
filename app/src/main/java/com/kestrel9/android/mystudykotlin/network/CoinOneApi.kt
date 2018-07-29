package com.kestrel9.android.mystudykotlin.network

import com.kestrel9.android.mystudykotlin.network.response.OrderBookResponse
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse
import com.kestrel9.android.mystudykotlin.network.response.TradesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * MyStudyKotlin
 * Class: CoinOneApi
 * Created by kestr on 2018-07-20.
 *
 * Description:
 */
object CoinOneApi {
    private val BASE_URL = "https://api.coinone.co.kr"

    interface CoinOneApiService {
        @GET("/ticker/") fun tickerResponseCall(): Call<TickerResponse>
        @GET("/orderbook/") fun orderBookResponseCall(): Call<OrderBookResponse>
        @GET("/trades/") fun tradesResponseCall(): Call<TradesResponse>

        companion object {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

    }
}