package com.project.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.UiSettings;
import com.project.ui.databinding.ActivityNaverMapBinding;

public class NaverMapActivity extends AppCompatActivity {
    private MapView mapView;
    private NaverMap naverMap;
    private UiSettings uiSettings;
    private ActivityNaverMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_naver_map);

        initLayout();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        mapView.onLowMemory();
    }


    private void initLayout() {
        binding.titleView.getIconLeft1().setOnClickListener(v -> finish());

        initMapLayout();
    }

    private void initMapLayout() {
        mapView = binding.mapView;
        mapView.getMapAsync(mNaverMap -> {
            naverMap = mNaverMap;
            naverMap.addOnCameraChangeListener((i, b) -> {

            });
            naverMap.setCameraPosition(new CameraPosition(new LatLng(35.871402, 128.601754), 18)); //
            naverMap.addOnCameraIdleListener(() -> {

            });

            uiSettings = naverMap.getUiSettings();
            uiSettings.setCompassEnabled(false);
            uiSettings.setScaleBarEnabled(false);
            uiSettings.setZoomControlEnabled(false);
            uiSettings.setLocationButtonEnabled(false);
            uiSettings.setScrollGesturesEnabled(false);
        });
    }
}