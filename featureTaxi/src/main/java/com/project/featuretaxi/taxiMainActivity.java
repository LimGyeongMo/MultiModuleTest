package com.project.featuretaxi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.RelativeLayout;

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
        binding.rlCard.setOnClickListener(v -> showToast("카드을 선택 하셧습니다"));
        binding.rlHitory.setOnClickListener(v -> showToast("이용내역을 선택 하셧습니다"));
        binding.rlMyInfo.setOnClickListener(v -> showToast("마이페이즈을 선택 하셧습니다"));
        binding.rlNotice.setOnClickListener(v -> showToast("알림을 선택 하셧습니다"));
        binding.rlMileage.setOnClickListener(v -> showToast("마일리지을 선택 하셧습니다"));
        binding.rlCoupon.setOnClickListener(v -> showToast("쿠폰을 선택 하셧습니다"));
        binding.rlSafemessage.setOnClickListener(v -> showToast("안심메시지을 선택 하셧습니다"));
    }
}