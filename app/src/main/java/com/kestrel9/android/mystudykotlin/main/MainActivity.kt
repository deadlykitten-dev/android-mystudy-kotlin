package com.kestrel9.android.mystudykotlin.main

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kestrel9.android.mystudykotlin.R
import com.kestrel9.android.mystudykotlin.baseUtil.BaseActivity
import com.kestrel9.android.mystudykotlin.baseUtil.BaseRecyclerViewAdapter
import com.kestrel9.android.mystudykotlin.baseUtil.BaseViewHolder
import com.kestrel9.android.mystudykotlin.data.model.Ask
import com.kestrel9.android.mystudykotlin.data.model.Bid
import com.kestrel9.android.mystudykotlin.data.model.CompleteOrder
import com.kestrel9.android.mystudykotlin.databinding.ActivityMainBinding
import com.kestrel9.android.mystudykotlin.data.source.CoinDataRepository
import com.kestrel9.android.mystudykotlin.databinding.RowAskBinding
import com.kestrel9.android.mystudykotlin.databinding.RowBidBinding
import com.kestrel9.android.mystudykotlin.databinding.RowOrderBinding
import com.kestrel9.android.mystudykotlin.viewmodel.RowViewModel
import com.kestrel9.android.mystudykotlin.viewmodel.TickerViewModel


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val tickerViewModel by lazy {
        TickerViewModel(CoinDataRepository())
    }

    private val rowViewModel by lazy {
        RowViewModel(CoinDataRepository())
    }

    override fun onResume() {
        super.onResume()
        binding.ticker?.start()
        binding.row?.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            ticker = tickerViewModel
            row = rowViewModel
            recyclerAsk.run {
                adapter = object : BaseRecyclerViewAdapter<Ask>() {
                    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder =
                            object : BaseViewHolder<Ask, RowAskBinding>(R.layout.row_ask, parent) {
                                override fun onViewCreated(item: Ask?) {
                                    binding?.run {
                                        ask = item
                                    }
                                }
                            }
                }
            }
            recyclerBid.run {
                adapter = object : BaseRecyclerViewAdapter<Bid>() {
                    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder =
                            object : BaseViewHolder<Bid, RowBidBinding>(R.layout.row_bid, parent) {
                                override fun onViewCreated(item: Bid?) {
                                    binding?.run {
                                        bid = item
                                    }
                                }
                            }
                }
            }
            recyclerOrder.run {
                adapter = object : BaseRecyclerViewAdapter<CompleteOrder>() {
                    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder =
                            object : BaseViewHolder<CompleteOrder, RowOrderBinding>(R.layout.row_order, parent) {
                                override fun onViewCreated(item: CompleteOrder?) {
                                    binding?.run {
                                        order = item
                                    }
                                }
                            }
                }
            }
        }

    }

}
