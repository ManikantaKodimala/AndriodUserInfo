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
    private lateinit var binding: ActivityUserInputBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityUserInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[CustomViewModel::class.java] }
            ?: throw RuntimeException("Not a Activity")

        binding.validateButton.setOnClickListener {
            val allFieldsValues = getValueOfFields()
            viewModel.validateInput(allFieldsValues)
        }
        viewModel.isDataValid.observe(viewLifecycleOwner) {
            changeVisibilities(
                it,
                binding.userNameET,
                binding.emailET,
                binding.phoneNumberET,
                binding.pinCodeET,
                binding.addressET,
                binding.validateButton
            )
        }
    }

    private fun getValueOfFields(): List<String> {
        val allValues = ArrayList<String>()
        for (i in 0 until binding.userDetailsLayout.childCount) {
            if (binding.userDetailsLayout.getChildAt(i) is EditText) {
                allValues.add((binding.userDetailsLayout.getChildAt(i) as EditText).text.toString())
            }
        }
        return allValues
    }

    private fun changeVisibilities(
        editable: Boolean,
        userNameET: EditText,
        emailET: EditText,
        phoneNumberET: EditText,
        pinCodeET: EditText,
        addressET: EditText,
        validateButton: Button
    ) {
        validateButton.visibility = if (editable) View.GONE else View.VISIBLE
        userNameET.isEnabled = !editable
        emailET.isEnabled = !editable
        phoneNumberET.isEnabled = !editable
        addressET.isEnabled = !editable
        pinCodeET.isEnabled = !editable

    }
}
