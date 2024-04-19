package com.project.daeguromultimodule;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

public class MyApplication extends Application {

    private static ServiceStarterFactory serviceStarterFactory;

    @Override
    public void onCreate() {
        super.onCreate();

    }
    public void resetApp (Context context) {
        new Intent(context, MainSplashActivity.class);
    }

    public interface ServiceStarter {
        void startServiceActivity(Context context);
    }

    public interface ServiceStarterFactory {
        ServiceStarter getServiceStarter();
    }
}