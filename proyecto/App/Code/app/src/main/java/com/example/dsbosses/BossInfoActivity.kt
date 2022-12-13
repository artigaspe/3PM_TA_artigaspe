package com.example.dsbosses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BossInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boss_info)

        val extra = intent.extras
        val bossSelected: String? = extra?.getString("bossSelected")

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



        this.getBosses { bossesList ->
            bossName.text = bossesList.first().name
            bossLocation.text = bossesList.first().location
            bossDescription.text = bossesList.first().description
            bossHP.text = bossesList.first().healthPoints.toString()
            bossMagicRes.text = bossesList.first().magicRes.toString()
            bossFireRes.text = bossesList.first().fireRes.toString()
            bossLightningRes.text = bossesList.first().lightningRes.toString()
            bossPhysiscalRes.text = bossesList.first().physicalRes.toString()
            bossSlashRes.text = bossesList.first().slashRes.toString()
            bossStrikeRes.text = bossesList.first().strikeRes.toString()
            bossThrustRes.text = bossesList.first().thrustRes.toString()
            /*for(i in bossesList) {
                if(i.name == bossSelected.toString()){
                    bossName.text = i.name
                    bossLocation.text = i.location
                    bossDescription.text = i.description
                    bossHP.text = i.healthPoints.toString()
                    bossMagicRes.text = i.magicRes.toString()
                    bossFireRes.text = i.fireRes.toString()
                    bossLightningRes.text = i.lightningRes.toString()
                    bossPhysiscalRes.text = i.physicalRes.toString()
                    bossSlashRes.text = i.slashRes.toString()
                    bossStrikeRes.text = i.strikeRes.toString()
                    bossThrustRes.text = i.thrustRes.toString()
                }
            }*/

        }
    }

    fun getBosses(callback: (MutableList<BossEntity>) -> Unit ){
        val url = Constants.API_URL + Constants.DS1_PATH
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, { response ->
                /*val status = response.optInt(Constants.STATUS, Constants.ERROR)
                if (status == Constants.SUCCESS) {*/
                val jsonList = response.getJSONArray(Constants.BOSSES_PROPERTY).toString()
                val mutableListType = object : TypeToken<MutableList<BossEntity>>(){}.type
                val bossesList = Gson().fromJson<MutableList<BossEntity>>(jsonList, mutableListType)
                callback(bossesList)
            },
            { error ->
                error.printStackTrace()
            }
        )

        var requestQueue = Volley.newRequestQueue(this) //(myActivity as Context)
        requestQueue.add(jsonObjectRequest)
    }
}