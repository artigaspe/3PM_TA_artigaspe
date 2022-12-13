package com.example.dsbosses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dsbosses.BossFragment.*

class BossesListActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bosses_list)
        val backButton: Button = findViewById<Button>(R.id.btnBackToTitles)
        backButton.setOnClickListener{
            Utils.loadActivity(this, TitlesActivity())
        }
    }

    override fun onListFragmentInteraction(item: BossEntity?) {
        val extra = intent.extras
        val endPoint: String? = extra?.getString("endpoint")
        val auxIntent = Intent(this, BossInfoActivity::class.java)
        val auxBundle = Bundle()
        auxBundle.putString("endpoint", endPoint)
        auxBundle.putString("bossName", item?.name)
        auxBundle.putString("bossImageURL", item?.image)
        auxBundle.putString("bossLocation", item?.location)
        auxBundle.putString("bossDescription", item?.description)
        auxBundle.putInt("bossHP", item?.healthPoints!!)
        auxBundle.putInt("bossMagicRes", item?.magicRes!!)
        auxBundle.putInt("bossFireRes", item?.fireRes!!)
        auxBundle.putInt("bossLightningRes", item?.lightningRes!!)
        auxBundle.putInt("bossPhysicalRes", item?.physicalRes!!)
        auxBundle.putInt("bossSlashRes", item?.slashRes!!)
        auxBundle.putInt("bossStrikeRes", item?.strikeRes!!)
        auxBundle.putInt("bossThrustRes", item?.thrustRes!!)

        auxIntent.putExtras(auxBundle)
        startActivity(auxIntent)
    }
}