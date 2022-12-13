package com.example.dsbosses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.example.dsbosses.BossFragment.*
import kotlinx.android.synthetic.main.activity_bosses_list.*

class BossesListActivity : AppCompatActivity(), OnListFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bosses_list)
    }

    override fun onListFragmentInteraction(item: BossEntity?) {
        Snackbar.make(layoutBossesList, item?.name ?: "", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
        val mIntent = Intent(this, BossInfoActivity::class.java)
        val mBundle = Bundle()
        mBundle.putString("bossName", item?.name)
        mBundle.putString("bossImageURL", item?.image)
        mBundle.putString("bossLocation", item?.location)
        mBundle.putString("bossDescription", item?.description)
        mBundle.putInt("bossHP", item?.healthPoints!!)
        mBundle.putInt("bossMagicRes", item?.magicRes!!)
        mBundle.putInt("bossFireRes", item?.fireRes!!)
        mBundle.putInt("bossLightningRes", item?.lightningRes!!)
        mBundle.putInt("bossPhysicalRes", item?.physicalRes!!)
        mBundle.putInt("bossSlashRes", item?.slashRes!!)
        mBundle.putInt("bossStrikeRes", item?.strikeRes!!)
        mBundle.putInt("bossThrustRes", item?.thrustRes!!)

        mIntent.putExtras(mBundle)
        startActivity(mIntent)
    }
}