package com.example.userinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomViewModel : ViewModel() {
    private val _userDetails = MutableLiveData(UserDetails("","","","",""))
    private val _toastMessage = MutableLiveData("")
    private val _isDataValid = MutableLiveData(false)
    private val _isConfirmClicked = MutableLiveData(false)
    private val _isCancelClicked = MutableLiveData(false)

    val isDataValid: LiveData<Boolean> = _isDataValid
    val isConfirmClicked: LiveData<Boolean> = _isConfirmClicked
    val isCancelClicked: LiveData<Boolean> = _isCancelClicked
    val toastMessage: LiveData<String> = _toastMessage
    val userDetails:LiveData<UserDetails> = _userDetails


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
                _userDetails.postValue(UserDetails(allFields[0],allFields[1],allFields[2],allFields[3],allFields[4]))
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
        _isDataValid.postValue(false)
    }

    private fun setToastMessages() {
        this._toastMessage.postValue(toastMessagePasser)
    }
}
