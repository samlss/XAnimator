package com.iigo.library;

import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description The linear layout, need work with {@link XAnimatorScrollView}
 */
public final class XAnimatorLinearLayout extends LinearLayout{
    private static ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    public XAnimatorLinearLayout(Context context) {
        super(context);
    }

    public XAnimatorLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XAnimatorLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public XAnimatorLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onScrollChanged(int l, int t, int oldl, int oldt){
        boolean isVertical = getOrientation() == VERTICAL;

        for (int i = 0;i < getChildCount();i++) {
            View child = getChildAt(i);

            XAnimatorAttr xAnimatorAttr = (XAnimatorAttr) child.getTag(R.id.XAnimator);
            if (xAnimatorAttr == null){
                continue;
            }

            int referDistance = isVertical ? child.getTop() : child.getLeft();
            int referParentSize = isVertical ? ((ViewGroup)getParent()).getHeight()
                    : ((ViewGroup)getParent()).getWidth();
            int referChildSize  = isVertical ? child.getHeight() : child.getWidth();
            int absolute = referDistance - (isVertical ? t : l);
            int visibleSize = referParentSize - absolute;

            float ratio = limitValue(visibleSize / (float) referChildSize, 0, 1);

            if (absolute <= referParentSize) {
                performAnimator(child, xAnimatorAttr, ratio);
            } else {
                drawHideState(child, xAnimatorAttr);
            }
        }
    }

    /**
     * Now perform animator for the child view.
     *
     * @param child The child view.
     * @param xAnimatorAttr The {@link XAnimatorAttr} of the child view.
     * @param ratio The ratio of the scroll(0 <= ration <= 1).
     * */
    private void performAnimator(View child, XAnimatorAttr xAnimatorAttr, float ratio){
        if (child == null
                || xAnimatorAttr == null){
            return;
        }
        if (xAnimatorAttr.isAlpha()){
            child.setAlpha(ratio);
        }

        if (xAnimatorAttr.isScaleX()){
            child.setScaleX(ratio);
        }

        if (xAnimatorAttr.isScaleY()){
            child.setScaleY(ratio);
        }

        if (xAnimatorAttr.getStartBgColor() != -1
                && xAnimatorAttr.getEndBgColor() != -1){
            child.setBackgroundColor((Integer) argbEvaluator.evaluate(ratio,
                    xAnimatorAttr.getStartBgColor(),
                    xAnimatorAttr.getEndBgColor()));
        }

        switch (xAnimatorAttr.getFromDirection()){
            case XAnimatorAttr.FROM_DIRECTION_BOTTOM:
                child.setTranslationY(child.getHeight() * (1 - ratio));
                break;

            case XAnimatorAttr.FROM_DIRECTION_TOP:
                child.setTranslationY(-child.getHeight() * (1 - ratio));
                break;

            case XAnimatorAttr.FROM_DIRECTION_LEFT:
                child.setTranslationX(-child.getWidth() * (1 - ratio));
                break;

            case XAnimatorAttr.FROM_DIRECTION_RIGHT:
                child.setTranslationX(child.getWidth() * (1 - ratio));
                break;

            default: break;
        }
    }

    /**
     * When the child view is not yet displayed on the screen, will draw its hide state.
     *
     * @param child The child view.
     * @param xAnimatorAttr  The attr of the child view.
     * */
    private void drawHideState(View child, XAnimatorAttr xAnimatorAttr){
        if (child == null
                || xAnimatorAttr == null){
            return;
        }

        if(xAnimatorAttr.isAlpha()){
            child.setAlpha(0);
        }
        if(xAnimatorAttr.isScaleX()){
            child.setScaleX(0);
        }
        if(xAnimatorAttr.isScaleY()){
            child.setScaleY(0);
        }

        switch (xAnimatorAttr.getFromDirection()){
            case XAnimatorAttr.FROM_DIRECTION_BOTTOM:
                child.setTranslationY(child.getHeight());
                break;

            case XAnimatorAttr.FROM_DIRECTION_TOP:
                child.setTranslationY(-child.getHeight());
                break;

            case XAnimatorAttr.FROM_DIRECTION_LEFT:
                child.setTranslationX(-child.getWidth());
                break;

            case XAnimatorAttr.FROM_DIRECTION_RIGHT:
                child.setTranslationX(child.getWidth());
                break;

                default: break;
        }
    }

    /**
     * Limit the value between min and max.
     *
     * @param value The limit value.
     * @param min The min value.
     * @param max The max value.
     * */
    private float limitValue(float value, float min ,float max) {
        return Math.max(Math.min(value,max), min);
    }
}

