package com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.R

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class UiTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCompareInputs() {
        Espresso.onView(
            ViewMatchers.withId(R.id.compareBtn)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.stateTxt)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las contraseñas coinciden!")
            )
        )
    }
}