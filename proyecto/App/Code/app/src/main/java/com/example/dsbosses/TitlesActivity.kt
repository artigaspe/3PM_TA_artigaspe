package com.example.dsbosses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class TitlesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_titles)

        val demonsButton: ImageButton = findViewById<ImageButton>(R.id.imgBtnDemons)
        val darksoulsButton: ImageButton = findViewById<ImageButton>(R.id.imgBtnDarkSouls)

        demonsButton.setOnClickListener{
            Utils.startNewActivity(this, BossesListActivity())
        }

        darksoulsButton.setOnClickListener{
            Utils.startNewActivity(this, BossInfoActivity())
        }
    }
}