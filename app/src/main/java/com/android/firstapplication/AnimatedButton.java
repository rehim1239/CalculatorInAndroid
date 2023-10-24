package com.android.firstapplication;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;

import com.google.android.material.button.MaterialButton;

public class AnimatedButton extends MaterialButton {
    public AnimatedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setBackgroundColor(int color) {
        ObjectAnimator.ofObject(this, "backgroundColor", new ArgbEvaluator(), getBackgroundColor(), color)
                .setDuration(10000)
                .start();
    }

    public int getBackgroundColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return getBackgroundTintList().getDefaultColor();
        } else {
            return ((ColorDrawable) getBackground()).getColor();
        }
    }
}
