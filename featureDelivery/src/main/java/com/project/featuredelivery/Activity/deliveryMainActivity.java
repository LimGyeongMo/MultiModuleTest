package com.project.featuredelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;


import com.project.featuredelivery.R;
import com.project.featuredelivery.databinding.DeliveryActivityMainBinding;
import com.project.core.BaseActivity;
import com.project.featuredelivery.fragment.AdBottomFragment;
import com.project.featurescroll.DrNowScrollActivity;

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

        binding.rlSingle.setOnClickListener(v -> {
            AdBottomFragment bottomFragment = new AdBottomFragment(new AdBottomFragment.CallBackListener() {
                @Override
                public void cancel() {

                }

                @Override
                public void ok() {

                }
            });
            bottomFragment.show(getSupportFragmentManager(), null);
        });
        binding.rlChiken.setOnClickListener(v -> startActivity(new Intent(this, DrNowScrollActivity.class)));
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