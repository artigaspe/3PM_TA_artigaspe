package com.example.session03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("", "onCreate")

        //val intent = Intent(this, MainActivity2::class.java)
        //startActivity(intent)

        val btn = findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("", "onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.e("", "onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.e("", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("", "onDestroy")
    }
}