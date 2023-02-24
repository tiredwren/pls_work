package com.example.allhands

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity(), ItemsAdapter.ClickListener {


    val searchItems = arrayOf(
            ItemsModal("converse","me when i grow up",R.drawable.converse),
            ItemsModal("couple cats","my cats when i grow up",R.drawable.couple_cats),
            ItemsModal("kissing cats","my relationship when i grow up",R.drawable.kissing_cats),
            ItemsModal("tea","my desk when i grow up",R.drawable.tea),
            ItemsModal("reading","my study space when i grow up",R.drawable.reading),
    )

    val itemModalList = ArrayList<ItemsModal>()

    var itemsAdapter: ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        for(items in searchItems){
            itemModalList.add(items)
        }
        itemsAdapter = ItemsAdapter(this)
        itemsAdapter!!.setData(itemModalList)

        this.findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerView).setHasFixedSize(true)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = itemsAdapter
    }

    override fun ClickedItem(itemsModal: ItemsModal) {
        Log.e("TAG",itemsModal.name)

        when(itemsModal.name){
            "converse" ->
                startActivity(Intent(this@SearchActivity, ConverseActivity::class.java))
            "kissing_cats" ->
                startActivity(Intent(this@SearchActivity, KissingCatsActivity::class.java))

            else -> {
                Toast.makeText(this,"no action yet", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val menuItem = menu!!.findItem(R.id.searchView)

        val searchView = menuItem.actionView as SearchView

        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                itemsAdapter!!.filter.filter(filterString)
                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {

                itemsAdapter!!.filter.filter(filterString)
                return true
            }

        })
        return true
    }
}