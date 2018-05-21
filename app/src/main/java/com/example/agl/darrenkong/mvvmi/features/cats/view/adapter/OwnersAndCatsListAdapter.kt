package com.example.agl.darrenkong.mvvmi.features.cats.view.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.agl.darrenkong.mvvmi.R
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatHeader
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatName
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatNameItem

/**
 * Created by darrenkong on 16/5/18.
 */
class OwnersAndCatsListAdapter(private val dataList: List<CatNameItem>) : RecyclerView.Adapter<OwnersAndCatsListAdapter.CatViewholder>() {

    override fun onBindViewHolder(holder: CatViewholder, position: Int) {

        var genderOrCatName = ""

        val item = dataList[position]
        when (item) {
            is CatHeader -> genderOrCatName = item.ownerGenderType
            is CatName -> genderOrCatName = item.catName
        }

        holder.textView.text = genderOrCatName
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)

        return CatViewholder(view)
    }

    inner class CatViewholder(itemView: View) : ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.name)
    }
}