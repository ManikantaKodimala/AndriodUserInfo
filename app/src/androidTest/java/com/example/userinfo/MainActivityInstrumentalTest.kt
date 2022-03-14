package com.example.userinfo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentalTest {

    @get:Rule
    val rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Before
    fun setUp(){
        onView(withId(R.id.userNameET)).perform(typeText("Mani"), closeSoftKeyboard())
        onView(withId(R.id.emailET)).perform(typeText("mani@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.phoneNumberET)).perform(typeText("9848290109"), closeSoftKeyboard())
        onView(withId(R.id.pinCodeET)).perform(typeText("506009"), closeSoftKeyboard())
        onView(withId(R.id.addressET)).perform(typeText("maniHnk"), closeSoftKeyboard())
    }

    @Test
    fun validationCheck() {


        onView(withId(R.id.validateButton)).perform(click())

        onView(withId(R.id.userNameET)).check(matches(withText("Mani")))
        onView(withId(R.id.emailET)).check(matches(withText("mani@gmail.com")))
        onView(withId(R.id.phoneNumberET)).check(matches(withText("9848290109")))
        onView(withId(R.id.pinCodeET)).check(matches(withText("506009")))
        onView(withId(R.id.addressET)).check(matches(withText("maniHnk")))

    }

    @Test
    fun onValidationEditTextsShouldBeDisable() {

        onView(withId(R.id.validateButton)).perform(click())
        onView(withId(R.id.userNameET)).check(matches(not(isEnabled())))
    }

    @Test
    fun onValidationCancelButtonShouldBeEnable() {


        onView(withId(R.id.validateButton)).perform(click())
        onView(withId(R.id.cancelButton)).check(matches(isEnabled()))
    }

    @Test
    fun onValidationConfirmButtonShouldBeEnable() {
        onView(withId(R.id.validateButton)).perform(click())
        onView(withId(R.id.confirmButton)).check(matches(isEnabled()))
    }

    @Test
    fun onValidationFailReturnsToastMessage() {
        onView(withId(R.id.userNameET)).perform(clearText(), closeSoftKeyboard())
        onView(withId(R.id.validateButton)).perform(click())
        onView(withText(R.string.EnterUserName)).inRoot(ToastMatcher()).check(matches(isDisplayed()))

    }
    @Test
    fun onConfirmingTheDataItShouldGoToDisplayActivityToDisplayTheEnteredData(){
        onView(withId(R.id.validateButton)).perform(click())
            onView(withId(R.id.confirmButton)).perform(click())
    }
}