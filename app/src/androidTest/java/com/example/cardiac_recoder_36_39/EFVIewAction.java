package com.example.cardiac_recoder_36_39;

import android.view.View;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import org.hamcrest.Matcher;

/**
 * This class is for showing the details
 */
public class EFVIewAction {

    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            /**
             * @return A matcher that accepts a view if it matches the constraints.
             */
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            /**
             * @return A description of the view action.
             */
            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            /**
             * @param uiController the controller to use to interact with the UI.
             * @param view         the view to act upon. never null.
             */
            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }

}
