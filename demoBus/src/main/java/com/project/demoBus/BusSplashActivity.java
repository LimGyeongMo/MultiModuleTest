package com.project.demoBus;


import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.project.demobus.R;

import com.project.demobus.databinding.BusActivitySplashBinding;
import com.project.featurebus.BusMainActivity;
import com.project.core.BaseActivity;

public class BusSplashActivity extends BaseActivity {

    public BusActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.bus_activity_splash);

        initLayout();
    }

    private void initLayout() {
        binding.loGoBus.setOnClickListener(view -> startActivity(new Intent(this, BusMainActivity.class)));
    }
}