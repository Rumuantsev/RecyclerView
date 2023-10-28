package com.example.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

interface CellClickListener{
    fun onCellClickListener (data: ColorData)
}

class MainActivity : AppCompatActivity(), CellClickListener{
    private  lateinit var myRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.rView)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = myAdapter(this, fetchList(), this)
    }

    fun fetchList() : ArrayList<ColorData> {
        val  list = arrayListOf<ColorData>()

        list.add(ColorData("Blue", Color.BLUE))
        list.add(ColorData("Black", Color.BLACK))
        list.add(ColorData("Yellow", Color.YELLOW))
        list.add(ColorData("Red", Color.RED))
        list.add(ColorData("Blue", Color.BLUE))
        list.add(ColorData("Black", Color.BLACK))
        list.add(ColorData("Yellow", Color.YELLOW))
        list.add(ColorData("Red", Color.RED))

        return list
    }

    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this,data.colorName, Toast.LENGTH_LONG).show()
    }
}

data class ColorData (
    var colorName : String,
    var colorHex : Int
)
