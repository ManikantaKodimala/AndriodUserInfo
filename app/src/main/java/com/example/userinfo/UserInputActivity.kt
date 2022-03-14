package com.example.userinfo

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.userinfo.databinding.ActivityUserInputBinding

class UserInputActivity : AppCompatActivity() {

    var visible:Boolean?=true
    lateinit var binding: ActivityUserInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val allFields = ArrayList<EditText>()
        allFields.add(binding.userNameET)
        allFields.add(binding.emailET)
        allFields.add(binding.phoneNumberET)
        allFields.add(binding.pinCodeET)
        allFields.add(binding.addressET)
        val validation=Validation(applicationContext)
        val changeView= ChangeView()
        binding.validateButton.setOnClickListener {
            if (validation.checkAllFields(allFields)) {
                val isAllFieldsEnteredProperly = validation.checkAllFieldsEnteredProperly(binding.userNameET.text.toString(), binding.emailET.text.toString(), binding.phoneNumberET.text.toString(), binding.pinCodeET.text.toString())
                if (isAllFieldsEnteredProperly) {
                    visible=false
                    changeView.changeVisibilities(visible,binding,binding.validateButton,binding.groupedButtons)
                }
            }
        }

        binding.cancelButton.setOnClickListener{
            visible=true
            changeView.changeVisibilities(visible,binding,binding.validateButton,binding.groupedButtons)
        }

        binding.confirmButton.setOnClickListener{
            val intent= Intent(this,DisplayUserInfo::class.java)
            intent.putExtra(UserName,binding.userNameET.text.toString())
            intent.putExtra(Address,binding.addressET.text.toString())
            intent.putExtra(PinCode,binding.pinCodeET.text.toString())
            intent.putExtra(PhoneNumber,binding.phoneNumberET.text.toString())
            intent.putExtra(Email,binding.emailET.text.toString())
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(Visible, visible!!)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val changeView= ChangeView()

        visible=savedInstanceState.getBoolean(Visible)
        changeView.changeVisibilities(visible,binding,binding.validateButton,binding.groupedButtons)
    }

}