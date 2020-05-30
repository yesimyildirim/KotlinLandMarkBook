package com.yesimyildirim.kotlinlandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

var selectedGlobalBitmap : Bitmap? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Data
        var landmarkNames =  ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colloseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")
        //Image

        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colloseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colloseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londonbridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colloseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(londonbridge)

        //Adapter: Layout & Data

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)
        listview.adapter = adapter

        listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailsActivity::class.java)
            intent.putExtra("name",landmarkNames[position])
            val singleton =Singleton.Selected
            singleton.selectedImage =landmarkImages[position]
            startActivity(intent)
        }


    }
}
