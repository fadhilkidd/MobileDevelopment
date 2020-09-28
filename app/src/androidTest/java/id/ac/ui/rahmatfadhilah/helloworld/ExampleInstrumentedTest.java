package id.ac.ui.rahmatfadhilah.helloworld;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {
    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("id.ac.ui.rahmatfadhilah.helloworld", appContext.getPackageName());
    }

    @Test
    public void testHelloWorld() {
        onView(withId(R.id.greeting)).check(matches(withText("HELLO WORLD!")));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.greeting)).check(matches(withText("WELCOME TO ANDROID STUDIO!")));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.greeting)).check(matches(withText("HELLO WORLD!")));
    }
}