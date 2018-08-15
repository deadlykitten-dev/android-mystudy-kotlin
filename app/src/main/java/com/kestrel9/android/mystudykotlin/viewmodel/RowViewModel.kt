package com.kestrel9.android.mystudykotlin.viewmodel

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.kestrel9.android.mystudykotlin.data.model.Ask
import com.kestrel9.android.mystudykotlin.data.model.Bid
import com.kestrel9.android.mystudykotlin.data.model.CompleteOrder
import com.kestrel9.android.mystudykotlin.data.source.CoinDataRepository
import com.kestrel9.android.mystudykotlin.data.source.CoinDataSource
import com.kestrel9.android.mystudykotlin.network.response.OrderBookResponse
import com.kestrel9.android.mystudykotlin.network.response.TradesResponse

/**
 * MyStudyKotlin
 * Class: RowViewModel
 * Created by kestr on 2018-08-15.
 *
 * Description:
 */
class RowViewModel(private val coinDataRepository: CoinDataRepository) : BaseObservable() {

    val ask: ObservableList<Ask> = ObservableArrayList()
    val bid: ObservableList<Bid> = ObservableArrayList()
    val completeOrder: ObservableList<CompleteOrder> = ObservableArrayList()

    fun start() {
        loadApi()
    }

    fun loadApi() {
        coinDataRepository.getTradesData(object : CoinDataSource.GetApiDataCallback<TradesResponse> {
            override fun onDataLoaded(data: TradesResponse) {
                completeOrder.addAll(data.completeOrders)
            }

            override fun onDataNotAvailable() {

            }
        })

        coinDataRepository.getOrderBookData(object : CoinDataSource.GetApiDataCallback<OrderBookResponse> {
            override fun onDataLoaded(data: OrderBookResponse) {
                ask.addAll(data.ask)
                bid.addAll(data.bid)
            }

            override fun onDataNotAvailable() {
            }
        })
    }
}