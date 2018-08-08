package com.kestrel9.android.mystudykotlin.network.response

import com.kestrel9.android.mystudykotlin.data.model.Ask
import com.kestrel9.android.mystudykotlin.data.model.Bid

data class OrderBookResponse(
        val timestamp : String,
        val bid : List<Bid>,
        val errorCode : String,
        val currency : String,
        val result : String,
        val ask : List<Ask>
)