package com.project.core;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.core.network.resultInterface.app.MyPreferencesManager;
import com.project.core.util.CommonToastUtil;


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

    public interface OnKeyboardVisibilityListener {
        void onVisibilityChanged(boolean visible);
    }

    protected void setKeyboardVisibilityListener(View view, final OnKeyboardVisibilityListener onKeyboardVisibilityListener) {
//        final View parentView = ((ViewGroup)getActivity().findViewById(android.R.id.content)).getChildAt(0);
        final View parentView = view;
        parentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            private boolean alreadyOpen;
            private final int defaultKeyboardHeightDP = 100;
            private final int EstimatedKeyboardDP = defaultKeyboardHeightDP + (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 48 : 0);
            private final Rect rect = new Rect();

            @Override
            public void onGlobalLayout() {
                int estimatedKeyboardHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, EstimatedKeyboardDP, parentView.getResources().getDisplayMetrics());  // 키보드 추정 높이값

                parentView.getWindowVisibleDisplayFrame(rect);  // rect에는 키보드를 제외한 화면의 크기 정보가 담긴다.
                int heightDiff = parentView.getRootView().getHeight() - (rect.bottom - rect.top);
                // 키보드가 shown이면 heightDiff에는 (추정치보다 큰)키보드 높이가 저장되고, hidden일 경우엔 0에 가까운 값이 저장된다. (0보단 크고 estimatedKeyboardHeight보단 작은 값)
                boolean isShown = heightDiff >= estimatedKeyboardHeight;

                if (isShown == alreadyOpen) {
//                    Log.i("Keyboard state", "Ignoring global layout change...");
                    return;
                }
                // heightDiff가 키보드 추정치보다 크면 isShown = true가 저장된다.
                alreadyOpen = isShown;
                onKeyboardVisibilityListener.onVisibilityChanged(isShown);
            }
        });
    }

}