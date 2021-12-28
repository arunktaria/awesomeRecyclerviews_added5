package com.example.awesomerecyclerviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cleveroad.fanlayoutmanager.FanLayoutManager
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager

import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

import com.google.android.flexbox.FlexDirection
import com.littlemango.stacklayoutmanager.StackLayoutManager
import com.stone.vega.library.VegaLayoutManager
import com.kapil.circularlayoutmanager.CircularLayoutManager as CircularLayoutManager1

class MainActivity : AppCompatActivity() {
    lateinit var recyclerview:RecyclerView
    lateinit var titletextview:TextView
    lateinit var adapter:FanLayoutRecycler
    lateinit var list:ArrayList<DataModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     titletextview=findViewById(R.id.titleofmain)
      supportActionBar?.setTitle("RecyclerView")
        supportActionBar?.setSubtitle("Awesome")
        recyclerview=findViewById(R.id.recyclerview)
        list= arrayListOf()
        val ob=DataModel()
        ob.title="hello world"
        ob.des="description"
        ob.image=R.drawable.dev
        for (i in 0..10)
            list.add(i,ob)




    }



    fun stacklayout() {
        titletextview.setText("Stack RecyclerView")
        list.clear()
        val ob=DataModel()
        ob.image=R.drawable.dev

        for (i in 0..10)
            list.add(i,ob)

        val stacklayoutmanager=StackLayoutManager()
            stacklayoutmanager.setItemOffset(60)
        val adapterdemo=ExpandableAdapter(this,list)


        recyclerview.layoutManager=stacklayoutmanager
        recyclerview.adapter=adapterdemo


    }



    fun circularLayout() {
        titletextview.setText("Circular RecyclerView")
        list.clear()
        val ob=DataModel()
        ob.image=R.drawable.dev

        for (i in 0..10)
            list.add(i,ob)

        //val layoutcircle=CircularLayoutManager(10.5,65.1)
        //val layoutcircle=CircularLayoutManager(this,null,0,0)

        //val layoutcircle= CircularLayoutManager1(this,null,0,0)
        val layoutcircle= CircularLayoutManager1("150.2".toString().toFloat(),"300.0".toString().toFloat(),"250.0".toString().toFloat())
        val adapterdemo=CircularRecyclerAdapter(this,list)
        recyclerview.layoutManager=layoutcircle
        recyclerview.adapter=adapterdemo


    }














    fun FanLayoutCall()
    {
        titletextview.setText("Fan RecyclerView")
        list.clear()
        val ob=DataModel()
        ob.image=R.drawable.dev


        for (i in 0..10)
            list.add(i,ob)



        adapter=FanLayoutRecycler(this,list)

        val fanLayoutManagerSettings = FanLayoutManagerSettings
            .newBuilder(this)
            .withFanRadius(true)
            .withAngleItemBounce(8f)
            .withViewWidthDp(150f)
            .withViewHeightDp(180f)
            .build()

        recyclerview.layoutManager=FanLayoutManager(this,fanLayoutManagerSettings)
        recyclerview.adapter=adapter


    }

fun chiplayout()
{
    titletextview.setText("chip RecyclerView")
   var listchip= arrayListOf<String>()

    for (i in 0..30)
        listchip.add(i,"chip"+i.toString())

    val chipAdapter:ChipAdapter
    val chipsLayoutManager =
        ChipsLayoutManager.newBuilder(this) //set vertical gravity for all items in a row. Default = Gravity.CENTER_VERTICAL
            .setChildGravity(Gravity.TOP) //whether RecyclerView can scroll. TRUE by default
            .setScrollingEnabled(true) //set maximum views count in a particular row
            .setMaxViewsInRow(2) //set gravity resolver where you can determine gravity for item in position.
            .setGravityResolver {
                Gravity.CENTER
            }
            //you are able to break row due to your conditions. Row breaker should return true for that views
            .setRowBreaker {
                    position -> position == 6 || position == 11 || position == 2 } //a layoutOrientation of layout manager, could be VERTICAL OR HORIZONTAL. HORIZONTAL by default
            .setOrientation(ChipsLayoutManager.HORIZONTAL) // row strategy for views in completed row, could be STRATEGY_DEFAULT, STRATEGY_FILL_VIEW,
            //STRATEGY_FILL_SPACE or STRATEGY_CENTER
            .setRowStrategy(ChipsLayoutManager.STRATEGY_FILL_SPACE) // whether strategy is applied to last row. FALSE by default
            .withLastRow(true)
            .build()
    recyclerview.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
   chipAdapter=ChipAdapter(this,listchip)
    recyclerview.setLayoutManager(chipsLayoutManager)
    recyclerview.adapter=chipAdapter



}



    fun FlexBox()
    {

        val adapterflex:FlexAdapter
        titletextview.setText("flex RecyclerView")
        val templist= arrayListOf<ImageDataModel>()
        val ob=ImageDataModel()
        ob.image1=R.drawable.dev
        ob.image2=R.drawable.dev
        ob.image3=R.drawable.dev

        for (i in 0..20)
        {  templist.add(i,ob)}

        adapterflex= FlexAdapter(this,templist)

        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.COLUMN
        layoutManager.justifyContent = JustifyContent.FLEX_END

        recyclerview.layoutManager=layoutManager
        recyclerview.adapter=adapterflex


    }



    fun vegalayout()
    {
        titletextview.setText("vega  RecyclerView")
        list.clear()
        val ob=DataModel()

        ob.title="hello world"
        ob.des="this is vega layout"
        ob.image=R.drawable.dev
        for (i in 0..10)
            list.add(i,ob)
        adapter=FanLayoutRecycler(this,list)

        val vega=VegaLayoutManager()
        vega.canScrollHorizontally()

        recyclerview.layoutManager=vega
        recyclerview.adapter=adapter


    }





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val infla=MenuInflater(this)
        infla.inflate(R.menu.selectrecycler,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.fanlayoutmenu->
            {
                FanLayoutCall()
            }

            R.id.chiplayout->
            {
                chiplayout()

            }

            R.id.flexmenu->
            {
                FlexBox()

            }
            R.id.vegamenu->
            {
                vegalayout()
            }
            R.id.stacklayout->
            {
                stacklayout()

            }
            R.id.circularlayout->
            {
                circularLayout()

            }

            R.id.coverlayoutmenuitem ->
            {
             startActivity(Intent(MainActivity@this,CoverFlowActivity::class.java))
            }



        }

        return super.onOptionsItemSelected(item)
    }



}