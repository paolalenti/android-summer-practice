package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.homework2.R
import com.example.homework2.databinding.FragmentManBinding
import com.example.homework2.utils.showSnackbar
import com.google.android.material.snackbar.Snackbar


class ManFragment : Fragment(R.layout.fragment_man) {

    private var binding: FragmentManBinding? = null

    private var adapter: CityAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentManBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = CityAdapter(
                list = CityRepository.cities,
                glide = Glide.with(this@ManFragment),
                onClick = {
                    findNavController().navigate(
                        resId = R.id.action_manFragment_to_manAdvancedFragment,
                        args = ManAdvancedFragment.bundle(context, it.id),
                    )
                }
            )

            rvCity.adapter = adapter

//          по-умолчанию линерлайоутманагер строит вертикальный список
            rvCity.layoutManager = LinearLayoutManager(requireContext())
//            rvCity.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            rvCity.layoutManager = GridLayoutManager(requireContext(), 2)

        }
    }
}