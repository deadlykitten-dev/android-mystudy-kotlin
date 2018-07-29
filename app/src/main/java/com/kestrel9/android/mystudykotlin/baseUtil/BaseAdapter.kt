package com.kestrel9.android.mystudykotlin.baseUtil

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * MyStudyKotlin
 * Class: BaseAdapter
 * Created by kestr on 2018-07-26.
 *
 * Description:
 */
abstract class BaseAdapter <T : Any, VH : BaseViewHolder<*>> : RecyclerView.Adapter<VH>(){

    protected val items : MutableList<T> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createHolder(parent.context, parent, viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindHolder(holder, position)
    }

    fun setList(list : MutableList<T>){
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun reset() {
        items.clear()
        notifyDataSetChanged()
    }


    abstract fun createHolder(context: Context, viewGroup: ViewGroup, viewType: Int): VH

    abstract fun onBindHolder(holder: VH, position: Int)
}