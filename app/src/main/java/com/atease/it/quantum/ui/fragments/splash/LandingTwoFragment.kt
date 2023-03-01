package com.atease.it.quantum.ui.fragments.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.atease.it.quantum.R
import com.atease.it.quantum.databinding.FragmentLandingTwoBinding
import com.atease.it.quantum.databinding.FragmentSplashBinding
import kotlinx.coroutines.launch


class LandingTwoFragment : Fragment() {
    private var _binding: FragmentLandingTwoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingTwoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.handshakeImage.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_landingTwoFragment_to_authOptionsFragment)
        }

        binding.textComment.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_landingTwoFragment_to_authOptionsFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}