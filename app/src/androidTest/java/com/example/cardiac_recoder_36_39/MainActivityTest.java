package com.example.cardiac_recoder_36_39;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import android.os.SystemClock;


/**
 * This class is for showing the details of the main activity
 */
@RunWith(JUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<ListActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<>(ListActivity.class);

    /**
     * This method is for showing the details of the main activity
     */
    @Test
    public void testAddButton (){
        onView(withId(R.id.listActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.add_button)).check(matches(isDisplayed()));
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.addLayout)).check(matches(isDisplayed()));

        onView(withId(R.id.dateValue)).check(matches(isDisplayed()));
        onView(withId(R.id.timeValue)).check(matches(isDisplayed()));
        onView(withId(R.id.systolicValue)).check(matches(isDisplayed()));
        onView(withId(R.id.diastolicValue)).check(matches(isDisplayed()));
        onView(withId(R.id.heartRateValue)).check(matches(isDisplayed()));


        onView(withId(R.id.dateValue)).perform(ViewActions.typeText("12/10/2021"));
        onView(withId(R.id.timeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.systolicValue)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolicValue)).perform(ViewActions.typeText("90"));
        pressBack();
        onView(withId(R.id.heartRateValue)).perform(ViewActions.typeText("80"));
        pressBack();
        onView(withId(R.id.commentValue)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();
        onView(withId(R.id.addButton)).perform(click());

        SystemClock.sleep(5000);
        onView(ViewMatchers.withId(R.id.recycleview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.DateValue_view)).
                check(matches((withText("12/10/2021"))));

        onView(withId(R.id.editButton)).perform(click());

        onView(withId(R.id.dateValue2)).perform(ViewActions.clearText());
        onView(withId(R.id.dateValue2)).perform(ViewActions.typeText("11/10/2021"));

        onView(withId(R.id.timeValue2)).perform(ViewActions.clearText());
        onView(withId(R.id.timeValue2)).perform(ViewActions.typeText("5.30"));
        pressBack();
        onView(withId(R.id.updateButton)).perform(click());
        SystemClock.sleep(5000);
        onView(withId(R.id.listActivity)).check(matches(isDisplayed()));
    }

    /**
     * This method is for showing the details of the main activity
     */
    @Test
    public void deleteTestButton(){
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.dateValue)).perform(ViewActions.typeText("12/10/2021"));
        onView(withId(R.id.timeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.systolicValue)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolicValue)).perform(ViewActions.typeText("90"));
        pressBack();
        onView(withId(R.id.heartRateValue)).perform(ViewActions.typeText("80"));
        pressBack();
        onView(withId(R.id.commentValue)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.recycleview)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, EFVIewAction.clickChildViewWithId(R.id.deleteButton)));

        onView(withId(R.id.record)).check(matches(isDisplayed()));
        SystemClock.sleep(5000);
    }


}
