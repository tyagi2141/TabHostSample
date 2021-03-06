package com.example.tabhostsample.nested

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
import com.example.tabhostsample.nested.adapter.ParentAdapter
import com.example.tabhostsample.nested.model.ChildModel
import com.example.tabhostsample.nested.model.ParentModel
import kotlinx.android.synthetic.main.nested_activity_main.*
import org.json.JSONException
import org.json.JSONObject


/**
 * Created by Rahul on 25/06/20.
 */
class Nested_MainActivity : AppCompatActivity() {
    private val TAG = "Nested_MainActivity"
    private var requestQueue: RequestQueue? = null
    var url: String? = null
    private var adapterList: MutableList<ParentModel> = mutableListOf()
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nested_activity_main)
        url = "http://dev.glpapps.com/retail/api/v1/report/todays/3/2020-06-25/"
        requestQueue = Volley.newRequestQueue(this)
        jsonParse()
        initRecycler()
    }

    @SuppressLint("WrongConstant")
    private fun initRecycler() {
        recyclerView = rv_parent

        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@Nested_MainActivity, LinearLayout.VERTICAL, false)
            adapter = ParentAdapter(
                ParentDataFactory.getParents(40)
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

                       // adapterList.addAll(ParentModel(employee.getString(),employee as List<ChildModel>))
Log.e("fgfdgfdgfhfg",""+employee)
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Log.e("errrrrr",""+e.toString())

                }
            }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }
}