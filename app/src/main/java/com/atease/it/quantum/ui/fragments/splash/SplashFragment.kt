package com.atease.it.quantum.ui.fragments.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.atease.it.quantum.R
import com.atease.it.quantum.databinding.FragmentSplashBinding
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.myLooper()!!).postDelayed({
            viewLifecycleOwner.lifecycleScope.launch {
                Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                    .navigate(R.id.action_splashFragment_to_getStartedFragment)
            }

        }, 2000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
