package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.*
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.adapters.ResourceRecyclerAdapter
import com.example.myapplication.workers.DeleteWorker
import com.example.myapplication.workers.InsertWorker

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val insertWorker: OneTimeWorkRequest = OneTimeWorkRequestBuilder<InsertWorker>().build()
        val deleteWorker: OneTimeWorkRequest = OneTimeWorkRequestBuilder<DeleteWorker>().build()

        WorkManager.getInstance(this)
            .beginWith(insertWorker)
            .then(deleteWorker)
            .enqueue()
        recyclerView = findViewById(R.id.recyclerView)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(insertWorker.id).observe(
            this, Observer {
                if (it != null && it.state.isFinished){
                    val resources = App.instance.db.getResourceDao().selectAll()
                    recyclerView.adapter = ResourceRecyclerAdapter(resources)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        )



    }
}