package com.example.dsbosses

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide

object Utils {

    fun loadActivity(currentContext: Context, desiredActivity: Activity) {
        val auxIntent = Intent(currentContext, desiredActivity::class.java)
        currentContext.startActivity(auxIntent)
    }

    fun loadActivityWithExtra(currentContext: Context, desiredActivity: Activity,
                              keyName: String, keyValue: String) {
        val auxIntent = Intent(currentContext, desiredActivity::class.java)
        auxIntent.putExtra(keyName, keyValue)
        currentContext.startActivity(auxIntent)
    }

    fun createAlertDialog(currentContext: Context, title: String, message: String, button: String) {
        val alert = AlertDialog.Builder(currentContext)
        alert.setTitle(title)
        alert.setMessage(message)
        alert.setPositiveButton(button) { dialog, which -> }
        alert.show()
    }

    fun loadImageFromURL(currentContext: Context, imgURL: String, viewID: String) {

        val imageViewID = currentContext.resources.getIdentifier(viewID, "id", currentContext.packageName)
        val bossImage: ImageView = (currentContext as Activity).findViewById<ImageView>(imageViewID)
        Glide.with(currentContext).load(imgURL).centerCrop().into(bossImage)
    }
}