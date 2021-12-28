package com.example.awesomerecyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ExpandableAdapter (val context: Context, val list:ArrayList<DataModel>) :RecyclerView.Adapter<ExpandableAdapter.ViewHolderclss>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderclss {
        val view= LayoutInflater.from(context).inflate(R.layout.expandablelayout,parent,false)
        return ViewHolderclss(view)
    }

    override fun onBindViewHolder(holder: ViewHolderclss, position: Int) {
        val ob=list.get(position)
        holder.titletextview.setImageResource(ob.image)

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderclss(view: View) : RecyclerView.ViewHolder(view)
    {
        val titletextview=view.findViewById<ImageView>(R.id.expandable_imageview)

    }
}