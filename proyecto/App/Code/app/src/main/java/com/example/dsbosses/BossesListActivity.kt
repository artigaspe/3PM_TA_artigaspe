package com.example.dsbosses

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

    override fun onListFragmentInteraction(item: String?) {
        Snackbar.make(layoutBossesList, item ?: "", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }
}