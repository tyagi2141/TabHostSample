package com.greenlightplanet.retailer.models.reporttodaysmodel


import kotlinx.android.parcel.Parcelize

/**
 * Created by Rahul on 25/06/20.
 */

data class Retail_visits (

    val id : Int,
    val retail : String,
    val distributor : String,
    val orders : List<Orders>,
  val visit_date : String,
    val total_amount : Int,
    val amount_paid : Int,
    val credit : Int,
    val desc : String,
    val is_regular : Boolean,
    val created_at : String,
   val updated_at : String,
 val user : Int
)