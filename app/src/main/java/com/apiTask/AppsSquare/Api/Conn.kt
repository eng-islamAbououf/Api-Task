package com.apiTask.AppsSquare.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Conn {

    var calls = Retrofit
        .Builder()
        .baseUrl("https://api.punkapi.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Calls::class.java)
}