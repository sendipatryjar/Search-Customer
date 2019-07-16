package com.example.cst_dev41.searchuser.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
//import com.bumptech.glide.Glide
import com.example.cst_dev41.searchuser.R
import com.example.cst_dev41.searchuser.model.Search

class activityMainAdapter(private val context: Context, private val items: List<Search>) :
        RecyclerView.Adapter<activityMainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): activityMainAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder?.title?.text = items?.get(i)?.company
        viewHolder?.title?.text = items?.get(i)?.code


//        Glide.with(context)
//                .load(items[i].avatarUrl)
//                //.placeholder(R.drawable.ic_search)
//                .into(viewHolder?.imageView)
    }

    override fun getItemCount(): Int {
        Log.d("error","isi item" +items.size)
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val imageView: TextView


        init {
            title = view.findViewById(R.id.company_user) as TextView
            imageView = view.findViewById(R.id.code_user) as TextView

            //on item click
            itemView.setOnClickListener { v ->

                    Toast.makeText(v.context, "You clicked " , Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

