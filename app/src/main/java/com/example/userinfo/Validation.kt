package com.example.userinfo

class Validation {

    fun checkAllFields(
        fields: List<String>
    ): Boolean {

        return !fields.any {
            isFieldEmpty(it)
        }
    }

    fun checkAllFieldsEnteredProperly(
        userName: String,
        email: String,
        phoneNumber: String,
        pinCode: String,
    ): Boolean {
        if (!userNamePattern.matches(userName.trim())) {
            toastMessagePasser="UserName should be only Alpha Numerics"
            return false
        }
        if (!emailPattern.matches(email.trim())) {
            toastMessagePasser="Email should be of @  .com or @ co.in in Numerics"
            return false
        }
        if (!phoneNumberPattern.matches(phoneNumber.trim())) {
            toastMessagePasser="Phone number should be of 10 Digits"
            return false
        }
        if (!pinCodePattern.matches(pinCode.trim())) {
            toastMessagePasser="Pin code should be of 6 Digits"
            return false
        }
        return true
    }


    fun isFieldEmpty(field: String): Boolean {
        return field.trim().isEmpty()
    }
}