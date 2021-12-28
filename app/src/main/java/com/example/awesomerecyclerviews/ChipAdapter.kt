package com.example.awesomerecyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChipAdapter(val context: Context, val list:ArrayList<String>)  : RecyclerView.Adapter<ChipAdapter.ViewHolderclss>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderclss {
        val view= LayoutInflater.from(context).inflate(R.layout.chiplayout,parent,false)
        return ViewHolderclss(view)
    }

    override fun onBindViewHolder(holder: ViewHolderclss, position: Int) {

        holder.titletextview.text=list.get(position)

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderclss(view: View) : RecyclerView.ViewHolder(view)
    {
        val titletextview=view.findViewById<TextView>(R.id.chiptextview)

    }
}

