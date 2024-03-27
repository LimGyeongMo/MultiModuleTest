package com.project.daeguromultimodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.featurebus.BusMainActivity;
import com.project.featuredelivery.deliveryMainActivity;
import com.project.featuretaxi.taxiMainActivity;
import com.project.core.BaseActivity;

public class MainActivityCategory extends BaseActivity {

    private RelativeLayout deliveryBtn;
    private RelativeLayout taxiBtn;
    private RelativeLayout busBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);

        initialize();
        initLayout();
    }
    private void initialize(){
        deliveryBtn = findViewById(R.id.rl_delivery);
        taxiBtn = findViewById(R.id.rl_taxi);
        busBtn = findViewById(R.id.rl_bus);

    }

    private void initLayout() {
        deliveryBtn.setOnClickListener(v -> startActivity(new Intent(this, deliveryMainActivity.class)));
        taxiBtn.setOnClickListener(v -> startActivity(new Intent(this, taxiMainActivity.class)));
        busBtn.setOnClickListener(v -> startActivity(new Intent(this, BusMainActivity.class)));
    }
}