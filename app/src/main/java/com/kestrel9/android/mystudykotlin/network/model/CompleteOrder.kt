package com.kestrel9.android.mystudykotlin.network.model

data class CompleteOrder(
        val is_ask : String,
        val timestamp : String,
        val price : String,
        val qty : String
)