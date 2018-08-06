package com.kestrel9.android.mystudykotlin.main.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kestrel9.android.mystudykotlin.R
import com.kestrel9.android.mystudykotlin.baseUtil.BaseAdapter
import com.kestrel9.android.mystudykotlin.baseUtil.BaseViewHolder
import com.kestrel9.android.mystudykotlin.databinding.RowOrderBinding
import com.kestrel9.android.mystudykotlin.model.CompleteOrder

/**
 * MyStudyKotlin
 * Class: OrderListAdapter
 * Created by kestr on 2018-07-26.
 *
 * Description:
 */
class OrderListAdapter: BaseAdapter<CompleteOrder, OrderListAdapter.ViewHolder>(){

    override fun createHolder(context: Context, viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_order, viewGroup, false))
    }

    override fun onBindHolder(holder: ViewHolder, position: Int) {
        holder.binding!!.tvQty.text = items[position].qty
        holder.binding.tvPrice.text = items[position].price
    }

    class ViewHolder (itemView : View) : BaseViewHolder<CompleteOrder>(itemView){
        val binding: RowOrderBinding ?= DataBindingUtil.bind(itemView)
    }
}