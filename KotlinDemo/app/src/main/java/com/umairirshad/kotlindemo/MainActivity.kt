package com.umairirshad.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var arrayList : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<String>(

        )
        //ArrayList<String> aa = new ArrayList<>();

        heading.text = "TODO With Kotlin"

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        var adapter = ForecastListAdapter(items)
        forecastList.adapter = adapter



        addbutton.setOnClickListener {
           var msg : String = edittext.text.toString();
            if(msg.equals("")){
                return@setOnClickListener
            }
            edittext.text.clear()
            adapter.items.add(msg)
            adapter.notifyDataSetChanged()
        }


    }

    fun toast(msg : String, length : Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,msg,length).show()
    }
}
