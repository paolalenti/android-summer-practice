package com.example.homework2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.homework2.R
import com.example.homework2.databinding.FragmentManAdvancedBinding
import com.example.homework2.CityRepository


class ManAdvancedFragment : Fragment(R.layout.fragment_man_advanced) {
    private var binding: FragmentManAdvancedBinding? = null
    private val requestOptions = RequestOptions.diskCacheStrategyOf(
        DiskCacheStrategy.ALL
    )
    private var glide: RequestManager? = null

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentManAdvancedBinding.bind(view)
        glide = Glide.with(this@ManAdvancedFragment)
        binding?.run {
            val url = arguments?.getString(ARG_URL)
            glide?.load(url)
                ?.error(R.drawable.img_not_found)
                ?.placeholder(R.drawable.img_cat)?.apply(requestOptions)
                ?.into(ivAboutImage)
            tvCountry.text = arguments?.getString(ARG_NAME)
            tvCapital.text = arguments?.getString(ARG_DESCRIPTION)
            tvPopulation.text = arguments?.getString(ARG_POPULATION)
            tvLanguage.text = arguments?.getString(ARG_LANGUAGE)

            fabGoBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        private const val ARG_URL = "URL"
        private const val ARG_NAME = "NAME"
        private const val ARG_DESCRIPTION = "DESCRIPTION"
        private const val ARG_POPULATION = "POPULATION"
        private const val ARG_LANGUAGE = "LANGUAGE"
        fun bundle(context: Context?, indx: Int): Bundle = Bundle().apply {
            val city = CityRepository.cities.find {it.id == indx}
            if (city != null) {
                putString(ARG_URL, city.url)
                putString(ARG_NAME, city.country)
                putString(ARG_DESCRIPTION, city.name)
                putString(ARG_POPULATION, city.population)
                putString(ARG_LANGUAGE, city.language)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}