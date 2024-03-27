package com.project.delivery;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.project.delivery.databinding.DeliveryActivitySplashBinding;
import com.project.featuredelivery.deliveryMainActivity;
import com.project.core.BaseActivity;

public class deliverySplashActivity extends BaseActivity {
    public DeliveryActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.delivery_activity_splash);

        initialize();
        initLayout();
    }

    private void initialize() {

    }

    private void initLayout() {
        binding.loGoDelivery.setOnClickListener(View -> startActivity(new Intent(this, deliveryMainActivity.class)));
        binding.loQuestion.setOnClickListener(View -> showToast("뭐하지?"));
    }
}