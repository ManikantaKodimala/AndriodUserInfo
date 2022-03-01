package com.example.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val UserName="userName"
const val Email="email"
const val PhoneNumber="phoneNumber"
const val Address="address"
const val PinCode="pinCode"
const val Visible="visible"
class UserInputActivity : AppCompatActivity() {

    var visible:Boolean?= true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_input)

        val validateButton = findViewById<Button>(R.id.validateButton)
        val userName = findViewById<EditText>(R.id.userNameET)
         val email = findViewById<EditText>(R.id.emailET)
         val phoneNumber = findViewById<EditText>(R.id.phoneNumberET)
         val pinCode = findViewById<EditText>(R.id.pinCodeET)
         val address = findViewById<EditText>(R.id.addressET)
         val confirmButton= findViewById<Button>(R.id.ConfirmButton)
         val cancelButton=findViewById<Button>(R.id.cancelButton)


        validateButton?.setOnClickListener {
            val allFields = ArrayList<EditText?>()
            allFields.add(userName)
            allFields.add(email)
            allFields.add(phoneNumber)
            allFields.add(pinCode)
            allFields.add(address)
            val allButtons=ArrayList<Button?>()
            allButtons.add(confirmButton)
            allButtons.add(validateButton)
            allButtons.add(cancelButton)
            val isAllFieldsChecked = checkAllFields(allFields)
            if (isAllFieldsChecked) {
                val isAllFieldsEnteredProperly = checkAllFieldsEnteredProperly(userName, email, phoneNumber, pinCode, address)
                if (isAllFieldsEnteredProperly) {
                    visible=false
                    changeVisibilities(visible,userName,email,phoneNumber,pinCode,address,cancelButton,validateButton,confirmButton)
                }
            }
        }
        cancelButton?.setOnClickListener{
            visible=true
            changeVisibilities(visible,userName,email,phoneNumber,pinCode,address,cancelButton,validateButton,confirmButton)
        }
        confirmButton?.setOnClickListener{
            val intent= Intent(this,DisplayUserInfo::class.java)
            intent.putExtra(UserName,userName?.text.toString())
            intent.putExtra(Address,address?.text.toString())
            intent.putExtra(PinCode,pinCode?.text.toString())
            intent.putExtra(PhoneNumber,phoneNumber?.text.toString())
            intent.putExtra(Email,email?.text.toString())
            startActivity(intent)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(Visible, visible!!)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        visible=savedInstanceState.getBoolean(Visible)
        val validateButton = findViewById<Button>(R.id.validateButton)
        val userName = findViewById<EditText>(R.id.userNameET)
        val email = findViewById<EditText>(R.id.emailET)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumberET)
        val pinCode = findViewById<EditText>(R.id.pinCodeET)
        val address = findViewById<EditText>(R.id.addressET)
        val confirmButton= findViewById<Button>(R.id.ConfirmButton)
        val cancelButton=findViewById<Button>(R.id.cancelButton)
        changeVisibilities(visible,userName,email,phoneNumber,pinCode,address,cancelButton,validateButton,confirmButton)
    }
    private fun changeVisibilities(
        visible: Boolean?,
        userName: EditText,
        email: EditText,
        phoneNumber: EditText,
        pinCode: EditText,
        address: EditText,
        cancelButton: Button,
        validateButton: Button,
        confirmButton: Button
    ) {
        confirmButton.visibility = if(!visible!!) View.VISIBLE else View.GONE
        cancelButton.visibility = if(!visible) View.VISIBLE else View.GONE
        validateButton.visibility = if(visible) View.VISIBLE else View.GONE
        userName.isEnabled=visible
        email.isEnabled=visible
        phoneNumber.isEnabled=visible
        pinCode.isEnabled=visible
        address.isEnabled=visible
    }

    private fun checkAllFieldsEnteredProperly(
        userName: EditText?,
        email: EditText?,
        phoneNumber: EditText?,
        pinCode: EditText?,
        address: EditText?
    ): Boolean {
        val userNamePattern = Regex("^[A-za-z0-9]*$")
        val pinCodePattern  = Regex("^[1-9][0-9]{5}$")
        val emailPattern = Regex("^[a-zA-Z0-9._-]+@[a-z]+\\.+(com|co\\.in)")
        if (!userNamePattern.matches(userName?.text.toString().trim())) {
            makeToast("UserName should be only Alpha Numerics")
            return false
        }
        if (!emailPattern.matches(email?.text.toString().trim())) {
            makeToast("Email should be of @  .com or @ .in in Numerics")
            return false
        }
        if (phoneNumber?.text.toString().trim().length != 10) {
            makeToast("Phone number should be of 10 Digits")
            return false
        }
        if (pinCode?.text.toString().trim().length !=6 ) {
            makeToast("Pin code should be of 6 Digits")
            return false
        }
        if (address?.text.toString().trim().isEmpty()) {
            makeToast("Address ")
            return false
        }
        return true
    }

    private fun checkAllFields(
        fields: ArrayList<EditText?>
    ): Boolean {
        for (field in fields) {
            if (isFieldEmpty(field))
                return false
        }
        return true
    }

    fun isFieldEmpty(field: EditText?): Boolean {
        if (field?.text.toString().trim().isEmpty()) {
            makeToast(field?.hint.toString())
            return true
        }
        return false
    }

    fun makeToast(text: String) {
        val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
        toast.show()
    }
}