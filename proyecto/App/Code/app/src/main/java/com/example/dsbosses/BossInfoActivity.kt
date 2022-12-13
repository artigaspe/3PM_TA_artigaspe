package com.example.dsbosses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BossInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boss_info)

        val backButton: Button = findViewById<Button>(R.id.btnBackToBossesList)
        backButton.setOnClickListener{
            val auxIntent = Intent(this, BossesListActivity::class.java)
            this.startActivity(auxIntent)
        }

        val extras = intent.extras
        val bossImageURL: String? = extras?.getString("bossImageURL")

        val bossName: TextView = findViewById<TextView>(R.id.txtAPIname)
        val bossLocation: TextView = findViewById<TextView>(R.id.txtAPIlocation)
        val bossDescription: TextView = findViewById<TextView>(R.id.txtAPIdescription)
        val bossHP: TextView = findViewById<TextView>(R.id.txtAPIhealthPoints)
        val bossMagicRes: TextView = findViewById<TextView>(R.id.txtAPImagicRes)
        val bossFireRes: TextView = findViewById<TextView>(R.id.txtAPIfireRes)
        val bossLightningRes: TextView = findViewById<TextView>(R.id.txtAPIlightningRes)
        val bossPhysiscalRes: TextView = findViewById<TextView>(R.id.txtAPIphysicalRes)
        val bossSlashRes: TextView = findViewById<TextView>(R.id.txtAPIslashRes)
        val bossStrikeRes: TextView = findViewById<TextView>(R.id.txtAPIstrikeRes)
        val bossThrustRes: TextView = findViewById<TextView>(R.id.txtAPIthrustRes)

        bossName.text = extras?.getString("bossName")
        bossLocation.text = extras?.getString("bossLocation")
        bossDescription.text = extras?.getString("bossDescription")
        bossHP.text = extras?.getInt("bossHP").toString()
        bossMagicRes.text = extras?.getInt("bossMagicRes").toString()
        bossFireRes.text = extras?.getInt("bossFireRes").toString()
        bossLightningRes.text = extras?.getInt("bossLightningRes").toString()
        bossPhysiscalRes.text = extras?.getInt("bossPhysicalRes").toString()
        bossSlashRes.text = extras?.getInt("bossSlashRes").toString()
        bossStrikeRes.text = extras?.getInt("bossStrikeRes").toString()
        bossThrustRes.text = extras?.getInt("bossThrustRes").toString()
    }
}