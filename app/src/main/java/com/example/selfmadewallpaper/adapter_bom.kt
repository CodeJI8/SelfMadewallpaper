package com.example.selfmadewallpaper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adapter_bom(val requireContext: Context, val list_bom: ArrayList<model_bom>) : RecyclerView.Adapter<adapter_bom.viewholder>() {

    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageView = itemView.findViewById<ImageView>(R.id.bom_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_bom, parent, false)
        )
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.imageView
        Glide.with(requireContext).load(list_bom[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, MainActivity2::class.java)
            intent.putExtra("link",list_bom[position].link )
            requireContext.startActivity(intent)

        }
    }


    override fun getItemCount() = list_bom.size



}