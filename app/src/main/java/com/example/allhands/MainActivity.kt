package com.example.allhands

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val itemNameImage = arrayOf(
            ItemsModal("converse","me when i grow up",R.drawable.converse),
            ItemsModal("couple cats","my cats when i grow up",R.drawable.couple_cats),
            ItemsModal("kissing cats","my relationship when i grow up",R.drawable.kissing_cats),
            ItemsModal("tea","my desk when i grow up",R.drawable.tea),
            ItemsModal("reading","my study space when i grow up",R.drawable.reading),
    )

    val itemModalList = ArrayList<ItemsModal>()

    var itemsAdapter: ItemsAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(items in itemNameImage){
            itemModalList.add(items)
        }
        itemsAdapter = ItemsAdapter();
        itemsAdapter!!.setData(itemModalList)

        this.findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this);
        findViewById<RecyclerView>(R.id.recyclerView).setHasFixedSize(true)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = itemsAdapter;
    }
}