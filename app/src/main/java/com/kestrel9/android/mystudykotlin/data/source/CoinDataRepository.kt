package com.kestrel9.android.mystudykotlin.data.source

import com.kestrel9.android.mystudykotlin.data.source.remote.CoinRemoteDataSource
import com.kestrel9.android.mystudykotlin.network.response.OrderBookResponse
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse
import com.kestrel9.android.mystudykotlin.network.response.TradesResponse

/**
 * MyStudyKotlin
 * Class: CoinDataRepository
 * Created by kestr on 2018-08-04.
 *
 * Description:
 */
class CoinDataRepository : CoinDataSource {

    override fun getTradesData(callback: CoinDataSource.GetApiDataCallback<TradesResponse>) {
        CoinRemoteDataSource.tradesResponseCall(object : CoinDataSource.GetApiDataCallback<TradesResponse> {
            override fun onDataLoaded(data: TradesResponse) {
                callback.onDataLoaded(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getOrderBookData(callback: CoinDataSource.GetApiDataCallback<OrderBookResponse>) {
        CoinRemoteDataSource.orderBookResponseCall(object : CoinDataSource.GetApiDataCallback<OrderBookResponse> {
            override fun onDataLoaded(data: OrderBookResponse) {
                callback.onDataLoaded(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getTickerData(callback: CoinDataSource.GetApiDataCallback<TickerResponse>) {
        CoinRemoteDataSource.tickerResponseCall(object : CoinDataSource.GetApiDataCallback<TickerResponse> {
            override fun onDataLoaded(data: TickerResponse) {
                callback.onDataLoaded(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }
}