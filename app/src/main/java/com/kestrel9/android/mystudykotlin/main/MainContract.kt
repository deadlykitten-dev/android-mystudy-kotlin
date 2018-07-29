package com.kestrel9.android.mystudykotlin.main

import com.kestrel9.android.mystudykotlin.network.model.Ask
import com.kestrel9.android.mystudykotlin.network.model.Bid
import com.kestrel9.android.mystudykotlin.network.model.CompleteOrder
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse

/**
 * MyStudyKotlin
 * Class: MainContract
 * Created by kestr on 2018-07-20.
 *
 * Description:
 */
interface MainContract {

    interface View{

        fun setBidList(bid: MutableList<Bid>)

        fun setAskList(ask: MutableList<Ask>)

        fun setOrderList(order: MutableList<CompleteOrder>)

        fun setTickerView(ticker: TickerResponse)

        fun showFailLoad()
    }

    interface Presenter{
        fun loadApiData()
    }
}