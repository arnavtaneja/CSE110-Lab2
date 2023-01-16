package edu.ucsd.cse110.lab2;

import androidx.annotation.ContentView;
import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(
        instrumentedPackages = {
                // required to access final members on androidx.loader.content.ModernAsyncTask
                "androidx.loader.content"
        })

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);

        scenario.onActivity(activity -> {
            activity.findViewById(R.id.btn_one).performClick();
            activity.findViewById(R.id.btn_plus).performClick();
            activity.findViewById(R.id.btn_one).performClick();
            activity.findViewById(R.id.btn_equals).performClick();
            onView(withId(R.id.display)).check(matches(withText("2")));
        });
    }
}
