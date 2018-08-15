package com.kestrel9.android.mystudykotlin.viewmodel

import android.databinding.*
import com.kestrel9.android.mystudykotlin.data.source.CoinDataRepository
import com.kestrel9.android.mystudykotlin.data.source.CoinDataSource
import com.kestrel9.android.mystudykotlin.network.response.TickerResponse

/**
 * MyStudyKotlin
 * Class: TickerViewModel
 * Created by kestr on 2018-08-15.
 *
 * Description:
 */
class TickerViewModel(private val coinDataRepository: CoinDataRepository) : BaseObservable() {

    val model: ObservableField<TickerResponse> = ObservableField()

    fun start() {
        loadApiData()
    }

    fun loadApiData() {
        coinDataRepository.getTickerData(object : CoinDataSource.GetApiDataCallback<TickerResponse> {
            override fun onDataLoaded(data: TickerResponse) {
                model.set(data)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

}