package com.example.tabhostsample.nested.model

import com.example.tabhostsample.nested.model.ChildModel

/**
 * Created by Rahul on 25/06/20.
 */
data class ParentModel (
    val title : String = "",
    val children : List<ChildModel>
)