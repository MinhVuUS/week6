package com.example.week2.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week2.R
import com.example.week2.databinding.FragmentOnboarding2Binding
import com.example.week2.databinding.FragmentSignupBinding
import com.example.week2.singleonData.DataStore
import com.example.week2.viewModels.SignupViewModel


class SignupFragment : Fragment() {
    lateinit var binding: FragmentSignupBinding
    private lateinit var viewModel: SignupViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        binding.viewModel = viewModel
        binding.buttonSignUp.setOnClickListener { onSignUp() }

        binding.textViewSignin.setOnClickListener {
           val controller = findNavController()
            controller.navigate(R.id.action_signupFragment_to_signinFragment)

      }
        listenerSuccessEvent()
        listenerErrorEvent()
        return binding.root
    }
    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(viewLifecycleOwner) { errMsg ->
            Toast.makeText(binding.root.context, errMsg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                // Success
                DataStore.userDataStore.add(
                    mutableMapOf(
                        "fullName" to binding.fullNameInputText.text.toString(),
                        "email" to binding.emailInputText.text.toString(),
                        "password" to binding.passwordInputText.text.toString()
                    )
                )
                Toast.makeText(binding.root.context, "SignUp Success", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun onSignUp() {
        viewModel.onSignUp(
            binding.fullNameInputText.text.toString(),
            binding.emailInputText.text.toString(),
            binding.passwordInputText.text.toString()

        )
    }

    fun isValidPassword(passwordInputText: EditText): Boolean {
        passwordInputText?.let {
            val passwordPattern =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(passwordInputText.text.toString()) != null
        } ?: return false
    }
}