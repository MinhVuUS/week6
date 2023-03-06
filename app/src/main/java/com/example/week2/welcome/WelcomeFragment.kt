package com.example.week2.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week2.R
import com.example.week2.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignin.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_welcomeFragment_to_signinFragment)
        }
        binding.btnSignup.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.action_welcomeFragment_to_signupFragment)
        }


    }
}