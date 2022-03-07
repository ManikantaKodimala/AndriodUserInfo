package com.example.userinfo

import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.Group

class ChangeView {
     fun changeVisibilities(
        visible: Boolean?,
        viewGroup: Group,
        validateButton: Button,
        buttonsGroup: Group,

        ) {
        buttonsGroup.visibility = if(!visible!!) View.VISIBLE else View.GONE
        validateButton.visibility = if(visible) View.VISIBLE else View.GONE
        viewGroup.isEnabled=false
    }
}