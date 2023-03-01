package com.atease.it.quantum.ui.fragments.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.atease.it.quantum.R
import com.atease.it.quantum.databinding.FragmentGetStartedBinding
import com.atease.it.quantum.databinding.FragmentSplashBinding
import com.atease.it.quantum.ui.activity.MainActivity


class GetStartedFragment : Fragment() {
    private var _binding: FragmentGetStartedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGetStartedBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.getStartedButton.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_getStartedFragment_to_landingOneFragment)
        }
    }

}