package com.example.tabhostsample.nested

/**
 * Created by Rahul on 25/06/20.
 */
data class ParentModel (
    val title : String = "",
    val children : List<ChildModel>
)