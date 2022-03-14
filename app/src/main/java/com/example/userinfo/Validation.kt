package com.example.userinfo

import android.content.Context
import android.widget.EditText
import android.widget.Toast

class Validation(applicationContext: Context) {
    var  context: Context=applicationContext

    fun checkAllFields(
        fields: ArrayList<EditText>
    ): Boolean {
        for (field in fields) {
            if (isFieldEmpty(field.text.toString())) {
                makeToast(field.hint.toString())
                return false
            }
        }
        return true
    }

    fun checkAllFieldsEnteredProperly(
        userName: String,
        email: String,
        phoneNumber: String,
        pinCode: String,
    ): Boolean {

        if (!userNamePattern.matches(userName.trim())) {
            makeToast("UserName should be only Alpha Numerics")
            return false
        }
        if (!emailPattern.matches(email.trim())) {
            makeToast("Email should be of @  .com or @ co.in in Numerics")
            return false
        }
        if (!phoneNumberPattern.matches(phoneNumber.trim())) {
            makeToast("Phone number should be of 10 Digits")
            return false
        }
        if (!pinCodePattern.matches(pinCode.trim())) {
            makeToast("Pin code should be of 6 Digits")
            return false
        }
        return true
    }

    fun makeToast(text: String) {
        val toast = Toast.makeText(this.context, text, Toast.LENGTH_SHORT)
        toast.show()
    }
    fun isFieldEmpty(field: String): Boolean {
        if (field.trim().isEmpty()) {
            return true
        }
        return false
    }
}