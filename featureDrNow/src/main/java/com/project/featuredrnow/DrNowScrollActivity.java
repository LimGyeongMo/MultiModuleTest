package com.project.featuredrnow;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.project.core.BaseActivity;
import com.project.featuredrnow.databinding.DrNowActivityScrollBinding;

public class DrNowScrollActivity extends BaseActivity {

    public DrNowActivityScrollBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.dr_now_activity_scroll);
    }
}