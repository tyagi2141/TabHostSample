package com.greenlightplanet.retailer.models.reporttodaysmodel



/**
 * Created by Rahul on 25/06/20.
 */


data class Orders(

    val id: Int,
    val product: String,
    val order_date: String,
    val price: Int,
    val inhand_units: Int,
    val secondary_units: Int,
    val amount: Int,
    val created_at: String,
    val updated_at: String
)