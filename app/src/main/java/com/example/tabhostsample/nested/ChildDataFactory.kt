package com.example.tabhostsample.nested

import com.example.tabhostsample.R
import com.example.tabhostsample.nested.model.ChildModel
import java.util.*

/**
 * Created by Rahul on 25/06/20.
 */
object ChildDataFactory{

    private val random = Random()

    private val titles =  arrayListOf( "Aviator", "Now you can See me", "God Father", "Mission Impossible", "3 idiots")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomImage() : Int{
        return R.drawable.ic_launcher_background
    }

    fun getChildren(count : Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        repeat(count){
            val child = ChildModel(
                randomImage(),
                randomTitle()
            )
            children.add(child)
        }
        return children
    }


}