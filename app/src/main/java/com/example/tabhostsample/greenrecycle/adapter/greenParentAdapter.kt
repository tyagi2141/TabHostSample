package com.example.tabhostsample.greenrecycle.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tabhostsample.R
import com.example.tabhostsample.nested.model.ParentModel
import com.greenlightplanet.retailer.models.reporttodaysmodel.Retail_visits
import kotlinx.android.synthetic.main.green_nested_parent_recycler.view.*
import kotlinx.android.synthetic.main.nested_parent_recycler.view.*
import kotlinx.android.synthetic.main.nested_parent_recycler.view.rv_child

/**
 * Created by Rahul on 25/06/20.
 */
class greenParentAdapter(private val parents : List<Retail_visits>) :    RecyclerView.Adapter<greenParentAdapter.ViewHolder>(){
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.green_nested_parent_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
        holder.textView.text = parent.retail
        val childLayoutManager = LinearLayoutManager(
            holder.recyclerView.context, LinearLayout.VERTICAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = greenChildAdapter(parent.orders)
            setRecycledViewPool(viewPool)
        }

    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.rv_child
        val textView: TextView = itemView.summary_key
    }
}