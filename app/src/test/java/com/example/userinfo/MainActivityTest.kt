package com.example.userinfo


import android.widget.EditText
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityTest{


    @MockK
    private lateinit var mainActivity: MainActivity
    private val nameEdit: EditText=EditText(MainActivity())

    @get:Rule
    var rule: TestRule=InstantTaskExecutorRule()

    @Before
    fun setUp() {
        mainActivity=MainActivity()

    }

    @Test
    fun checksWhetherFieldIsEmpty_Returns_True(){
//    nameEdit.setText("")

//    assertTrue(userInputActivity.isFieldEmpty(nameEdit))
    }
}