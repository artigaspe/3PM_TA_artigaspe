package com.example.jsontest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)
            //.edit()
            //.putString("user", "artigaspe")
            //.commit()
        val edit = sharedPreferences.edit()
        edit.putString("user", "artigaspe")
        edit.commit()

        val userName = sharedPreferences.getString("user", "")
        Log.d("", userName.toString())


        this.getBosses { bossesList ->
            val bossesTextView: TextView = findViewById(R.id.txtView01)
            bossesTextView.text = bossesList.first().name
        }
    }

    fun getBosses(callback: (MutableList<Boss>) -> Unit) {
        val url = "https://dsbosses.free.beeceptor.com/ds1_bosses"
        //val txtView : TextView = findViewById(R.id.txtView01)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val jsonList = response.getJSONArray("Bosses").toString()
                val mutableListType = object : TypeToken<MutableList<Boss>>(){}.type
                val bossesList = Gson().fromJson<MutableList<Boss>>(jsonList, mutableListType)
                //txtView.text = "Response: %s".format(response.toString())
                //txtView.text = "Boss: %s".format(bossesList.last().name.toString())
                Log.i("JSON", response.toString())
                callback(bossesList)
            },
            { error ->
                Log.ERROR
            }
        )
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }

}