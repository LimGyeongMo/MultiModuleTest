package com.project.featuresearchactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;

import com.project.core.BaseActivity;
import com.project.core.util.CommonToastUtil;
import com.project.core.util.animationUtil;
import com.project.featuresearchactivity.databinding.CommonActivitySearchBinding;

public class CommonSearchActivity extends BaseActivity {
    private CommonActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.common_activity_search);

        initialize();
    }
    private void initialize() {
        animationUtil.startSequentialAnimationsWithDelays(this, com.project.ui.R.animator.fadeintop, binding.whether, binding.tourist, binding.dddd);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}