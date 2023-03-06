package com.example.week2.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week2.R
import com.example.week2.alertDialog
import com.example.week2.databinding.FragmentProfileBinding

import com.example.week2.viewModels.ProfileViewModel


class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        Log.i("viewmodel", viewModel.currentUserData.toString())
        val applicationCompatibility = (activity as AppCompatActivity)
        binding.edtfullname.setOnClickListener {
            alertDialog("fullName", viewModel).show(
                applicationCompatibility.supportFragmentManager, "dialogalert"

            )
        }

        binding.edtmail.setOnClickListener {
            alertDialog("email", viewModel).show(
                applicationCompatibility.supportFragmentManager, "dialogalert"

            )
        }

        binding.edtphone.setOnClickListener {
            alertDialog("phoneNumber", viewModel).show(
                applicationCompatibility.supportFragmentManager, "dialogalert"

            )
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
        viewModel.isSuccessEvent.observe(viewLifecycleOwner) { successUserKey ->
            //onDialogSubmitFinish()
        }
    }

   // private fun onDialogSubmitFinish() {
//        when (fieldName) {
//            "fullName" -> {
//                binding.edtname.text = DataStore.currentUserData[fieldName]
//                binding.edtfullname.text = DataStore.currentUserData[fieldName]
//            }
//            "email" -> binding.edtmail.text = DataStore.currentUserData[fieldName]
//            "phoneNumber" -> binding.edtphone.text = DataStore.currentUserData[fieldName]
//        }

    }



