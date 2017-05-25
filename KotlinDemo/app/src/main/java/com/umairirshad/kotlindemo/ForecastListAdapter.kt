package com.umairirshad.kotlindemo

import android.support.v7.widget.AppCompatAutoCompleteTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Umair Irshad on 5/25/2017.
 */
class ForecastListAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rootView.findViewById(R.id.imageView).setOnClickListener{
            items.removeAt(position)
            notifyDataSetChanged()
        }
        (holder.rootView.findViewById(R.id.textview) as TextView).text = items[position]

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        var inflater : View =  LayoutInflater.from(parent?.context).inflate(R.layout.rowitem,parent,false);
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //class ViewHolder(val textView: TextView?) : RecyclerView.ViewHolder(textView)
    class ViewHolder(val rootView: View) : RecyclerView.ViewHolder(rootView)

}