package com.kestrel9.android.mystudykotlin.main

import com.kestrel9.android.mystudykotlin.BasePresenter
import com.kestrel9.android.mystudykotlin.BaseView
import com.kestrel9.android.mystudykotlin.data.model.Ask
import com.kestrel9.android.mystudykotlin.data.model.Bid
import com.kestrel9.android.mystudykotlin.data.model.CompleteOrder
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse

/**
 * MyStudyKotlin
 * Class: MainContract
 * Created by kestr on 2018-07-20.
 *
 * Description:
 */
interface MainContract {

    interface View : BaseView<Presenter> {

        fun setBidList(bid: List<Bid>)

        fun setAskList(ask: List<Ask>)

        fun setOrderList(order: List<CompleteOrder>)

        fun setTickerView(ticker: TickerResponse)

        fun showFailLoad()
    }

    interface Presenter : BasePresenter {

        fun loadApiData()
    }
}