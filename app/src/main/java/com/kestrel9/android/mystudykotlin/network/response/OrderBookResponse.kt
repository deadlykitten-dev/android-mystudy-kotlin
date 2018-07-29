package com.kestrel9.android.mystudykotlin.network.response

import com.kestrel9.android.mystudykotlin.network.model.Ask
import com.kestrel9.android.mystudykotlin.network.model.Bid

data class OrderBookResponse(
        val timestamp : String,
        val bid : MutableList<Bid>,
        val errorCode : String,
        val currency : String,
        val result : String,
        val ask : MutableList<Ask>
)