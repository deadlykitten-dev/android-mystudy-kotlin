package com.kestrel9.android.mystudykotlin.baseUtil

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * MyStudyKotlin
 * Class: BaseViewHolder
 * Created by kestr on 2018-07-26.
 *
 * Description:
 */
abstract class BaseViewHolder<T : Any> protected constructor(itemView : View) : RecyclerView.ViewHolder(itemView) {

    protected lateinit var item: T

}