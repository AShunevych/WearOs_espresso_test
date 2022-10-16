package com.example.wearos_espresso_test.robots


import androidx.test.espresso.ViewInteraction
import com.example.wearos_espresso_test.R
import com.example.wearos_espresso_test.helpers.clickOn
import com.example.wearos_espresso_test.helpers.haveText
import com.example.wearos_espresso_test.helpers.idleUntilVisible
import com.example.wearos_espresso_test.helpers.isVisible

fun mainRobot(func: MainRobot.() -> Unit) = MainRobot().apply { func() }

class MainRobot : BaseRobot() {

    private val count: ViewInteraction = onViewWithId(R.id.count)
    private val coutnerText: ViewInteraction = onViewWithId(R.id.counter)
    private val nextAct: ViewInteraction = onViewWithId(R.id.activity_next)
    fun verify() {
        count.idleUntilVisible(5000)
        coutnerText.isVisible()
        nextAct.isVisible()
    }

    fun clickOnCounter(){
        clickOn(count)
    }

    fun counterText(textToVerify: String) = coutnerText.haveText(textToVerify)

    fun nextActivity(){
        clickOn(nextAct)
    }
}