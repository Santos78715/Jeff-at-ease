package com.atease.it.quantum.ui.fragments.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.atease.it.quantum.R
import com.atease.it.quantum.databinding.FragmentAuthOptionsBinding
import com.atease.it.quantum.databinding.FragmentSplashBinding
import kotlinx.coroutines.launch


class AuthOptionsFragment : Fragment() {
    private var _binding: FragmentAuthOptionsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthOptionsBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.loginButton.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_authOptionsFragment_to_loginFragment)
        }
        binding.signupButton.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_authOptionsFragment_to_signUpFragment)
        }
    }

}