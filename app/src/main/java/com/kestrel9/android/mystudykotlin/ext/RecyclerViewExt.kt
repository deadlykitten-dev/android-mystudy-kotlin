package com.kestrel9.android.mystudykotlin.ext

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.kestrel9.android.mystudykotlin.baseUtil.BaseRecyclerViewAdapter

/**
 * MyStudyKotlin
 * Class: RecyclerViewExt
 * Created by kestr on 2018-08-15.
 *
 * Description:
 */

@BindingAdapter(value = ["replaceAll"])
fun RecyclerView.replaceAll(list: List<Any>?) =
        (this.adapter as? BaseRecyclerViewAdapter<Any>)?.run {
            replaceAll(list)
            notifyDataSetChanged()
        }