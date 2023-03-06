package com.example.week2.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week2.singleonData.DataStore
import java.util.regex.Pattern


class SignupViewModel : ViewModel() {
    private var _isErrorEvent: MutableLiveData<String> = MutableLiveData()
    val isErrorEvent: LiveData<String>
        get() = _isErrorEvent

    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
        get() = _isSuccessEvent

    fun onSignUp(fullName: String, email: String, password: String) {

        var _errorString = ""

        // check fullName
        if (fullName.isNullOrEmpty())
            _errorString += "Your full name is null or empty"

        // check email
        if (!isEmailValid(email))
        {
            if(_errorString.isNotEmpty()) _errorString += "\n"
            _errorString += "Invalid E-mail"
        }

        if(isExistEmail(email))
        {
            if(_errorString.isNotEmpty()) _errorString += "\n"
            _errorString += "E-mail is already exist"
        }
        // check password
        if (!isPasswordValid(password))
        {
            if(_errorString.isNotEmpty()) _errorString += "\n"
            _errorString += "\nInvalid Password "
        }

        // Throw Error
        if(_errorString.isNotEmpty())
            return _isErrorEvent.postValue(_errorString)

        _isSuccessEvent.postValue(true)

    }

    private fun isExistEmail(email: String): Boolean {
        val _isExistEmail = DataStore.userDataStore.find { userData -> userData["email"] == email }?.isNotEmpty()
        return _isExistEmail == true
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordREGEX = Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                ".{8,}" +               //at least 8 characters
                "$");
        return passwordREGEX.matcher(password).matches()

    }

}