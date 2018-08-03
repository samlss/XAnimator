package com.iigo.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description The scrollview,need work with {@link XAnimatorLinearLayout}
 */
public class XAnimatorHorizontalScrollView extends HorizontalScrollView {
    private XAnimatorLinearLayout contentView;

    public XAnimatorHorizontalScrollView(Context context) {
        super(context);
    }

    public XAnimatorHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XAnimatorHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public XAnimatorHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if (getChildCount() != 0 && getChildAt(0) instanceof XAnimatorLinearLayout){
            contentView = (XAnimatorLinearLayout) getChildAt(0);
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (contentView != null){
            contentView.onScrollChanged(l, t, oldl, oldt);
        }
    }
}
