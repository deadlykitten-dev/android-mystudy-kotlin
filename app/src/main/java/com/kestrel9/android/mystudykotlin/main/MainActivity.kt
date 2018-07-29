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
import com.kestrel9.android.mystudykotlin.network.CoinOneApi
import com.kestrel9.android.mystudykotlin.network.model.Ask
import com.kestrel9.android.mystudykotlin.network.model.Bid
import com.kestrel9.android.mystudykotlin.network.model.CompleteOrder
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse


class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter = MainPresenter(CoinOneApi.CoinOneApiService.retrofit.create(CoinOneApi.CoinOneApiService::class.java), this)
    private var mainBinding: ActivityMainBinding? = null

    private val askListAdapter = AskListAdapter()
    private val bidListAdapter = BidListAdapter()
    private val orderListAdapter = OrderListAdapter()

//    private val delay = 10000
//    private val PendingIntent = Pendi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainBinding!!.recyclerAsk.adapter = askListAdapter
        mainBinding!!.recyclerBid.adapter = bidListAdapter
        mainBinding!!.recyclerOrder.adapter = orderListAdapter

//        val alarmIntent = Intent(applicationContext, AlarmOneMinuteBroadcastReceiver::class.java)
//        val pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0)
//
//        val timer = Timer()
//        timer.schedule(timerTask {
            presenter.loadApiData()
//        }, 0, 10000)
//
//        val manager : AlarmManager = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay, pendingIntent);
//        } else {
//            manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay, pendingIntent);
//        }
    }

    override fun setBidList(bid: MutableList<Bid>) {
        bidListAdapter.setList(bid)
        bidListAdapter.notifyDataSetChanged()
    }

    override fun setAskList(ask: MutableList<Ask>) {
        askListAdapter.setList(ask)
        askListAdapter.notifyDataSetChanged()
    }

    override fun setOrderList(order: MutableList<CompleteOrder>) {
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
