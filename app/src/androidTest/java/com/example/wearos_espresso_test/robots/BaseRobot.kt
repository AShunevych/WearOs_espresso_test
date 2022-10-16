package com.example.wearos_espresso_test.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers


open class BaseRobot {
    fun onViewWithId(id:Int) = Espresso.onView(ViewMatchers.withId(id))

    fun onViewWithIdAndText(id:Int,text:String) =
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(id), ViewMatchers.withText(text)))

    val defaultLoadTime:Long = 5000

}