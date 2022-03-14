package com.example.userinfo

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayUserInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user_info)
        val userName = intent.getStringExtra(UserName)
        val email= intent.getStringExtra(Email)
        val address = intent.getStringExtra(Address)
        val phoneNumber = intent.getStringExtra(PhoneNumber)
        val pinCode=intent.getStringExtra(PinCode)
        val message=getString(R.string.displayUserInfo,userName,address,pinCode,phoneNumber,email)
        findViewById<TextView>(R.id.display).text=message
    }
}