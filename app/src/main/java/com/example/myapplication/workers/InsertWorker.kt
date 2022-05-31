package com.example.myapplication.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.myapplication.App
import com.example.myapplication.api.RestClient
import com.example.myapplication.api.dto.ReqResData
import com.example.myapplication.api.dto.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InsertWorker(context: Context, params: WorkerParameters): Worker(context, params) {
    override fun doWork(): Result {
        RestClient.initClient()
        RestClient.reqResApi.getResources(1).enqueue(object : Callback<ReqResData<List<Resource>>> {
            override fun onResponse(
                call: Call<ReqResData<List<Resource>>>,
                response: Response<ReqResData<List<Resource>>>
            ) {
                if(response.isSuccessful){
                    response.body()?.data?.let {
                        for(resource in it){
                            Log.d("Lasha", resource.name.toString())
                            App.instance.db.getResourceDao().insert(com.example.myapplication.room.Resource(0, name=resource.name, year=resource.year, color=resource.color, pantoneValue = resource.pantoneValue))
                        }
                    }
                }
            }
            override fun onFailure(call: Call<ReqResData<List<Resource>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return Result.success()
    }
}