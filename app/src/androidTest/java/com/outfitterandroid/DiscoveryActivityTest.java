package com.outfitterandroid;

/**
 * Created by Kris on 4/5/2015.
 */

import android.test.ActivityInstrumentationTestCase2;

import com.parse.ParseUser;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DiscoveryActivityTest extends ActivityInstrumentationTestCase2 {

    private static final String VALID_USERNAME = "i_am_a_user\n";
    private static final String VALID_PASSWORD = "i_am_a_user\n";

    public DiscoveryActivityTest() {
        super(LoginDispatchActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        if(ParseUser.getCurrentUser() != null){
            ParseUser.logOut();
        }
        getActivity();
    }

    //TODO Finish tests
    public void testDiscoveryOpen() throws InterruptedException {
        onView(withId(R.id.login_username_input)).perform(typeText(VALID_USERNAME));
        onView(withId(R.id.login_password_input)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.parse_login_button)).perform(click());
        Thread.sleep(500);
        onView(withId(R.id.profile_discovery_button)).check(matches(withText("Discovery")));
        onView(withId(R.id.profile_discovery_button)).perform(click());

    }

    public void testDiscoveryDislikeButtonExists() throws InterruptedException {
        onView(withId(R.id.login_username_input)).perform(typeText(VALID_USERNAME));
        onView(withId(R.id.login_password_input)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.parse_login_button)).perform(click());
        Thread.sleep(500);
        onView(withId(R.id.profile_discovery_button)).check(matches(withText("Discovery")));
        onView(withId(R.id.profile_discovery_button)).perform(click());
        onView(withId(R.id.discovery_dislike_button)).check(matches(withText("Dislike")));
    }

    public void testDiscoverLikeButtonExists() throws InterruptedException {
        onView(withId(R.id.login_username_input)).perform(typeText(VALID_USERNAME));
        onView(withId(R.id.login_password_input)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.parse_login_button)).perform(click());
        Thread.sleep(500);
        onView(withId(R.id.profile_discovery_button)).check(matches(withText("Discovery")));
        onView(withId(R.id.profile_discovery_button)).perform(click());
        onView(withId(R.id.discovery_like_button)).check(matches(withText("Like")));
    }

}
