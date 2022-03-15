package com.example.userinfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userinfo.databinding.ActivityNavigationFragmentBinding

class NavigationFragment : Fragment(R.layout.activity_navigation_fragment) {

    private lateinit var binding: ActivityNavigationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityNavigationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[CustomViewModel::class.java] }
            ?: throw RuntimeException("Not a Activity")

        viewModel.isDataValid.observe(viewLifecycleOwner) {
            changeVisibilities(it)
        }

        binding.confirmButton.setOnClickListener {
            viewModel.confirmButtonClicked()
        }
        binding.cancelButton.setOnClickListener {
            viewModel.cancelButtonClicked()
        }


    }

    private fun changeVisibilities(visibility: Boolean) {
        binding.groupedButtons.visibility = if (visibility) View.VISIBLE else View.GONE
    }
}