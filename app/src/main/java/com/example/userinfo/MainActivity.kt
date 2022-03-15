package com.example.userinfo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[CustomViewModel::class.java]

        viewModel.isDataValid.observe(this) { valid ->
            showScreen(valid)
        }

        viewModel.isConfirmClicked.observe(this) {
            showDisplay(it)
        }

        viewModel.isCancelClicked.observe(this){

        }
        viewModel.toastMessage.observe(this) {
            makeToast(it)
        }

    }

    private fun showDisplay(it: Boolean) {
        if (it) {
            showFragment(R.id.first_container, DisplayUserInfoFragment(), true)
            showFragment(R.id.second_container, Fragment(), true)
        }
    }

    private fun showScreen(valid: Boolean) {
        if (valid) {
            showFragment(R.id.second_container, NavigationFragment(), true)
        } else {
            showFragment(R.id.first_container, UserInputFragment(), true)
        }
    }

    private fun showFragment(@IdRes resId: Int, fragment: Fragment, backStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(resId, fragment)
        if (backStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    private fun makeToast(text: String) {
        val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
        toast.show()
    }
}