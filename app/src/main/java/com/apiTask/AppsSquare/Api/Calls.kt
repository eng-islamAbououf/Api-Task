package com.apiTask.AppsSquare.Api

import com.apiTask.AppsSquare.Model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface Calls {

    @GET("products")
    fun getData():Call<DataModel>
}