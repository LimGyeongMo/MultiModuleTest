package com.project.featuredelivery.Activity;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.util.Pair;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.project.core.BaseActivity;
import com.project.featuredelivery.R;
import com.project.featuredelivery.databinding.DeliveryActivityBottomSheetBinding;
import com.project.featuresearchactivity.CommonSearchActivity;

import java.util.ArrayList;

public class bottomSheetActivity extends BaseActivity {
    private DeliveryActivityBottomSheetBinding binding;
    private BottomSheetAdapter adapter;
    private BottomSheetBehavior behavior;
    private int savedState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.delivery_activity_bottom_sheet);

        initLayout();
//        initData();
    }

    @Override
    public void onBackPressed() {
        if (savedState != BottomSheetBehavior.STATE_COLLAPSED) {
            savedState = BottomSheetBehavior.STATE_COLLAPSED;
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

    private void initLayout() {
        // 처음 bottomSheet이 닫혀 있는 상태인지 저장
        savedState = BottomSheetBehavior.STATE_COLLAPSED;
        editSearchView();
        rvTestBottomView();
        bottomSheet();
    }

    private void editSearchView() {
        binding.rlEditBox.setOnClickListener( view -> {
            Intent intent = new Intent(this, CommonSearchActivity.class);
            Pair<View, String> pair_thumb = Pair.create(binding.rlEditBox, binding.rlEditBox.getTransitionName());
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair_thumb);
            startActivity(intent, optionsCompat.toBundle());
        });
    }

    private void bottomSheet() {
        behavior = BottomSheetBehavior.from(binding.bottomSheet);
        behavior.setDraggable(true);
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                savedState = newState;
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    Log.d("bottom : ", "STATE_EXPANDED"); //펼쳐진 상태
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    Log.d("bottom : ", "onStateChanged: STATE_COLLAPSED"); // 접혀있는 상태
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    Log.d("bottom : ", "onStateChanged: STATE_HIDDEN"); // 아래로 숨겨진 상태 (보이지 않음)
                } else if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    Log.d("bottom : ", "onStateChanged: STATE_DRAGGING"); // 드래깅되고 있는 상태
                } else if (newState == BottomSheetBehavior.STATE_SETTLING) {
                    Log.d("bottom : ", "onStateChanged: STATE_SETTLING"); // 드래그/스와이프 직후 고정된 상태
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }

        });
    }

    private void rvTestBottomView() {
        adapter = new BottomSheetAdapter(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(adapter);

        ArrayList<DTO> list = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            DTO item = new DTO();
            item.setTextNum(i);
            list.add(item);
        }
        adapter.initItems(list);
    }

    private void initData() {
        ArrayList<DTO> list = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            DTO item = new DTO();
            item.setTextNum(i);
        }
        adapter.initItems(list);
    }
}