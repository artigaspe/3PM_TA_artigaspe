package com.example.dsbosses

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
            Utils.loadActivity(this, LoginActivity())
        }

        demonsButton.setOnClickListener{
            Utils.loadActivityWithExtra(
                this, BossesListActivity(), "endpoint", Constants.DEMONS_PATH)
        }

        darksoulsButton.setOnClickListener{
            Utils.loadActivityWithExtra(
                this, BossesListActivity(), "endpoint", Constants.DS1_PATH)
        }
    }
}