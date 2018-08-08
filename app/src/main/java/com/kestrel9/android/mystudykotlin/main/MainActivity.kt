package com.kestrel9.android.mystudykotlin.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kestrel9.android.mystudykotlin.R
import com.kestrel9.android.mystudykotlin.databinding.ActivityMainBinding
import com.kestrel9.android.mystudykotlin.main.ui.AskListAdapter
import com.kestrel9.android.mystudykotlin.main.ui.BidListAdapter
import com.kestrel9.android.mystudykotlin.main.ui.OrderListAdapter
import com.kestrel9.android.mystudykotlin.data.model.Ask
import com.kestrel9.android.mystudykotlin.data.model.Bid
import com.kestrel9.android.mystudykotlin.data.model.CompleteOrder
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse
import com.kestrel9.android.mystudykotlin.data.source.CoinDataRepository


class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    private var mainBinding: ActivityMainBinding? = null

    private val askListAdapter = AskListAdapter()
    private val bidListAdapter = BidListAdapter()
    private val orderListAdapter = OrderListAdapter()

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        presenter = MainPresenter(CoinDataRepository(), this)

        mainBinding!!.recyclerAsk.adapter = askListAdapter
        mainBinding!!.recyclerBid.adapter = bidListAdapter
        mainBinding!!.recyclerOrder.adapter = orderListAdapter

    }


    override fun setBidList(bid: List<Bid>) {
        bidListAdapter.setList(bid)
        bidListAdapter.notifyDataSetChanged()
    }

    override fun setAskList(ask: List<Ask>) {
        askListAdapter.setList(ask)
        askListAdapter.notifyDataSetChanged()
    }

    override fun setOrderList(order: List<CompleteOrder>) {
        orderListAdapter.setList(order)
        orderListAdapter.notifyDataSetChanged()
    }

    override fun setTickerView(ticker: TickerResponse) {
        mainBinding!!.ticker = ticker
    }

    override fun showFailLoad() {
        Toast.makeText(this, getString(R.string.text_fail), Toast.LENGTH_LONG).show()
    }
}
