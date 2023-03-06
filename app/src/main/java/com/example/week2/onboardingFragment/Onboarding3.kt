package com.example.week2.onboardingFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week2.R
import com.example.week2.databinding.FragmentOnboarding3Binding


/**
 * A simple [Fragment] subclass.
 * Use the [Onboarding3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Onboarding3 : Fragment() {
    lateinit var binding : FragmentOnboarding3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOnboarding3Binding.inflate(inflater, container, false)
        binding.Button3.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.action_onboardingScreen3_to_welcomeFragment)
        }
        return binding.root

    }
}