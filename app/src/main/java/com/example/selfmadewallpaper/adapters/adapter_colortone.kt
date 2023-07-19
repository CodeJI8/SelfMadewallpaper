package com.example.selfmadewallpaper.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.selfmadewallpaper.MainActivity2
import com.example.selfmadewallpaper.R
import com.example.selfmadewallpaper.model.model_colortone

class adapter_colortone(val requireContext: Context,  val list_colortone: ArrayList<model_colortone>) : RecyclerView.Adapter<adapter_colortone.viewholder>() {
    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageview = itemView.findViewById<ImageView>(R.id.colortone_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_colortone, parent, false)
        )
    }

    override fun getItemCount() = list_colortone.size

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.imageview
        Glide.with(requireContext).load(list_colortone[position].link).into(holder.imageview)
       holder.itemView.setOnClickListener {
           val intent = Intent(requireContext, MainActivity2::class.java)
           intent.putExtra("link",list_colortone[position].link )
           requireContext.startActivity(intent)
       }
       }
    }
