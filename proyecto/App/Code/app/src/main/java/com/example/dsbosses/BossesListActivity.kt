package com.example.dsbosses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.example.dsbosses.BossFragment.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_bosses_list.*

class BossesListActivity : AppCompatActivity(), OnListFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bosses_list)
    }

    override fun onListFragmentInteraction(item: String?) {
        Snackbar.make(layoutBossesList, item ?: "", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
        val intent = Intent(this, BossInfoActivity::class.java)
        intent.putExtra("bossSelected", item)
        startActivity(intent)
    }
}