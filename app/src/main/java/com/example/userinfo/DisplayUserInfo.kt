package com.example.userinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayUserInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user_info)
        val userName = intent.getStringExtra(UserName)
        val email= intent.getStringExtra(Email)
        val address = intent.getStringExtra(Address)
        val phoneNumber = intent.getStringExtra(PhoneNumber)
        val pinCode=intent.getStringExtra(PinCode)
        val message="Hi "+userName+", How are you? Are you staying at "+ address +"-"+pinCode+"code. I am not able to contact you on"+phoneNumber+". Can I " +
                "email you the details at "+email
        findViewById<TextView>(R.id.display).text=message
    }
}