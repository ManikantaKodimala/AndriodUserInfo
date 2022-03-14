package com.example.userinfo

val userNamePattern = Regex("^[A-za-z]([A-za-z]|[0-9])*$")
val pinCodePattern  = Regex("^[1-9][0-9]{5}$")
val emailPattern = Regex("^[a-zA-Z0-9._-]+@[a-z]+\\.+(com|co\\.in)")
val phoneNumberPattern=Regex("^[1-9][0-9]{9}$")
