package com.example.week2.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week2.R
import com.example.week2.databinding.FragmentSigninBinding
//import com.example.week2.signup.Signup
import com.example.week2.viewModels.SigninViewModel

class SigninFragment : Fragment() {
    private lateinit var viewModel: SigninViewModel
    lateinit var binding: FragmentSigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SigninViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     binding.login.setOnClickListener {
            loginOnClick()
        }
        binding.signin2.setOnClickListener {
          val controller = findNavController()
           controller.navigate(R.id.action_signinFragment_to_signupFragment)

        }
        listenerSuccessEvent()
        listenerErrorEvent()
    }
        private fun listenerErrorEvent() {
            viewModel.isErrorEvent.observe(viewLifecycleOwner) { errMsg ->
                Toast.makeText(binding.root.context, errMsg, Toast.LENGTH_SHORT).show()
            }
        }

        private fun listenerSuccessEvent() {
            viewModel.isSuccessEvent.observe(viewLifecycleOwner) { isSuccess ->
                if(isSuccess)
                {
                    // Success
                    Toast.makeText(binding.root.context, "SignIn Success", Toast.LENGTH_SHORT).show()
                    val controller = findNavController()
                    controller.navigate(R.id.action_signinFragment_to_restaurantFragment)
                }
            }
        }

        private fun onSignUpNavigate() {
//            val controller = findNavController()
//                    controller.navigate(R.id.action_signinFragment_to_profileFragment)

        }

        private fun loginOnClick() {
            viewModel.onLogin(binding.edtusername.text.toString(), binding.edtpassword.text.toString())
        }








}
