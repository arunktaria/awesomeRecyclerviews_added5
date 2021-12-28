package com.example.awesomerecyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FanLayoutRecycler(val context: Context, val list:ArrayList<DataModel>) :RecyclerView.Adapter<FanLayoutRecycler.ViewHolderclss>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderclss {
    val view=LayoutInflater.from(context).inflate(R.layout.itemlistlayout,parent,false)
        return ViewHolderclss(view)
    }

    override fun onBindViewHolder(holder: ViewHolderclss, position: Int) {
        val ob=list.get(position)
        holder.titletextview.text=ob.title.toString()
        holder.destextview.text=ob.des.toString()
        holder.imageview.setImageResource(ob.image)
    }

    override fun getItemCount(): Int {
    return list.size
    }


    class ViewHolderclss(view: View) : RecyclerView.ViewHolder(view)
    {
        val titletextview=view.findViewById<TextView>(R.id.titletextitem)
        val destextview=view.findViewById<TextView>(R.id.destextitem)
        val imageview=view.findViewById<ImageView>(R.id.imageviewitem)

    }
}