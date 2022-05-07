package com.dimasdwipriyono_19102187.siuwa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dimasdwipriyono_19102187.siuwa.MyData
import com.dimasdwipriyono_19102187.siuwa.R
import kotlinx.android.synthetic.main.umkm_item.view.*

class ListMyDataAdapter (
    private val listMyData: ArrayList<MyData>) :
    RecyclerView.Adapter<ListMyDataAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.umkm_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, listMyData[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(myData: MyData) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(myData.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                item_name.text = myData.name
                item_buka.text = myData.jam_buka
                //item_description.text = myData.description
            }
        }
    }
}