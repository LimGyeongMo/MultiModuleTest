package com.project.featuredelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;


import com.project.featuredelivery.databinding.DeliveryActivityMainBinding;
import com.project.ui.BaseActivity;

public class deliveryMainActivity extends BaseActivity {

    public DeliveryActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.delivery_activity_main);

        initLayout();
        initData();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void initLayout() {
        binding.titleView.getIconLeft1().setOnClickListener(v -> onBackPressed());

        binding.rlSingle.setOnClickListener(v -> showToast("1인분을 선택 하셧습니다"));
        binding.rlChiken.setOnClickListener(v -> showToast("치킨을 선택 하셧습니다"));
        binding.rlKorea.setOnClickListener(v -> showToast("한식을 선택 하셧습니다"));
        binding.rlChina.setOnClickListener(v -> showToast("중식을 선택 하셧습니다"));
        binding.rlJapan.setOnClickListener(v -> showToast("일식을 선택 하셧습니다"));
        binding.rlSchool.setOnClickListener(v -> showToast("분식을 선택 하셧습니다"));
        binding.rlPigHocks.setOnClickListener(v -> showToast("족발보쌈을 선택 하셧습니다"));
        binding.rlPizza.setOnClickListener(v -> showToast("피자을 선택 하셧습니다"));
        binding.rlCafe.setOnClickListener(v -> showToast("카페을 선택 하셧습니다"));
        binding.rlAsia.setOnClickListener(v -> showToast("아시안을 선택 하셧습니다"));
    }

    private void initData() {

    }
}