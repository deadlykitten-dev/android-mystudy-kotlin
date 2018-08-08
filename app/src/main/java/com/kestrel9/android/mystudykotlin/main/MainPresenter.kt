package com.kestrel9.android.mystudykotlin.main

import com.kestrel9.android.mystudykotlin.network.response.OrderBookResponse
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse
import com.kestrel9.android.mystudykotlin.data.source.CoinDataRepository
import com.kestrel9.android.mystudykotlin.data.source.CoinDataSource
import com.kestrel9.android.mystudykotlin.network.response.TradesResponse

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
        coinDataRepository.getTradesData(object : CoinDataSource.GetApiDataCallback<TradesResponse>{
            override fun onDataLoaded(data: TradesResponse) {
                view.setOrderList(data.completeOrders)
            }

            override fun onDataNotAvailable() {
                view.showFailLoad()

            }
        })

        coinDataRepository.getTickerData(object : CoinDataSource.GetApiDataCallback<TickerResponse>{
            override fun onDataLoaded(data: TickerResponse) {
                view.setTickerView(data)
            }

            override fun onDataNotAvailable() {
                view.showFailLoad()

            }
        })

        coinDataRepository.getOrderBookData(object : CoinDataSource.GetApiDataCallback<OrderBookResponse> {
            override fun onDataLoaded(data: OrderBookResponse) {
                view.setAskList(data.ask)
                view.setBidList(data.bid)
            }

            override fun onDataNotAvailable() {
                view.showFailLoad()
            }
        })
    }
}