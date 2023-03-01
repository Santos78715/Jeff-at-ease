package com.atease.it.quantum.ui.fragments.splash

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.atease.it.quantum.R
import com.atease.it.quantum.databinding.FragmentAuthOptionsBinding
import com.atease.it.quantum.databinding.FragmentLandingOneBinding
import java.sql.Time

class LandingOneFragment : Fragment() {
    private var _binding: FragmentLandingOneBinding? = null
    private val binding get() = _binding!!
    var text = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingOneBinding.inflate(inflater, container, false)


        binding.radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                text =  if (R.id.yes == checkedId) "yes" else "no"
            })

        binding.nextButton.setOnClickListener {
            when (text) {
                "yes" -> {
                    Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                        .navigate(R.id.action_landingOneFragment_to_landingTwoFragment)
                }
                "no" -> {
                    Toast.makeText(context, "This app is not for you", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(context, "Please answer the question first", Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }



}