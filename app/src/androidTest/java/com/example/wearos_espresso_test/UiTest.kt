package com.example.wearos_espresso_test

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import com.example.wearos_espresso_test.robots.mainRobot
import com.example.wearos_espresso_test.robots.nxtActivityRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test fun testClicker(){
        mainRobot {
            verify()
            val text = listOf("0","1","2","3")
            for(str in text){
                counterText(str)
                clickOnCounter()
                BaristaSleepInteractions.sleep(500)
            }
        }
    }

    @Test
    fun testGoNxtActivityAndBack(){
        mainRobot {
            verify()
            nextActivity()
        }
        nxtActivityRobot {
            verify()
            goBack()
        }
        mainRobot {
            verify()
        }
    }
}