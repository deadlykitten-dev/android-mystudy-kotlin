package com.kestrel9.android.mystudykotlin.main.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kestrel9.android.mystudykotlin.R
import com.kestrel9.android.mystudykotlin.baseUtil.BaseAdapter
import com.kestrel9.android.mystudykotlin.baseUtil.BaseViewHolder
import com.kestrel9.android.mystudykotlin.databinding.RowBidBinding
import com.kestrel9.android.mystudykotlin.model.Bid

/**
 * MyStudyKotlin
 * Class: BidListAdapter
 * Created by kestr on 2018-07-26.
 *
 * Description:
 */
class BidListAdapter: BaseAdapter<Bid, BidListAdapter.ViewHolder>(){

    override fun createHolder(context: Context, viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_bid, viewGroup, false))
    }

    override fun onBindHolder(holder: ViewHolder, position: Int) {
        holder.binding!!.tvQty.text = items[position].qty
        holder.binding.tvPrice.text = items[position].price
    }

    class ViewHolder (itemView : View) : BaseViewHolder<Bid>(itemView){
        val binding: RowBidBinding? = DataBindingUtil.bind(itemView)
    }
}