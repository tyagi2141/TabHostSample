package com.example.tabhostsample.recycleDemo;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabhostsample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahul on 24/06/20.
 */
public class MainActivityTwo extends Activity {
    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerview;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        recyclerview=(RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(itemList);
        RecyclerView.LayoutManager mLayoutManger = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManger);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter);
        prepareItem();
    }
    private void prepareItem() {
        Item item = new Item(R.drawable.ic_launcher_background,"Wopro","Wipro is software compnay");
        itemList.add(item);
        item = new Item(R.drawable.ic_launcher_foreground,"TCS","TCS is service base compnay");
        itemList.add(item);
        item = new Item(R.drawable.ic_launcher_background,"Ericsson","Ericsson is a networking compnay ");
        itemList.add(item);
        item= new Item(R.drawable.ic_launcher_foreground,"Evon","Evon is hub of software devlopment ");
        itemList.add(item);
        mAdapter.notifyDataSetChanged();
        recyclerview.setAdapter(mAdapter);
    }
}