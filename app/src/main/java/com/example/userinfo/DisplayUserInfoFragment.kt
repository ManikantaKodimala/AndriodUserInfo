package com.example.userinfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userinfo.databinding.ActivityDisplayUserInfoBinding

class DisplayUserInfoFragment : Fragment(R.layout.activity_display_user_info) {

    private lateinit var binding: ActivityDisplayUserInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityDisplayUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[CustomViewModel::class.java] } ?: throw RuntimeException("Not a Activity")
        val userName=viewModel.userName.value!!
        Log.i("userName in dis",userName)
        val email=viewModel.email.value!!
        Log.i("email in dis",email)
        val phoneNumber=viewModel.phoneNumber.value!!
        val pinCode = viewModel.pinCode.value!!
        val address= viewModel.address.value!!
        viewModel.isConfirmClicked.observe(viewLifecycleOwner) {
            setText(userName,email,phoneNumber,pinCode,address)
        }


    }

    private fun setText(
        userName: String,
        email: String,
        phoneNumber: String,
        pinCode: String,
        address: String
    ) {
        binding.display.text=getString(R.string.displayUserInfo,userName,address,pinCode.toString(),phoneNumber.toString(),email)
    }
}