package com.project.featuretaxi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.project.featuredarggable.MainActivity;
import com.project.featurekotlin.view.KotlinMainActivity;
import com.project.featuretaxi.R;
import com.project.featuretaxi.databinding.TaxiActivityMainBinding;
import com.project.core.BaseActivity;

public class taxiMainActivity extends BaseActivity {

    public TaxiActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.taxi_activity_main);

        initLayout();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void initLayout() {
        binding.titleView.getIconLeft1().setOnClickListener(v -> onBackPressed());

        binding.rlCall.setOnClickListener(v -> showToast("호출을 선택 하셧습니다"));
        binding.rlCard.setOnClickListener(v -> startActivity(new Intent(this, TaxiMvvmActivity.class)));
        binding.rlHitory.setOnClickListener(v -> startActivity(new Intent(this, KotlinMainActivity.class)));
        binding.rlMyInfo.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        binding.rlNotice.setOnClickListener(v -> showToast("알림을 선택 하셧습니다"));
        binding.rlMileage.setOnClickListener(v -> showToast("마일리지을 선택 하셧습니다"));
        binding.rlCoupon.setOnClickListener(v -> showToast("쿠폰을 선택 하셧습니다"));
        binding.rlSafemessage.setOnClickListener(v -> showToast("안심메시지을 선택 하셧습니다"));
    }
}