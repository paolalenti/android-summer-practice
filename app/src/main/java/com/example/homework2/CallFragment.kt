package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework2.R
import com.example.homework2.databinding.FragmentCallBinding
import com.example.homework2.databinding.FragmentSettingsBinding

class CallFragment : Fragment(R.layout.fragment_call) {

    private var binding: FragmentCallBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCallBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}