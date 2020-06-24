package com.example.tabhostsample.nested

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tabhostsample.R
import kotlinx.android.synthetic.main.nested_activity_main.*

/**
 * Created by Rahul on 25/06/20.
 */
class Nested_MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nested_activity_main)

        initRecycler()
    }

    @SuppressLint("WrongConstant")
    private fun initRecycler(){
        recyclerView = rv_parent

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Nested_MainActivity,
                LinearLayout.VERTICAL, false)
            adapter = ParentAdapter(ParentDataFactory
                .getParents(40))
        }

    }
}