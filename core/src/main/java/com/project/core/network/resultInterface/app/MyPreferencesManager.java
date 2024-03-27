package com.project.core.network.resultInterface.app;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferencesManager {
    private static MyPreferencesManager instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final int PRIVATE_MODE = Context.MODE_PRIVATE;
    private static String PREFERENCE_NAME = "prefs";

    private MyPreferencesManager(Context context) {
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public static synchronized MyPreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new MyPreferencesManager(context);
        }

        return instance;
    }


}
