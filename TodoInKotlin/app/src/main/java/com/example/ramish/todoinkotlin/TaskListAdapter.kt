package com.example.ramish.todoinkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

/**
 * Created by Ramish Hassan on 5/25/2017.
 */
class TaskListAdapter(val tasks:ArrayList<Task>):RecyclerView.Adapter<TaskListAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tv : TextView = holder.v.findViewById(R.id.task_name_display) as TextView
        var cb : CheckBox = holder.v.findViewById(R.id.task_check) as CheckBox

        tv.text=tasks.get(position).taskName
        cb.isChecked=tasks.get(position).isComplete

        cb.setOnClickListener {
            if (cb.isChecked){
                tasks.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
       return tasks.size
    }

//    class ViewHolder(val textView: TextView, val checkBox: CheckBox)
    class ViewHolder(val v:View):RecyclerView.ViewHolder(v)

}