package com.project.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.project.utill.CommonToastUtil;


public class BaseActivity extends AppCompatActivity {
    protected String projectType;

    public boolean isBackpressedLock = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!isBackpressedLock) {
            super.onBackPressed();
        }
    }

    private void initialize() {
    }

    protected void showToast(String message) {
        CommonToastUtil.showToast(this, getLayoutInflater(), message);
    }

    protected void requestFocus(View view) {
        view.clearFocus();
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    protected void showKeyboard(View view) {
        requestFocus(view);

        view.post(() -> new Handler().postDelayed(() -> {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }, 50));
    }

    protected void hideKeyboard(View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

//    protected void appRestart() {
//        Intent intent = new Intent(BaseActivity.this, CommonSplashActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//    }

    protected void showAuthExpiredDialog() {
//        new CommonNoticeDialog(BaseActivity.this)
//                .setCancelPossible(false)
//                .setShowNegativeButton(false)
//                .setMessage(getString(R.string.auth_expired_message))
//                .setCallbackListener(new CommonNoticeDialog.CallbackListener() {
//                    @Override
//                    public void positive() {
//                        appRestart();
//                    }
//
//                    @Override
//                    public void negative() {
//
//                    }
//                }).show();
    }

//    protected void showLoadingDark(CommonLoadingBinding binding) {
//        binding.loViewDark.setVisibility(View.VISIBLE);
//        isBackpressedLock = true;
//    }
//
//    protected void showLoading(CommonLoadingBinding binding) {
//        binding.loView.setVisibility(View.VISIBLE);
//        isBackpressedLock = true;
//    }
//
//    protected void hideLoadingAll(CommonLoadingBinding binding) {
//        binding.loView.setVisibility(View.GONE);
//        binding.loViewDark.setVisibility(View.GONE);
//        isBackpressedLock = false;
//    }


    /**
     * 커스텀 로딩뷰
     */
//    protected void showLoading(CommonLoading commonLoading) {
//        commonLoading.showLoading();
//        isBackpressedLock = true;
//    }
//
//    protected void showLoadingDark(CommonLoading commonLoading) {
//        commonLoading.showLoadingDark();
//        isBackpressedLock = true;
//    }
//
//    protected void showLoadingWhite(CommonLoading commonLoading) {
//        commonLoading.showLoadingWhite();
//        isBackpressedLock = true;
//    }
//
//    protected void hideLoadingAll(CommonLoading commonLoading) {
//        commonLoading.hideLoadingAll();
//        isBackpressedLock = false;
//    }
    public void tabUnSelect(TextView textView, View view, int textColorId) {
        textView.setTypeface(ResourcesCompat.getFont(this, R.font.font_pretendard_medium));
        textView.setTextColor(getColor(textColorId));
        view.setVisibility(View.INVISIBLE);
    }

    public void tabUnSelect(TextView textView, View view) {
        tabUnSelect(textView, view, R.color.color_999999);
    }

    public void tabSelect(TextView textView, View view, int textColorId) {
        textView.setTypeface(ResourcesCompat.getFont(this, R.font.font_pretendard_bold));
        textView.setTextColor(getColor(textColorId));
        view.setVisibility(View.VISIBLE);
    }

    public void tabSelect(TextView textView, View view) {
        tabSelect(textView, view, R.color.color_01CAFF);
    }

    public String getProjectType() {
        return projectType;
    }

    public void changeFullScreen() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));

        int flags = getWindow().getDecorView().getSystemUiVisibility(); // get current flag
        flags = flags | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        getWindow().getDecorView().setSystemUiVisibility(flags);
    }

    public int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = 0;

        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }

        return statusBarHeight;
    }
}