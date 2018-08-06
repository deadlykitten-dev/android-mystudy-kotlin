package com.kestrel9.android.mystudykotlin.data.source.remote

import android.util.Log
import com.kestrel9.android.mystudykotlin.data.OrderBookResponse
import com.kestrel9.android.mystudykotlin.data.TickerResponse
import com.kestrel9.android.mystudykotlin.data.TradesResponse
import com.kestrel9.android.mystudykotlin.data.source.CoinDataSource
import com.kestrel9.android.mystudykotlin.network.CoinOneApi.coinOneApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * MyStudyKotlin
 * Class: CoinRemoteDataSource
 * Created by kestr on 2018-08-04.
 *
 * Description:
 */
object CoinRemoteDataSource {

    fun tradesResponseCall(callback: CoinDataSource.GetApiDataCallback) {
        val tradesResponseCall = coinOneApiService.tradesResponseCall()
        tradesResponseCall.enqueue(object : Callback<TradesResponse> {
            override fun onFailure(call: Call<TradesResponse>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

            override fun onResponse(call: Call<TradesResponse>?, response: Response<TradesResponse>) {
                val tradesResponse = response.body() ?: return
                if (tradesResponse.result == "success") {
                    callback.onDataLoaded(tradesResponse.completeOrders)
                }
            }
        })
    }

    fun orderBookResponseCall(callback: CoinDataSource.GetApiDataCallback) {
        val orderBookResponseCall = coinOneApiService.orderBookResponseCall()
        orderBookResponseCall.enqueue(object : Callback<OrderBookResponse> {
            override fun onFailure(call: Call<OrderBookResponse>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

            override fun onResponse(call: Call<OrderBookResponse>?, response: Response<OrderBookResponse>) {
                val orderBookResponse = response.body() ?: return
                if (orderBookResponse.result == "success") {
                    callback.onDataLoaded(orderBookResponse)
                }

            }
        })
    }

    fun tickerResponseCall(callback: CoinDataSource.GetApiDataCallback) {
        val tickerResponseCall = coinOneApiService.tickerResponseCall()
        tickerResponseCall.enqueue(object : Callback<TickerResponse>{
            override fun onFailure(call: Call<TickerResponse>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

            override fun onResponse(call: Call<TickerResponse>?, response: Response<TickerResponse>) {
                val tickerResponse = response.body() ?: return
                if (tickerResponse.result == "success"){
                    callback.onDataLoaded(tickerResponse)
                }
            }
        })

    }
}