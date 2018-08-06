package com.kestrel9.android.mystudykotlin.data

import com.kestrel9.android.mystudykotlin.model.Ask
import com.kestrel9.android.mystudykotlin.model.Bid

data class OrderBookResponse(
        val timestamp : String,
        val bid : MutableList<Bid>,
        val errorCode : String,
        val currency : String,
        val result : String,
        val ask : MutableList<Ask>
)