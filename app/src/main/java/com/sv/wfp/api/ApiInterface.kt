package com.sv.wfp.api

import retrofit2.http.GET
import com.sv.wfp.models.Worker
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    fun getWorkers(@Query("site") site: String): retrofit2.Call<List<Worker>>
}