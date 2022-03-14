package com.example.userinfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userinfo.databinding.ActivityUserInputBinding
import java.lang.RuntimeException


class UserInputFragment : Fragment(R.layout.activity_user_input) {
    private lateinit var binding:ActivityUserInputBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityUserInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[CustomViewModel::class.java] } ?: throw RuntimeException("Not a Activity")
        val allFields = ArrayList<EditText>()

        view.findViewById<Button>(R.id.validateButton).setOnClickListener {
            allFields.add(binding.userNameET)
            allFields.add(binding.emailET)
            allFields.add(binding.phoneNumberET)
            allFields.add(binding.pinCodeET)
            allFields.add(binding.addressET)
           viewModel.validateInput(allFields)
        }
        viewModel.isDataValid.observe(viewLifecycleOwner){
            changeVisibilities(it,binding.userNameET,binding.emailET,binding.phoneNumberET,binding.pinCodeET,binding.addressET,binding.validateButton)
        }
    }

    private fun changeVisibilities(
        visible: Boolean,
        userNameET: EditText,
        emailET: EditText,
        phoneNumberET: EditText,
        pinCodeET: EditText,
        addressET: EditText,
        validateButton: Button
    ) {
        validateButton.visibility = if(visible) View.GONE else View.VISIBLE
        userNameET.isEnabled= !visible
        emailET.isEnabled= !visible
        phoneNumberET.isEnabled= !visible
        addressET.isEnabled= !visible
        pinCodeET.isEnabled= !visible

    }
}
