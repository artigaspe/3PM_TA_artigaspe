package com.example.dsbosses

import android.app.Activity
import android.content.Context
import android.content.Intent

object Utils {

    fun startNewActivity(currentContext: Context, newActivity: Activity) {
        val intent = Intent(currentContext, newActivity::class.java)
        currentContext.startActivity(intent)
    }
}