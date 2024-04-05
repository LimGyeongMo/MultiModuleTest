package com.project.core.util;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

public class animationUtil {

    public static void startSequentialAnimationsWithDelays(Context context, int anim, View... views) {
        if (views == null || views.length == 0) return;

        AnimatorSet animatorSet = new AnimatorSet();

        for (int i = 0; i < views.length; i++) {
            Animator animator = AnimatorInflater.loadAnimator(context, anim);
            animator.setTarget(views[i]);
            animator.setStartDelay(125L * i);

            animatorSet.playTogether(animator); // 동시에 애니메이션을 실행합니다.
        }

        animatorSet.start();
    }
}