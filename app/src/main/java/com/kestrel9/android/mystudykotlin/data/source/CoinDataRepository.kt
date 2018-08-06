package com.kestrel9.android.mystudykotlin.data.source

import com.kestrel9.android.mystudykotlin.data.source.remote.CoinRemoteDataSource

/**
 * MyStudyKotlin
 * Class: CoinDataRepository
 * Created by kestr on 2018-08-04.
 *
 * Description:
 */
class CoinDataRepository : CoinDataSource {

    override fun getCompleteOrderData(callback: CoinDataSource.GetApiDataCallback) {
        CoinRemoteDataSource.tradesResponseCall(object : CoinDataSource.GetApiDataCallback {
            override fun <T> onDataLoaded(data: T) {
                callback.onDataLoaded(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getOrderBookData(callback: CoinDataSource.GetApiDataCallback) {
        CoinRemoteDataSource.orderBookResponseCall(object : CoinDataSource.GetApiDataCallback {
            override fun <T> onDataLoaded(data: T) {
                callback.onDataLoaded(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getTickerData(callback: CoinDataSource.GetApiDataCallback) {
        CoinRemoteDataSource.tickerResponseCall(object : CoinDataSource.GetApiDataCallback {
            override fun <T> onDataLoaded(data: T) {
                callback.onDataLoaded(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }
}