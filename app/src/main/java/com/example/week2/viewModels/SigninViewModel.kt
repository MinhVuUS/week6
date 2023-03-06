package com.example.week2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week2.singleonData.DataStore

class SigninViewModel : ViewModel() {
    private var _isErrorEvent: MutableLiveData<String> = MutableLiveData()
    val isErrorEvent: LiveData<String>
        get() = _isErrorEvent

    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
    get() = _isSuccessEvent
    fun onLogin(email: String, password: String) {
        var _errorString = ""
        val foundUser = DataStore.userDataStore.find { userData -> userData["email"] == email }

        if (foundUser == null) {
            _errorString += "Invalid Email or Password"
        }
        else
        {
            if(password != foundUser["password"])
                _errorString += "Invalid Password"
        }

        if(_errorString.isNotEmpty())
            return _isErrorEvent.postValue(_errorString)

        if (foundUser != null) {
            DataStore.currentUserData.value = foundUser
        }

        _isSuccessEvent.postValue(true)
    }
}
