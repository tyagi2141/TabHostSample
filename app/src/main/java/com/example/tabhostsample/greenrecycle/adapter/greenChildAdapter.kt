package com.example.tabhostsample.greenrecycle.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tabhostsample.R
import com.example.tabhostsample.nested.model.ChildModel
import com.greenlightplanet.retailer.models.reporttodaysmodel.Orders
import kotlinx.android.synthetic.main.greenchild_layout_list.view.*
import kotlinx.android.synthetic.main.nested_child_recycler.view.*

/**
 * Created by Rahul on 25/06/20.
 */
class greenChildAdapter(private val children : List<Orders>)
    : RecyclerView.Adapter<greenChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val v =  LayoutInflater.from(parent.context)
            .inflate(R.layout.greenchild_layout_list,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val child = children[position]
        holder.month_key.text=child.product
        holder.cost_value.text = child.price.toString()
        holder.quantity_value.text = child.inhand_units.toString()
        holder.amount_value.text = child.amount.toString()
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val cost_value : TextView = itemView.cost_value
        val month_key: TextView = itemView.name_key
        val quantity_value: TextView = itemView.quantity_value
        val amount_value: TextView = itemView.amount_value

    }
}