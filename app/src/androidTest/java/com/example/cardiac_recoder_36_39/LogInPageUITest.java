package com.example.cardiac_recoder_36_39;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.os.SystemClock;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * This class is for showing the details of the login page
 */
@RunWith(AndroidJUnit4.class)
@LargeTest


public class LogInPageUITest {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    /**
     * This method is for showing the details of the login page
     */
    @Test
    public void testLogInPage() {
        onView(withId(R.id.loginActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.imageView)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.subtitle)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextEmail1)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextPassword1)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextEmail1)).perform(typeText("abc@gmail.com"));
        onView(withId(R.id.editTextPassword1)).perform(typeText("12345678"));
        pressBack();
        onView(withId(R.id.buttonLogin)).perform(click());
        SystemClock.sleep(8000);
        onView(withId(R.id.record)).check(matches(isDisplayed()));
    }

}