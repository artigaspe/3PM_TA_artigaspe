package com.example.dsbosses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userField: EditText = findViewById<EditText>(R.id.edtUser)
        val passwordField: EditText = findViewById<EditText>(R.id.edtPassword)
        val loginButton: Button = findViewById<Button>(R.id.btnLogin)
        val rememberCheckBox: CheckBox = findViewById<CheckBox>(R.id.chkBoxRemember)
        val aboutUsButton: ImageButton = findViewById<ImageButton>(R.id.imgBtnAboutUs)

        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val savedUser = sharedPreferences.getString("user", "").toString()
        val savedPassword = sharedPreferences.getString("password", "").toString()
        val userAlreadyRegistered = sharedPreferences.getBoolean("userRegistered", false)

        if (userAlreadyRegistered){
            userField.setText(savedUser)
        }

        aboutUsButton.setOnClickListener{
            Utils.startNewActivity(this, AboutUsActivity())
        }

        /**
         * Adds functionality to the LOGIN button.
         * If user or password field is empty an alert is shown to the user.
         */
        loginButton.setOnClickListener{
            if (userField.text.isEmpty() || passwordField.text.isEmpty()) {
                alertEmptyFields()
            }else {
                val userString = userField.text.toString()
                val passwordString = passwordField.text.toString()
                if(rememberCheckBox.isChecked) {
                    registerUser(sharedPreferences, userString, passwordString)
                    Utils.startNewActivity(this, TitlesActivity())
                }else{
                    if(checkIfUserExists(userString, passwordString, savedUser, savedPassword)) {
                        Utils.startNewActivity(this, TitlesActivity())
                    }else{
                        alertWrongCredentials()
                    }
                }

            }
        }
    }

    private fun alertEmptyFields() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("WATCH OUT!")
        alert.setMessage("Please fill the fields with your user and password")
        alert.setPositiveButton(
            "Ok"
        ) { dialog, which -> }
        alert.show()
    }

    private fun alertWrongCredentials() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("WRONG CREDENTIALS!")
        alert.setMessage("Error login. Incorrect user or password")
        alert.setPositiveButton(
            "Ok"
        ) { dialog, which -> }
        alert.show()
    }

    private fun registerUser(sharedPreferences: SharedPreferences, newUser: String, newPassword: String) {
        val edit = sharedPreferences.edit()
        edit.putString("user", newUser)
        edit.putString("password", newPassword)
        edit.putBoolean("userRegistered", true)
        edit.commit()
    }

    private fun checkIfUserExists(user: String, password: String, savedUser: String, savedPassword: String): Boolean {
        return ((user == savedUser && password == savedPassword) ||
                (user == "wllop" && password == "MasterOfUniverse"))
    }
}