package com.kestrel9.android.mystudykotlin.baseUtil

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * MyStudyKotlin
 * Class: BaseViewHolder
 * Created by kestr on 2018-07-26.
 *
 * Description:
 */
abstract class BaseViewHolder<in ITEM : Any, B : ViewDataBinding>(
        @LayoutRes layoutRes: Int,
        parent: ViewGroup?)
    : RecyclerView.ViewHolder(
        LayoutInflater.from(parent?.context).inflate(layoutRes, parent, false)) {

    protected var binding: B? = DataBindingUtil.bind(itemView)

    fun onBindViewHolder(item: Any?) {
        try {
            @Suppress("UNCHECKED_CAST")
            onViewCreated(item as? ITEM)
        } catch (e: Exception) {
            itemView.visibility = View.GONE
        }
    }

    abstract fun onViewCreated(item: ITEM?)
}