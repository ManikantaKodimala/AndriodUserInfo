package com.example.userinfo

import android.view.WindowManager
import androidx.test.espresso.Root

import android.os.IBinder
import android.view.WindowManager.LayoutParams
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher : TypeSafeMatcher<Root>() {

    override fun describeTo(description: Description?) {
            description?.appendText("is toast");
    }

    override fun matchesSafely(item: Root?): Boolean {
        val type:Int? = item?.windowLayoutParams?.get()?.type
        if (type == LayoutParams.TYPE_APPLICATION_OVERLAY) {
            val windowToken = item.decorView.windowToken
            val appToken = item.decorView.applicationWindowToken
            if (windowToken === appToken) {
                return true
            }
        }
        return false
    }
}