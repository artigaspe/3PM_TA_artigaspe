package com.example.dsbosses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class TitlesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_titles)

        val backButton: Button = findViewById<Button>(R.id.btnBackToLogin)
        val demonsButton: ImageButton = findViewById<ImageButton>(R.id.imgBtnDemons)
        val darksoulsButton: ImageButton = findViewById<ImageButton>(R.id.imgBtnDarkSouls)

        backButton.setOnClickListener{
            val auxIntent = Intent(this, LoginActivity::class.java)
            this.startActivity(auxIntent)
        }

        demonsButton.setOnClickListener{
            val auxIntent = Intent(this, BossesListActivity::class.java)
            auxIntent.putExtra("endpoint", Constants.DEMONS_PATH)
            this.startActivity(auxIntent)
        }

        darksoulsButton.setOnClickListener{
            val auxIntent = Intent(this, BossesListActivity::class.java)
            auxIntent.putExtra("endpoint", Constants.DS1_PATH)
            this.startActivity(auxIntent)
        }
    }
}