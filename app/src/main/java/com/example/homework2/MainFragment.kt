package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.ProfileFragment
import com.example.homework2.R
import com.example.homework2.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run {
            sendButton.setOnClickListener {
                if (etEmail.text.toString().isEmpty()){
                    Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_LONG).show()
                }
                else{
                    // findNavController - получаем контроллер для работы с навигацией
                    findNavController().navigate(
                        resId = R.id.action_mainFragment_to_profileFragment,
                        args = ProfileFragment.bundle(
                            email = etEmail.text.toString(),
                        )
                    )
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}