package com.example.userinfo


import android.widget.EditText
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class UserInputActivityTest{


    @MockK
    private lateinit var userInputActivity: UserInputActivity
    private val nameEdit: EditText=EditText(UserInputActivity())

    @get:Rule
    var rule: TestRule=InstantTaskExecutorRule()

    @Before
    fun setUp() {
        userInputActivity=UserInputActivity()

    }

    @Test
    fun checksWhetherFieldIsEmpty_Returns_True(){
//    nameEdit.setText("")

//    assertTrue(userInputActivity.isFieldEmpty(nameEdit))
    }
}