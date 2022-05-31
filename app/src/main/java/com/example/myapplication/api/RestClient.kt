package com.example.myapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RestClient {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient

    fun initClient(){
        okHttpClient = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder().baseUrl("https://reqres.in/api/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun<S> getService(serviceClass: Class<S>): S{
        return retrofit.create(serviceClass)
    }

    val reqResApi: ReqResService
        get() = getService(ReqResService::class.java)
}