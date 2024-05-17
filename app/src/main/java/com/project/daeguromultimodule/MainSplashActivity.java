package com.project.daeguromultimodule;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.project.core.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainSplashActivity extends BaseActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);

        if (getIntent().hasExtra("deepLink")) {
            String deepLink = getIntent().getStringExtra("deepLink");
            Log.d("MainSplashActivity", "Received deepLink: " + deepLink);
        } else {
            Log.d("MainSplashActivity", "No deepLink received");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        timer = new Timer();
        timer.schedule(new DelayStartTask(), 2000);
    }

    @Override
    public void onBackPressed() {
        timer.cancel();
        super.onBackPressed();
    }


    private void realStartMainActivity() {
        Intent sendIntent = new Intent(MainSplashActivity.this, MainActivityCategory.class);
        if (getIntent().hasExtra("deepLink")) {
            sendIntent.putExtra("deepLink", getIntent().getStringExtra("deepLink"));
        }
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