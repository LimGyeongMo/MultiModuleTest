package com.project.featurescroll;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.core.BaseActivity;
import com.project.featurescroll.databinding.DrNowActivityScrollBinding;


import java.util.ArrayList;

public class DrNowScrollActivity extends BaseActivity {

    public DrNowActivityScrollBinding binding;
    private DrNowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.dr_now_activity_scroll);

        initLayout();
        initData();
    }

    private void initLayout() {
        binding.igCursorLeft.setImageTintList(ColorStateList.valueOf(getColor(com.project.ui.R.color.color_333333_30)));
        adapter = new DrNowAdapter(this);
        adapter.setOnItemClickListener((View, Position) -> {


        });
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(adapter);

        binding.rlMoveButton.setVisibility(isViewVisible(binding.nestedScrollView, binding.rlFixButton) ? View.GONE : View.VISIBLE);
        binding.nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            binding.rlMoveButton.setVisibility(isViewVisible(binding.nestedScrollView, binding.rlFixButton) ? View.GONE : View.VISIBLE);
        });
    }

    private void initData() {
        ArrayList<textItem> list = new ArrayList<>();

        for (int i = 0 ; 20 >= i ; i ++){
            textItem item = new textItem();
            item.setTextNum(i);
            list.add(item);
        }

        adapter.initItems(list);
    }

    public static boolean isViewVisible(NestedScrollView nestedScrollView, View view) {
        Rect scrollBounds = new Rect();
        nestedScrollView.getDrawingRect(scrollBounds);
        float top = view.getY();
        float bottom = view.getHeight() + top;
        return scrollBounds.bottom > bottom;
    }
}