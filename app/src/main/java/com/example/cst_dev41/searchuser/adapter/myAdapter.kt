package com.example.cst_dev41.searchuser.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cst_dev41.searchuser.R
import com.example.cst_dev41.searchuser.model.Search

class myAdapter (private var custom: List<Search>?):
        RecyclerView.Adapter<myAdapter.PackViewHolder>() {
    private var listener: OnSelectedListener? = null

    override fun getItemCount(): Int {
        return try {
            custom?.size!!
        } catch (e: Exception){
            0
        }
    }
    override fun onBindViewHolder(holder: PackViewHolder, position: Int) {
        holder?.tvCustomer?.text = custom?.get(position)?.company
        holder?.tvCode?.text = custom?.get(position)?.code
            holder?.tv_Customer?.text = custom?.get(position)?.nama1
            holder?.tv_Email?.text = custom?.get(position)?.email1
            holder?.tv_jabatan?.text = custom?.get(position)?.jabatan1
            holder?.tv_Status?.text = custom?.get(position)?.status1

        holder?.tv_Customer2?.text = custom?.get(position)?.nama2
        holder?.tv_Email2?.text = custom?.get(position)?.email2
        holder?.tv_jabatan2?.text = custom?.get(position)?.jabatan2
        holder?.tv_Status2?.text = custom?.get(position)?.status2

        holder?.tv_Customer3?.text = custom?.get(position)?.nama3
        holder?.tv_Email3?.text = custom?.get(position)?.email3
        holder?.tv_jabatan3?.text = custom?.get(position)?.jabatan3
        holder?.tv_Status3?.text = custom?.get(position)?.status3

        holder?.tv_Customer4?.text = custom?.get(position)?.nama4
        holder?.tv_Email4?.text = custom?.get(position)?.email4
        holder?.tv_jabatan4?.text = custom?.get(position)?.jabatan4
        holder?.tv_Status4?.text = custom?.get(position)?.status4


//        holder?.itemView?.setOnLongClickListener {
//            listener?.onLongSelectedItem(custom?.get(position))
//            true
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_list, parent, false)
        return PackViewHolder(view)
    }

    class PackViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvCustomer = v.findViewById<TextView>(R.id.company_user)!!
        val tvCode = v.findViewById<TextView>(R.id.code_user)!!

        val tv_Customer = v.findViewById<TextView>(R.id.customer)!!
        val tv_jabatan = v.findViewById<TextView>(R.id.jabatan)!!
        val tv_Email = v.findViewById<TextView>(R.id.email)!!
        val tv_Status = v.findViewById<TextView>(R.id.status)!!

        val tv_Customer2 = v.findViewById<TextView>(R.id.customer2)!!
        val tv_jabatan2 = v.findViewById<TextView>(R.id.jabatan2)!!
        val tv_Email2 = v.findViewById<TextView>(R.id.email2)!!
        val tv_Status2 = v.findViewById<TextView>(R.id.status2)!!

        val tv_Customer3 = v.findViewById<TextView>(R.id.customer3)!!
        val tv_jabatan3 = v.findViewById<TextView>(R.id.jabatan3)!!
        val tv_Email3 = v.findViewById<TextView>(R.id.email3)!!
        val tv_Status3 = v.findViewById<TextView>(R.id.status3)!!

        val tv_Customer4 = v.findViewById<TextView>(R.id.customer4)!!
        val tv_jabatan4 = v.findViewById<TextView>(R.id.jabatan4)!!
        val tv_Email4 = v.findViewById<TextView>(R.id.email4)!!
        val tv_Status4 = v.findViewById<TextView>(R.id.status4)!!

    }

    open fun setOnSelectedListener(listener: OnSelectedListener) {
        this.listener = listener
    }

    open interface OnSelectedListener {
        fun onLongSelectedItem(cust: Search)
    }
}
