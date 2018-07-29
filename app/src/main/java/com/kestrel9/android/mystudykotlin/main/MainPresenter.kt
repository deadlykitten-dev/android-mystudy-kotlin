package com.kestrel9.android.mystudykotlin.main

import android.util.Log
import com.kestrel9.android.mystudykotlin.network.CoinOneApi
import com.kestrel9.android.mystudykotlin.network.model.Ask
import com.kestrel9.android.mystudykotlin.network.response.OrderBookResponse
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse
import com.kestrel9.android.mystudykotlin.network.response.TradesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * MyStudyKotlin
 * Class: MainPresenter
 * Created by kestr on 2018-07-20.
 *
 * Description:
 */

class MainPresenter(private val coinOneApiService: CoinOneApi.CoinOneApiService,
                    private val view: MainContract.View) : MainContract.Presenter {

    override fun loadApiData() {
        val orderBookResponseCall = coinOneApiService.orderBookResponseCall()

        orderBookResponseCall.enqueue(object : Callback<OrderBookResponse>{
            override fun onFailure(call: Call<OrderBookResponse>?, t: Throwable?) {
                Log.d("Main.loadApiData", "onFailure", t)
            }

            override fun onResponse(call: Call<OrderBookResponse>, response: Response<OrderBookResponse>) {
                val orderBookResponse = response.body() ?: return
                if (orderBookResponse.result == "success"){
                    view.setAskList(orderBookResponse.ask)
                    view.setBidList(orderBookResponse.bid)
                }
            }
        })

        val tradesResponseCall = coinOneApiService.tradesResponseCall()

        tradesResponseCall.enqueue(object : Callback<TradesResponse>{
            override fun onFailure(call: Call<TradesResponse>?, t: Throwable?) {
                Log.d("Main.loadApiData", "onFailure", t)
            }

            override fun onResponse(call: Call<TradesResponse>?, response: Response<TradesResponse>) {
                val tradesResponse = response.body() ?: return
                if (tradesResponse.result == "success"){
                    view.setOrderList(tradesResponse.completeOrders)
                }
            }
        })

        val tickerResponseCall = coinOneApiService.tickerResponseCall()

        tickerResponseCall.enqueue(object : Callback<TickerResponse>{
            override fun onFailure(call: Call<TickerResponse>?, t: Throwable?) {
                Log.d("Main.loadApiData", "onFailure", t)
            }

            override fun onResponse(call: Call<TickerResponse>?, response: Response<TickerResponse>) {
                val tickerResponse = response.body() ?: return
                if(tickerResponse.result == "success"){
                    view.setTickerView(tickerResponse)
                }
            }
        })
    }
}