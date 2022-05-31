package com.example.myapplication.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activities.MainActivity
import com.example.myapplication.room.Resource

class ResourceRecyclerAdapter(private val resources: List<Resource>): RecyclerView.Adapter<ResourceRecyclerAdapter.ResourceViewHolder>(){
    companion object{
        const val RESOURCE_ID = "RESOURCE_ID"
    }
    class ResourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        private val nameView: TextView = itemView.findViewById(R.id.textView2)
        private val colorView: TextView = itemView.findViewById(R.id.textView3)
        private lateinit var resource: Resource
        fun onBind(resource: Resource){
            nameView.text = resource.name
            colorView.text = resource.color
            this.resource = resource
        }

        override fun onClick(clickedView: View?) {
            val context = itemView.context
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(RESOURCE_ID, resource.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_resource, parent, false)
        return ResourceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        holder.onBind(resources[position])
    }

    override fun getItemCount() = resources.size
}