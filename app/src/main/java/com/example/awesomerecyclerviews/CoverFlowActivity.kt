package com.example.awesomerecyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kapil.circularlayoutmanager.CircularLayoutManager
import recycler.coverflow.CoverFlowLayoutManger

class CoverFlowActivity : AppCompatActivity() {
    lateinit var list:ArrayList<DataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover_flow)
             list= arrayListOf()
            val coverflowrecycler:RecyclerView=findViewById(R.id.coverflowrecycler)

            val ob=DataModel()
            ob.image=R.drawable.dev

            for (i in 0..10)
                list.add(i,ob)

            //val layoutcircle=CircularLayoutManager(10.5,65.1)
            //val layoutcircle=CircularLayoutManager(this,null,0,0)


            Toast.makeText(this,"in coverflow layout",Toast.LENGTH_SHORT).show()
            val adapterdemo=CoverFlowAdapter(this,list)
            coverflowrecycler.layoutManager=CoverFlowLayoutManger(true,false,true,"45.1".toString().toFloat())
            coverflowrecycler.adapter=adapterdemo







    }
}