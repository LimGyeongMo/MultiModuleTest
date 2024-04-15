package com.project.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.UiSettings;
import com.project.core.BaseActivity;
import com.project.ui.databinding.ActivityNaverMapBinding;

import java.util.ArrayList;

public class NaverMapActivity extends BaseActivity {
    private MapView mapView;
    private NaverMap naverMap;
    private UiSettings uiSettings;
    private ActivityNaverMapBinding binding;
    private testItemAdapter adapter;
    private boolean isMoveByGroupClick = false;
    private static final int TAB_HOSPITAL_INFO = 0;
    private static final int TAB_DIAGNOSIS_INFO = 5;
    private static final int TAB_REVIEW = 8;
    private int currentTabNo = TAB_HOSPITAL_INFO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_naver_map);

        initLayout();
        initData();
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
        initTabLayout();
        initRecycler();
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

    private void initTabLayout() {
        binding.loTab0.setOnClickListener(v -> {
            processTab(TAB_HOSPITAL_INFO);
        });
        binding.loTabInfo.setOnClickListener(v -> {
            processTab(TAB_DIAGNOSIS_INFO);
        });
        binding.loTabReview.setOnClickListener(v -> {
            processTab(TAB_REVIEW);
        });

        selectTabLayout(currentTabNo);
    }

    private void processTab(int num) {
        isMoveByGroupClick = true;
        binding.appBarLayout.setExpanded(false);
        selectTabLayout(num);
        moveTab(num);
    }

    private void selectTabLayout(int num) {
        switch (num) {
            case TAB_HOSPITAL_INFO:
                unSelectTab();
                tabSelecting(binding.tvTab0, binding.vTab0);
                break;
            case TAB_DIAGNOSIS_INFO:
                unSelectTab();
                tabSelecting(binding.tvTabInfo, binding.vTabInfo);
                break;
            case TAB_REVIEW:
                unSelectTab();
                tabSelecting(binding.tvTabReview, binding.vTabReview);
                break;
        }
    }

    private void unSelectTab() {
        tabUnSelecting(binding.tvTab0, binding.vTab0);
        tabUnSelecting(binding.tvTabInfo, binding.vTabInfo);
        tabUnSelecting(binding.tvTabReview, binding.vTabReview);
    }


    public void moveTab(int tabNo) {
        currentTabNo = tabNo;
        binding.rvMenu.smoothScrollToPosition(tabNo);
    }

    private void tabSelecting(TextView textView, View view) {
        textView.setTextColor(this.getColor(R.color.color_01CAFF));
        view.setVisibility(View.VISIBLE);
    }

    private void tabUnSelecting(TextView textView, View view) {
        textView.setTextColor(this.getColor(R.color.color_999999));
        view.setVisibility(View.INVISIBLE);
    }

    private void initRecycler() {
        adapter = new testItemAdapter(this);
        binding.rvMenu.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == 0) {
                    isMoveByGroupClick = false;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (!isMoveByGroupClick) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) binding.rvMenu.getLayoutManager();
                    int position = linearLayoutManager.findFirstVisibleItemPosition();

                    if (position >= TAB_REVIEW) {
                        selectTabLayout(TAB_REVIEW);
                    } else if(position >= TAB_DIAGNOSIS_INFO) {
                        selectTabLayout(TAB_DIAGNOSIS_INFO);
                    } else if(position >= TAB_HOSPITAL_INFO) {
                        selectTabLayout(TAB_HOSPITAL_INFO);
                    }
                }

            }
        });
        binding.rvMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvMenu.setAdapter(adapter);
    }

    private void initData() {
        ArrayList<testItem> list = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            testItem item = new testItem();
            item.setTextNum(i);
            list.add(item);
        }

        adapter.initItems(list);
    }
}