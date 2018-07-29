package com.kestrel9.android.mystudykotlin.network.response

import com.kestrel9.android.mystudykotlin.network.model.CompleteOrder

data class TradesResponse(
        val errorCode : String,
        val timestamp : String,
        val completeOrders : MutableList<CompleteOrder>,
        val result : String,
        val currency : String
)