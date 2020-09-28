package id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.

 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CounterInstrumentedTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab", appContext.packageName)
    }

    @Test
    fun testInitialCounter() {
        onView(withId(R.id.tx))
            .check(matches(withText("0")))
    }

    @Test
    fun buttonDisplayedWhenClicked() {
        onView(withId(R.id.bt)).perform(click())
            .check(matches(isDisplayed()))
    }
}
