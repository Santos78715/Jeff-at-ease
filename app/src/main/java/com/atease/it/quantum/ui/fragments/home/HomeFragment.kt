package com.atease.it.quantum.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.atease.it.quantum.R
import com.atease.it.quantum.databinding.FragmentHomeBinding
import com.atease.it.quantum.databinding.FragmentSignUpBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchBar.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_nav_home_to_searchFragment)
        }

        val imageList = ArrayList<SlideModel>()

        val n = 5
        imageList.add(SlideModel("https://i.ibb.co/LNMrs3x/image.png",""))
        imageList.add(SlideModel("https://i.ibb.co/LNMrs3x/image.png",""))
        imageList.add(SlideModel("https://i.ibb.co/LNMrs3x/image.png",""))
        imageList.add(SlideModel("https://i.ibb.co/LNMrs3x/image.png",""))
        imageList.add(SlideModel("https://i.ibb.co/LNMrs3x/image.png",""))

        binding.homeSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
    }

}