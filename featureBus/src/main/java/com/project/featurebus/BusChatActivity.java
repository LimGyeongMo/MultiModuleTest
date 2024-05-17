package com.project.featurebus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;

import com.project.core.BaseActivity;
import com.project.featurebus.databinding.BusActivityChatBinding;

import java.util.ArrayList;

public class BusChatActivity extends BaseActivity {
    private BusActivityChatBinding binding;
    private BusEditAdapter adapter;
    private String savedKeyword;
    private MyPreferencesManager myPreferencesManager;
    private ArrayList<BusChat> chatArrayList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.bus_activity_chat);


        myPreferencesManager = MyPreferencesManager.getInstance(this);
        initNavigationMenu();
    }

    private void initNavigationMenu() {
        binding.titleView.getIconLeft1().setOnClickListener(v -> onBackPressed());
        processChatting();
    }

    private void processChatting() {
        adapter = new BusEditAdapter(this);
        LinearLayoutManager manager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvChatting.setLayoutManager(manager);
        binding.rvChatting.setAdapter(adapter);

        if (myPreferencesManager.getArrayList() != null && myPreferencesManager.getArrayList().size() > 0) {
            chatArrayList = myPreferencesManager.getArrayList();
            adapter.initItems(chatArrayList);
        }


        binding.etKeyword.addTextChangedListener(new TextWatcher() {
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
        binding.etKeyword.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // 엔터키가 눌렸을 때 동작 구현
                BusChat item = new BusChat();
                item.setDetail(binding.etKeyword.getText().toString());
                chatArrayList.add(item);
                adapter.initItems(chatArrayList);
                myPreferencesManager.setArrayList(chatArrayList);
                binding.etKeyword.setText("");
                binding.etKeyword.clearFocus();
                return true;
            }
            return false;
        });

        binding.etKeyword.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {

            } else {
                hideKeyboard(binding.etKeyword);
            }
        });

        setKeyboardVisibilityListener(binding.getRoot(), new BaseActivity.OnKeyboardVisibilityListener() {
            @Override
            public void onVisibilityChanged(boolean visible) {
                if (visible) {
                    if (chatArrayList != null && chatArrayList.size() > 1) {
                        binding.rvChatting.scrollToPosition(chatArrayList.size() -1);
                    }
                } else {
                    binding.etKeyword.clearFocus();
                }
            }
        });
    }
}