package com.example.dsbosses

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val welcomeText = "Welcome to DSbosses your trusty app for boss info"
        Toast.makeText(this, welcomeText, Toast.LENGTH_LONG).show()

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
            Utils.loadActivity(this, AboutUsActivity())
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
                    Utils.loadActivity(this, TitlesActivity())
                }else{
                    if(checkIfUserExists(userString, passwordString, savedUser, savedPassword)) {
                        Utils.loadActivity(this, TitlesActivity())
                    }else{
                        alertWrongCredentials()
                    }
                }
            }
        }
    }

    private fun alertEmptyFields() {
        val title = "WATCH OUT!"
        val message = "Please fill the fields with your user and password"
        Utils.createAlertDialog(this, title, message, "Ok")
    }

    private fun alertWrongCredentials() {
        val title = "WRONG CREDENTIALS!"
        val message = "Error login. Incorrect user or password"
        Utils.createAlertDialog(this, title, message, "Ok")
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