package com.project.taxi;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.project.featuretaxi.view.taxiMainActivity;
import com.project.taxi.databinding.TaxiActivitySplashBinding;
import com.project.core.BaseActivity;

public class TaxiSplashActivity extends BaseActivity {

    public TaxiActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.taxi_activity_splash);

        initialize();
        initLayout();
    }

    private void initialize() {
        if (getIntent().hasExtra("deepLink")) {
            Intent sendIntent = new Intent(this, taxiMainActivity.class);
            sendIntent.putExtra("deepLink", getIntent().getStringExtra("deepLink"));
            startActivity(sendIntent);
        }
    }

    private void initLayout() {
        binding.loGoTaxi.setOnClickListener(view -> startActivity(new Intent(this, taxiMainActivity.class)));
        binding.loGoCall.setOnClickListener(view -> showToast("택시 호출"));
    }

}