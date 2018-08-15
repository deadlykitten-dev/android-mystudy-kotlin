package com.kestrel9.android.mystudykotlin.baseUtil

import android.support.v7.widget.RecyclerView

/**
 * MyStudyKotlin
 * Class: BaseRecyclerViewAdapter
 * Created by kestr on 2018-07-26.
 *
 * Description:
 */
abstract class BaseRecyclerViewAdapter<ITEM : Any>
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected var items = mutableListOf<ITEM>()

    fun add(item: ITEM?) {
        item?.let {
            items.add(it)
        }
    }

    fun replaceAll(items: List<ITEM>?) {
        items?.let {
            this.items.run {
                clear()
                addAll(it)
            }
        }
    }

    fun clear() {
        items.clear()
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? BaseViewHolder<*, *>)?.onBindViewHolder(items[position])
    }
}