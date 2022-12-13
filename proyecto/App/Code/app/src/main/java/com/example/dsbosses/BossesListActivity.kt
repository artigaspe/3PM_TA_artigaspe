package com.example.dsbosses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.example.dsbosses.BossFragment.*
import kotlinx.android.synthetic.main.activity_bosses_list.*

class BossesListActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bosses_list)
        val backButton: Button = findViewById<Button>(R.id.btnBackToTitles)
        backButton.setOnClickListener{
            val auxIntent = Intent(this, TitlesActivity::class.java)
            this.startActivity(auxIntent)
        }
    }

    override fun onListFragmentInteraction(item: BossEntity?) {
        Snackbar.make(layoutBossesList, item?.name ?: "", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
        val extra = intent.extras
        val endPoint: String? = extra?.getString("endpoint")
        val auxIntent = Intent(this, BossInfoActivity::class.java)
        val auxBundle = Bundle()
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