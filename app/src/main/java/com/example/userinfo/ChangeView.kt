package com.example.userinfo

import android.view.View
import android.widget.Button
import com.example.userinfo.databinding.ActivityUserInputBinding

class ChangeView {
     fun changeVisibilities(
         editale: Boolean,
         binding: ActivityUserInputBinding,
         validateButton: Button,
         ) {
//        buttonsGroup.visibility = if(!visible!!) View.VISIBLE else View.GONE
        validateButton.visibility = if(editale) View.GONE else View.VISIBLE
         binding.userNameET.isEnabled= !editale
         binding.emailET.isEnabled= !editale
         binding.phoneNumberET.isEnabled= !editale
         binding.addressET.isEnabled= !editale
         binding.pinCodeET.isEnabled= !editale
     }

}