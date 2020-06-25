package com.example.tabhostsample.greenrecycle

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.example.tabhostsample.R
import com.example.tabhostsample.greenrecycle.adapter.greenParentAdapter
import com.example.tabhostsample.nested.adapter.ParentAdapter
import com.example.tabhostsample.nested.model.ChildModel
import com.example.tabhostsample.nested.model.ParentModel
import com.greenlightplanet.retailer.models.reporttodaysmodel.Orders
import com.greenlightplanet.retailer.models.reporttodaysmodel.Retail_visits
import com.greenlightplanet.retailer.models.reporttodaysmodel.TodaysResponseDataModel
import kotlinx.android.synthetic.main.nested_activity_main.*
import org.json.JSONException
import org.json.JSONObject


/**
 * Created by Rahul on 25/06/20.
 */
class green_MainActivity : AppCompatActivity() {
    private val TAG = "Nested_MainActivity"
    private var requestQueue: RequestQueue? = null
    var url: String? = null
    private var adapterList: MutableList<Retail_visits> = mutableListOf()
    private var adapterList_order: MutableList<Orders> = mutableListOf()
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nested_activity_main)
        url = "http://dev.glpapps.com/retail/api/v1/report/todays/3/2020-06-25/"
        requestQueue = Volley.newRequestQueue(this)
        jsonParse()
       // initRecycler()
    }

    @SuppressLint("WrongConstant")
    private fun initRecycler(todaysResponseDataModel: TodaysResponseDataModel) {
        recyclerView = rv_parent

        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@green_MainActivity, LinearLayout.VERTICAL, false)
            adapter = greenParentAdapter(
               todaysResponseDataModel.retail_visits
            )
        }

    }

    private fun jsonParse() {
        // val url = "https://api.myjson.com/bins/xbspb"
        val request =
            JsonObjectRequest(Request.Method.GET, "http://rahultyagi.in/mytest.json", null, Response.Listener { response ->
                try {

                  //  Log.e("dfjhdbfjhgjdfg",""+response.toString())
                    val json:JSONObject=response.getJSONObject("ResponseData")

                    val jsonArray = json.getJSONArray("retail_visits")
                    for (i in 0 until jsonArray.length()) {
                        val employee = jsonArray.getJSONObject(i)
                        val orderArray = employee.getJSONArray("orders")

                        for (j in 0 until orderArray.length()) {

                            val mOrder = orderArray.getJSONObject(j)
                            Log.e("rdghfhfghgfh",""+mOrder.toString())

                            adapterList_order.add(

                                    Orders(mOrder.getInt("id"),mOrder.getString("product"),mOrder.getString("order_date"),mOrder.getInt("price"),mOrder.getInt("inhand_units"),mOrder.getInt("secondary_units"),
                                        mOrder.getInt("amount"),mOrder.getString("created_at"),mOrder.getString("updated_at"))
                                )


                        }

                        Log.e("fgfdgfdgfhfg",""+employee)

                        adapterList.add(Retail_visits(employee.getInt("id"),employee.getString("retail"),
                            employee.getString("distributor"),adapterList_order,employee.getString("visit_date"),
                            employee.getInt("total_amount"),employee.getInt("amount_paid"),
                            employee.getInt("credit"),employee.getString("desc"),employee.getBoolean("is_regular"),
                            employee.getString("created_at"),
                            employee.getString("updated_at"),
                            employee.getInt("user")))

                    }
                    initRecycler(TodaysResponseDataModel(adapterList))

                } catch (e: JSONException) {
                    e.printStackTrace()
                    Log.e("errrrrr",""+e.toString())

                }
            }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }
}