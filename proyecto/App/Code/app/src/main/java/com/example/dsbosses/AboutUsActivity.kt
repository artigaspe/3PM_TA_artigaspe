package com.example.dsbosses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val backButton: Button = findViewById<Button>(R.id.btnBack)
        val sendButton: Button = findViewById<Button>(R.id.btnSend)

        val emailText: EditText = findViewById<EditText>(R.id.edtUserEmail)
        val messageText: EditText = findViewById<EditText>(R.id.edtMessage)

        backButton.setOnClickListener{
            val auxIntent = Intent(this, LoginActivity::class.java)
            this.startActivity(auxIntent)
        }

        sendButton.setOnClickListener{
            if (emailText.text.isEmpty() || messageText.text.isEmpty()) {
                alertEmptyFields()
            } else{
                alertSendMessage()
                emailText.text.clear()
                messageText.text.clear()
            }
        }
    }

    private fun alertEmptyFields() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("WATCH OUT!")
        alert.setMessage("Please fill the fields with your email and message")
        alert.setPositiveButton(
            "Ok"
        ) { dialog, which -> }
        alert.show()
    }

    private fun alertSendMessage() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("MESSAGE SENT")
        alert.setMessage("Your proposals will be atented as soon as possible")
        alert.setPositiveButton(
            "Ok"
        ) { dialog, which -> }
        alert.show()
    }
}