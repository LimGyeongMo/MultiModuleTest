package com.project.taxi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.project.featuretaxi.taxiMainActivity;
import com.project.taxi.databinding.TaxiActivitySplashBinding;
import com.project.core.BaseActivity;

public class taxiSplashActivity extends BaseActivity {

    public TaxiActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.taxi_activity_splash);

        initLayout();
    }

    private void initLayout() {
        binding.loGoTaxi.setOnClickListener(view ->  startActivity(new Intent(this, taxiMainActivity.class)));
        binding.loGoCall.setOnClickListener(view ->  showToast("택시 호출"));
    }

}