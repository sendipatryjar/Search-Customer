package com.example.cst_dev41.searchuser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.widget.Toast
import com.example.cst_dev41.searchuser.DBHelper.DBHelper
import com.example.cst_dev41.searchuser.adapter.activityMainAdapter
import com.example.cst_dev41.searchuser.adapter.myAdapter
import com.example.cst_dev41.searchuser.model.Search

class MainActivity : AppCompatActivity() {
    private lateinit var dataList: ArrayList<Search>
    private var dbHelper: DBHelper? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: myAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.setHasFixedSize(true)
        dbHelper = DBHelper(this)
        recyclerView!!.smoothScrollToPosition(0)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.menuSearch)
        val searchView = searchItem.getActionView() as android.widget.SearchView
        searchView.setQueryHint("Search Customer Name")

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                try {
                initViews()
                dataList = dbHelper!!.search(newText.toUpperCase())!!
                adapter = myAdapter(dataList!!)
                recyclerView!!.adapter = adapter
                recyclerView!!.smoothScrollToPosition(1)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                try {
                val search_username = query
                if (search_username == "") {
                    Toast.makeText(this@MainActivity, "username not exist", Toast.LENGTH_LONG).show()
                } else {

                    dataList = dbHelper!!.search(search_username.toUpperCase())!!
                    adapter = myAdapter(dataList!!)
                    recyclerView!!.adapter = adapter
                    recyclerView!!.smoothScrollToPosition(1)

                   // Toast.makeText(this@MainActivity, "username found", Toast.LENGTH_LONG).show()


                }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return false
            }

        })

        return true
    }

}
