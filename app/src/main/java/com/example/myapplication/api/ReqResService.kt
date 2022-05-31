package com.example.myapplication.api

import com.example.myapplication.api.dto.ReqResData
import com.example.myapplication.api.dto.Resource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqResService{
    @GET("unknown")
    fun getResources(@Query("page")page: Int):Call<ReqResData<List<Resource>>>
    @GET("unknown/{unknownId}")
    fun getResource(@Path("unknownId")id: Long):Call<ReqResData<Resource>>
}