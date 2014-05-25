package com.teamtreehouse.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;
import com.teamtreehouse.ribbit.ui.MainActivity;
import com.teamtreehouse.ribbit.utils.ParseConstants;

public class RibbitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "yKRswsrDimrUE3pr7c1JSIbn31DHnTK6t30r0jFc",
                                "wijuLwvwZTdn4BoxyGMW7VDWJca7b5KSOXVhl4Eu");

        PushService.setDefaultPushCallback(this, MainActivity.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

    public static void updateParseInstallation(ParseUser user) {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();

    }
}

