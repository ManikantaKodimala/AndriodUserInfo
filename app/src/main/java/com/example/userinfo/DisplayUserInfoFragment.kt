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
       val userDetails = viewModel.userDetails.value!!
        var message=""
        viewModel.isConfirmClicked.observe(viewLifecycleOwner) {
            message=getString(R.string.displayUserInfo,userDetails.userName,userDetails.address,userDetails.pinCode,userDetails.phoneNumber,userDetails.email)
            setText(message)
        }


    }

    private fun setText(
        message:String
    ) {
        binding.display.text=message
    }
}