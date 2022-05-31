package com.example.myapplication.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.myapplication.App

class DeleteWorker(context: Context, params: WorkerParameters): Worker(context, params) {
    override fun doWork(): Result {
        App.instance.db.getResourceDao().delete()
        return Result.success()
    }
}