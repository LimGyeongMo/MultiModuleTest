package com.project.featurebus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Trace;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.project.featurebus.databinding.BusActivityMainBinding;
import com.project.core.BaseActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BusMainActivity extends BaseActivity {

    public BusActivityMainBinding binding;
    private BusEditAdapter adapter;
    private String savedKeyword;
    private MyPreferencesManager myPreferencesManager;
    private ArrayList<BusChat> chatArrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.bus_activity_main);

        myPreferencesManager = MyPreferencesManager.getInstance(this);
        initLayout();
    }

    private void initLayout() {
        binding.titleView.getIconLeft1().setOnClickListener(view -> onBackPressed());
        initNavigationMenu();

    }

    private void initNavigationMenu() {
        binding.drawerLayout.closeDrawers();
        processChatting();
        DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                hideKeyboard(binding.nvForm.loForm);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        };
        binding.drawerLayout.setDrawerListener(listener);
    }

    private void processChatting() {
        adapter = new BusEditAdapter(this);
        LinearLayoutManager manager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.nvForm.rvChatting.setLayoutManager(manager);
        binding.nvForm.rvChatting.setAdapter(adapter);

        if (myPreferencesManager.getArrayList() != null && myPreferencesManager.getArrayList().size() > 0) {
            chatArrayList = myPreferencesManager.getArrayList();
            adapter.initItems(chatArrayList);
        }


        binding.nvForm.etKeyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                savedKeyword = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.nvForm.etKeyword.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // 엔터키가 눌렸을 때 동작 구현
                BusChat item = new BusChat();
                item.setDetail(binding.nvForm.etKeyword.getText().toString());
                chatArrayList.add(item);
                adapter.initItems(chatArrayList);
                myPreferencesManager.setArrayList(chatArrayList);
                binding.nvForm.etKeyword.setText("");
                binding.nvForm.etKeyword.clearFocus();
                return true;
            }
            return false;
        });

        binding.nvForm.etKeyword.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {

            } else {
               hideKeyboard(binding.nvForm.etKeyword);
            }
        });

        setKeyboardVisibilityListener(binding.getRoot(), new OnKeyboardVisibilityListener() {
            @Override
            public void onVisibilityChanged(boolean visible) {
                if (visible) {
                    if (chatArrayList != null && chatArrayList.size() > 1) {
                        binding.nvForm.rvChatting.scrollToPosition(chatArrayList.size() -1);
                    }
                } else {
                    binding.nvForm.etKeyword.clearFocus();
                }
            }
        });
    }
}