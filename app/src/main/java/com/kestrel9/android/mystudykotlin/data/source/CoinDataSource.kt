package com.kestrel9.android.mystudykotlin.data.source

import com.kestrel9.android.mystudykotlin.network.response.OrderBookResponse
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse
import com.kestrel9.android.mystudykotlin.network.response.TradesResponse

/**
 * MyStudyKotlin
 * Class: du
 * Created by kestr on 2018-08-05.
 *
 * Description:
*/
interface CoinDataSource {

    interface GetApiDataCallback<T>{

        fun onDataLoaded(data: T)

        fun onDataNotAvailable()
    }

    fun getTradesData(callback: GetApiDataCallback<TradesResponse>)

    fun getOrderBookData(callback: GetApiDataCallback<OrderBookResponse>)

    fun getTickerData(callback: GetApiDataCallback<TickerResponse>)

}