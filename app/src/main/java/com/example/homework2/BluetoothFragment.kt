package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework2.R
import com.example.homework2.databinding.FragmentBluetoothBinding
import com.example.homework2.databinding.FragmentSettingsBinding

class BluetoothFragment : Fragment(R.layout.fragment_bluetooth) {

    private var binding: FragmentBluetoothBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBluetoothBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}