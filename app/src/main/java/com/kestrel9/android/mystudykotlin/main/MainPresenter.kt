package com.kestrel9.android.mystudykotlin.main

import com.kestrel9.android.mystudykotlin.data.OrderBookResponse
import com.kestrel9.android.mystudykotlin.data.TickerResponse
import com.kestrel9.android.mystudykotlin.data.source.CoinDataRepository
import com.kestrel9.android.mystudykotlin.data.source.CoinDataSource
import com.kestrel9.android.mystudykotlin.model.CompleteOrder

/**
 * MyStudyKotlin
 * Class: MainPresenter
 * Created by kestr on 2018-07-20.
 *
 * Description:
 */

class MainPresenter(private val coinDataRepository: CoinDataRepository,
                    val view: MainContract.View) : MainContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        loadApiData()
    }

    override fun loadApiData() {
        coinDataRepository.getCompleteOrderData(object : CoinDataSource.GetApiDataCallback {
            override fun <T> onDataLoaded(data: T) {
                    @Suppress("UNCHECKED_CAST")
                    view.setOrderList(data as MutableList<CompleteOrder>)
            }

            override fun onDataNotAvailable() {
                view.showFailLoad()
            }
        })

        coinDataRepository.getTickerData(object : CoinDataSource.GetApiDataCallback{
            override fun <T> onDataLoaded(data: T) {
                view.setTickerView(data as TickerResponse)
            }

            override fun onDataNotAvailable() {
                view.showFailLoad()
            }
        })

        coinDataRepository.getOrderBookData(object : CoinDataSource.GetApiDataCallback{
            override fun <T> onDataLoaded(data: T) {
                val orderBookResponse = data as OrderBookResponse
                view.setAskList(orderBookResponse.ask)
                view.setBidList(orderBookResponse.bid)
            }

            override fun onDataNotAvailable() {
                view.showFailLoad()
            }
        })
    }
}