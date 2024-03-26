package com.project.daeguromultimodule;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static ServiceStarterFactory serviceStarterFactory;

    @Override
    public void onCreate() {
        super.onCreate();

    }
    public interface ServiceStarter {
        void startServiceActivity(Context context);
    }

    public interface ServiceStarterFactory {
        ServiceStarter getServiceStarter();
    }
}