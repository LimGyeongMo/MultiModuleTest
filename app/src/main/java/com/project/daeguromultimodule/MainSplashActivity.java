package com.project.daeguromultimodule;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.project.core.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainSplashActivity extends BaseActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        initialize();
    }
    private void initialize() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        timer = new Timer();
        timer.schedule(new DelayStartTask(), 2000);

    }

    private void realStartMainActivity() {
        Intent sendIntent = new Intent(MainSplashActivity.this, MainActivityCategory.class);
        sendIntent.putExtra("intent", getIntent());
        sendIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(sendIntent);
        finish();
    }

    class DelayStartTask extends TimerTask {
        public void run() {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> realStartMainActivity());
        }
    }
}