package com.example.dsbosses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val backButton: Button = findViewById<Button>(R.id.btnBack)
        backButton.setOnClickListener{
            Utils.startNewActivity(this, LoginActivity())
        }

        val test: TextView = findViewById<TextView>(R.id.txtCompany)
        /*this.getAboutUs { aboutusList ->
            test.text = aboutusList.first().toString()
        }*/
        this.getBosses { bossesList ->
            test.text = bossesList.first().name
        }

    }

    fun getBosses(callback: (MutableList<BossEntity>) -> Unit ){
        val url = Constants.API_URL + Constants.DS1_PATH
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, { response ->
            /*val status = response.optInt(Constants.STATUS, Constants.ERROR)
            if (status == Constants.SUCCESS) {*/
                val jsonList = response.getJSONArray(Constants.BOSSES_PROPERTY).toString()
                val mutableListType = object : TypeToken<MutableList<BossEntity>>(){}.type
                val bossesList = Gson().fromJson<MutableList<BossEntity>>(jsonList, mutableListType)
                callback(bossesList)
            },
            { error ->
                error.printStackTrace()
            }
        )

        var requestQueue = Volley.newRequestQueue(this) //(myActivity as Context)
        requestQueue.add(jsonObjectRequest)
    }

    fun getAboutUs(callback: (MutableList<String>) -> Unit ){
        val url = Constants.API_URL + Constants.ABOUTUS_PATH
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            /*val status = response.optInt(Constants.STATUS, Constants.ERROR)
            if (status == Constants.SUCCESS) {*/
                val jsonList = response.getJSONObject("aboutus").toString()
                val mutableListType = object : TypeToken<MutableList<String>>(){}.type
                val aboutusList = Gson().fromJson<MutableList<String>>(jsonList, mutableListType)

                callback(aboutusList)

        },{ error ->
            error.printStackTrace()
        })

        var requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }
}