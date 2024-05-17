package com.project.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyPreferencesManager<T> {
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

    public static final String IS_ALLOW_PERMISSION_LAUNCH = "IS_ALLOW_PERMISSION_LAUNCH";

    public void setBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean isBoolean(String key) {
        return isBoolean(key, false);
    }

    public boolean isBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }


    public void setString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void setInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }
}
