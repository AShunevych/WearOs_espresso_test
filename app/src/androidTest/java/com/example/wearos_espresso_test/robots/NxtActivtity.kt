package com.example.wearos_espresso_test.robots


import androidx.test.espresso.ViewInteraction
import com.example.wearos_espresso_test.R
import com.example.wearos_espresso_test.helpers.clickOn
import com.example.wearos_espresso_test.helpers.idleUntilVisible
import com.example.wearos_espresso_test.helpers.isVisible

fun nxtActivityRobot(func: NxtActivtity.() -> Unit) = NxtActivtity().apply { func() }

class NxtActivtity :BaseRobot() {

    private val view1: ViewInteraction = onViewWithId(R.id.act)
    private val backButton: ViewInteraction = onViewWithId(R.id.prev_act)

    fun verify() {
        view1.idleUntilVisible(5000)
        backButton.isVisible()
    }

    fun goBack() {
        clickOn(backButton)
    }
}