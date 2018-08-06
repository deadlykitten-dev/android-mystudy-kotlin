package com.kestrel9.android.mystudykotlin.data

import com.kestrel9.android.mystudykotlin.model.CompleteOrder

data class TradesResponse(
        val errorCode : String,
        val timestamp : String,
        val completeOrders : MutableList<CompleteOrder>,
        val result : String,
        val currency : String
)