package com.example.cardiac_recoder_36_39;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.os.SystemClock;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class RegistrationPageUITest {
    @Rule
    public ActivityScenarioRule<RegisterActivity> activityRule = new ActivityScenarioRule<>(RegisterActivity.class);

    @Test
    public void testRegistrationPage() {
        onView(withId(R.id.regLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.imageView)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.subtitle)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextConfirmPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextEmail)).perform(typeText("dipto1@gmail.com"));
        onView(withId(R.id.editTextPassword)).perform(typeText("12345678"));
        onView(withId(R.id.editTextConfirmPassword)).perform(typeText("12345678"));
        pressBack();
        onView(withId(R.id.buttonRegister)).perform(click());
        SystemClock.sleep(8000);
        onView(withId(R.id.buttonLogin)).check(matches(isDisplayed()));
    }
}
