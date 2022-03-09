package com.example.userinfo

import android.os.Binder
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.Group
import com.example.userinfo.databinding.ActivityUserInputBinding

class ChangeView {
     fun changeVisibilities(
         visible: Boolean?,
         binding: ActivityUserInputBinding,
         validateButton: Button,
         buttonsGroup: Group,

         ) {
        buttonsGroup.visibility = if(!visible!!) View.VISIBLE else View.GONE
        validateButton.visibility = if(visible) View.VISIBLE else View.GONE
         binding.userNameET.isEnabled=visible
         binding.emailET.isEnabled=visible
         binding.phoneNumberET.isEnabled=visible
         binding.addressET.isEnabled=visible
         binding.pinCodeET.isEnabled=visible
     }

}