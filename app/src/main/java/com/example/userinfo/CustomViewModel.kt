package com.example.userinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomViewModel : ViewModel() {
    private val _userName = MutableLiveData("")
    private val _email = MutableLiveData("")
    private val _phoneNumber = MutableLiveData("")
    private val _pinCode = MutableLiveData("")
    private val _address = MutableLiveData("")
    private val _toastMessage = MutableLiveData("")

    private val _isDataValid = MutableLiveData(false)
    private val _isConfirmClicked = MutableLiveData(false)
    private val _isCancelClicked = MutableLiveData(false)

    val userName: LiveData<String> = _userName
    val email: LiveData<String> = _email
    val phoneNumber: LiveData<String> = _phoneNumber
    val pinCode: LiveData<String> = _pinCode
    val address: LiveData<String> = _address
    val isDataValid: LiveData<Boolean> = _isDataValid
    val isConfirmClicked: LiveData<Boolean> = _isConfirmClicked
    val isCancelClicked: LiveData<Boolean> = _isCancelClicked
    val toastMessage: LiveData<String> = _toastMessage


    fun validateInput(allFields: List<String>) {
        val validation = Validation()

        if (validation.checkAllFields(allFields)) {
            val isAllFieldsEnteredProperly = validation.checkAllFieldsEnteredProperly(
                allFields[0],
                allFields[1],
                allFields[2],
                allFields[3]
            )
            if (isAllFieldsEnteredProperly) {
                _isDataValid.postValue(true)
                _userName.postValue(allFields[0])
                _email.postValue(allFields[1])
                _phoneNumber.postValue(allFields[2])
                _pinCode.postValue(allFields[3])
                _address.postValue(allFields[4])
            } else {
                setToastMessages()
            }
        } else {
            setToastMessages()
        }
    }

    fun confirmButtonClicked() {
        _isConfirmClicked.postValue(!_isConfirmClicked.value!!)
    }

    fun cancelButtonClicked() {
        _isCancelClicked.postValue(!_isCancelClicked.value!!)
    }

    private fun setToastMessages() {
        this._toastMessage.postValue(toastMessagePasser)
    }
}
