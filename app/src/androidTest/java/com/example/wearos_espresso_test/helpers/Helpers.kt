package com.example.wearos_espresso_test.helpers

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import org.hamcrest.Matcher

fun ViewInteraction.isGone() = getViewAssertion(ViewMatchers.Visibility.GONE)

fun ViewInteraction.isVisible() = getViewAssertion(ViewMatchers.Visibility.VISIBLE)

fun ViewInteraction.isInvisible() = getViewAssertion(ViewMatchers.Visibility.INVISIBLE)

fun ViewInteraction.idleUntilVisible(timeout: Long) = getViewAssertion(timeout, ViewMatchers.Visibility.VISIBLE)

fun ViewInteraction.idleUntilGone(timeout: Long) = getViewAssertion(timeout, ViewMatchers.Visibility.GONE)

fun ViewInteraction.haveText(text:String): ViewAssertion = ViewAssertions.matches(ViewMatchers.withText(text))

private fun getViewAssertion(visibility: ViewMatchers.Visibility): ViewAssertion? {
    return ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility))
}

private fun getViewAssertion(timeout:Long,visibility: ViewMatchers.Visibility): ViewAssertion? {
    BaristaSleepInteractions.sleep(timeout)
    return ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility))
}

fun clickOn(matcher: ViewInteraction) = matcher
    .perform(ViewActions.click())

fun getText(matcher: Matcher<View?>?): String? {
    val stringHolder = arrayOf<String?>(null)
    Espresso.onView(matcher).perform(object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(TextView::class.java)
        }

        override fun getDescription(): String {
            return "getting text from a TextView"
        }

        override fun perform(uiController: UiController?, view: View) {
            val tv = view as TextView //Save, because of check in getConstraints()
            stringHolder[0] = tv.text.toString()
        }
    })
    return stringHolder[0]
}