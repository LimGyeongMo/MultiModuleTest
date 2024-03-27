package com.project.featurebus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.project.featurebus.databinding.BusActivityMainBinding;
import com.project.core.BaseActivity;

public class BusMainActivity extends BaseActivity {

    public BusActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.bus_activity_main);

        initLayout();
    }

    private void initLayout() {
        binding.titleView.getIconLeft1().setOnClickListener(view -> onBackPressed());
    }
}