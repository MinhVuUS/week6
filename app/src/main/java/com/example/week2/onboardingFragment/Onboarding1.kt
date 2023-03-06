package com.example.week2.onboardingFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week2.R
import com.example.week2.databinding.FragmentOnboarding1Binding


/**
 * A simple [Fragment] subclass.
 * Use the [Onboarding1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Onboarding1 : Fragment() {
lateinit var binding: FragmentOnboarding1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.action_onboardingScreen1_to_onboardingScreen2)
        }
    }

}