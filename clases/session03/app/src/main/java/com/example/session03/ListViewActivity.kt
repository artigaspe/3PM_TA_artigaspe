package com.example.session03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.listView01)
        // val listTestView: ListView = this.findViewById(R.id.listView01)

        val bosses = arrayOf("Ornstein", "Smoug", "Manus", "Seath", "Nito")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bosses)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, l ->
            //Log.d("LIST", bosses[position].toString())
            Log.d("LIST", adapter.getItem(position).toString())
        }
    }
}