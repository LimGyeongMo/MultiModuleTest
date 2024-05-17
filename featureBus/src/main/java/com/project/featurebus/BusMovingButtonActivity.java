package com.project.featurebus;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.project.core.BaseActivity;
import com.project.featurebus.databinding.BusActivityMovingButtonBinding;

public class BusMovingButtonActivity extends BaseActivity {
    private BusActivityMovingButtonBinding binding;
    private float initialX, initialY, firstY;
    private boolean firstCheck = false;
    private boolean isMove = false;
    private float initialTouchX, initialTouchY;
    private boolean isClose = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.bus_activity_moving_button);

        initLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isClose) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(binding.movingButton, View.SCALE_X, 1f);
            ObjectAnimator ScaleY = ObjectAnimator.ofFloat(binding.movingButton, View.SCALE_Y, 1f);
            animatorSet.playTogether(scaleX, ScaleY);
            animatorSet.setDuration(500);
            animatorSet.start();
            isClose = false;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initLayout() {

        binding.movingButton.setOnTouchListener((v, event) -> {
            isMove = false;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    initialX = v.getX();
                    initialY = v.getY();
                    if (!firstCheck) {
                        firstY = initialY;
                        firstCheck = true;
                    }

                    initialTouchX = event.getRawX();
                    initialTouchY = event.getRawY();
                    isMove = false;
                    Log.d("action", "MotionEvent.ACTION_DOWN");
                    return true;
                case MotionEvent.ACTION_MOVE:

                    float titleY = binding.titleView.binding.vBottomLine.getY();
                    if (titleY <= initialY + (event.getRawY() - initialTouchY) && initialY + (event.getRawY() - initialTouchY) <= firstY) {
//                    v.setX(initialX + (event.getRawX() - initialTouchX));
                        v.setY(initialY + (event.getRawY() - initialTouchY));
                        v.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
                        v.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                        Log.d("action", "MotionEvent.ACTION_MOVE");
                        isMove = true;
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!isMove && -5 < (int) (event.getRawY() - initialTouchY) && (int) (event.getRawY() - initialTouchY) < 5) {
                        animationStart(binding.movingButton).start();
                        Log.d("action", "MotionEvent.ACTION_UP  suc");
                    }
                    Log.d("action", "MotionEvent.ACTION_UP");
                    return true;
            }
            return false;
        });
    }

    private AnimatorSet animationStart(View v) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, View.SCALE_X, 200);
        ObjectAnimator ScaleY = ObjectAnimator.ofFloat(v, View.SCALE_Y, 200);
        animatorSet.playTogether(scaleX, ScaleY);
        animatorSet.setDuration(500);

        AnimatorSet animatorAll = new AnimatorSet();
        animatorAll.play(animatorSet);

        animatorAll.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                    isClose = true;
                    startActivity(new Intent(BusMovingButtonActivity.this, BusChatActivity.class));
                    overridePendingTransition(com.project.ui.R.anim.fade_in, com.project.ui.R.anim.fade_out);

            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
            }
        });
        return animatorAll; // 애니메이션 시작
    }
}