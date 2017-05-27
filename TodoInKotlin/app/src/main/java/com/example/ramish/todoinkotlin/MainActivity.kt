package com.example.ramish.todoinkotlin

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_task.*

class MainActivity : AppCompatActivity() {

    var taskList : ArrayList<Task> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rc:RecyclerView=findViewById(R.id.task_recyclerView) as RecyclerView



        add_task_button.setOnClickListener {
            runOnUiThread {
                val dialog:Dialog= Dialog(this)
                dialog.setContentView(R.layout.dialog_add_task)
                dialog.setCancelable(false)
                dialog.show()
                dialog.save_button.setOnClickListener {
                    val name:String=dialog.task_name_field.text.toString()
                    val newTask:Task= Task(name,false)
                    taskList.add(newTask)
                    rc.layoutManager=LinearLayoutManager(this)
                    rc.adapter=TaskListAdapter(taskList)
                    rc.adapter.notifyDataSetChanged()
                }

                dialog.cancel_button.setOnClickListener {
                    dialog.dismiss()
                }
            }


        }

    }
}
