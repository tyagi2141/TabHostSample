package com.example.tabhostsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Rahul on 24/06/20.
 */
class BestContentAppFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_webview_best, container, false)!!
}