package com.kestrel9.android.mystudykotlin.main

import com.kestrel9.android.mystudykotlin.BasePresenter
import com.kestrel9.android.mystudykotlin.BaseView
import com.kestrel9.android.mystudykotlin.model.Ask
import com.kestrel9.android.mystudykotlin.model.Bid
import com.kestrel9.android.mystudykotlin.model.CompleteOrder
import com.kestrel9.android.mystudykotlin.data.TickerResponse

/**
 * MyStudyKotlin
 * Class: MainContract
 * Created by kestr on 2018-07-20.
 *
 * Description:
 */
interface MainContract {

    interface View : BaseView<Presenter> {

        fun setBidList(bid: MutableList<Bid>)

        fun setAskList(ask: MutableList<Ask>)

        fun setOrderList(order: MutableList<CompleteOrder>)

        fun setTickerView(ticker: TickerResponse)

        fun showFailLoad()
    }

    interface Presenter : BasePresenter {

        fun loadApiData()
    }
}