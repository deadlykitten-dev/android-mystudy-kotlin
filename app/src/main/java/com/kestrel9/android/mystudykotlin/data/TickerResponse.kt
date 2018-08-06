package com.kestrel9.android.mystudykotlin.data

data class TickerResponse(
        val result : String,
        val volume : Double,
        val last : Long,
        val yesterday_last : Long,
        val timestamp : String,
        val yesterday_low : Long,
        val high : Long,
        val currency : String,
        val low : Long,
        val errorCode : String,
        val yesterday_first : Long,
        val yesterday_volume : Double,
        val yesterday_high : Long,
        val first : Long
)