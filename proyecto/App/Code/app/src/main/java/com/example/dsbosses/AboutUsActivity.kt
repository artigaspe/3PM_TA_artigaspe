package com.example.dsbosses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val backButton: Button = findViewById<Button>(R.id.btnBack)
        val sendButton: Button = findViewById<Button>(R.id.btnSend)

        val emailText: EditText = findViewById<EditText>(R.id.edtUserEmail)
        val messageText: EditText = findViewById<EditText>(R.id.edtMessage)

        backButton.setOnClickListener{
            Utils.loadActivity(this, LoginActivity())
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
        val title = "WATCH OUT!"
        val message = "Please fill the fields with your email and message"
        Utils.createAlertDialog(this, title, message, "Ok")
    }

    private fun alertSendMessage() {
        val title = "MESSAGE SENT"
        val message = "Your proposals will be atented as soon as possible"
        Utils.createAlertDialog(this, title, message, "Ok")
    }
}