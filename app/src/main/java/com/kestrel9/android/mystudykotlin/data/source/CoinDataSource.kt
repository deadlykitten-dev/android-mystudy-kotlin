package com.kestrel9.android.mystudykotlin.data.source

/**
 * MyStudyKotlin
 * Class: du
 * Created by kestr on 2018-08-05.
 *
 * Description:
*/
interface CoinDataSource {

    interface GetApiDataCallback{

        fun <T>onDataLoaded(data: T)

        fun onDataNotAvailable()
    }

    fun getCompleteOrderData(callback: GetApiDataCallback)

    fun getOrderBookData(callback: GetApiDataCallback)

    fun getTickerData(callback: GetApiDataCallback)

}