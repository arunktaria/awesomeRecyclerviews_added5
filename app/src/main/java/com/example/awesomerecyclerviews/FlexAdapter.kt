package com.example.awesomerecyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlexAdapter(val context: Context, val list:ArrayList<ImageDataModel>) : RecyclerView.Adapter<FlexAdapter.ViewHolderclss>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderclss {
        val view= LayoutInflater.from(context).inflate(R.layout.flexlayout,parent,false)
        return ViewHolderclss(view)
    }

    override fun onBindViewHolder(holder: ViewHolderclss, position: Int) {
        val ob=list.get(position)
         holder.imageview1.setImageResource(ob.image1)
        holder.imageview2.setImageResource(ob.image2)
        holder.imageview3.setImageResource(ob.image3)

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderclss(view: View) : RecyclerView.ViewHolder(view)
    {

        val imageview1=view.findViewById<ImageView>(R.id.firstimgview)
        val imageview2=view.findViewById<ImageView>(R.id.imageviewmiddel)
        val imageview3=view.findViewById<ImageView>(R.id.lastimgview)

    }

}
