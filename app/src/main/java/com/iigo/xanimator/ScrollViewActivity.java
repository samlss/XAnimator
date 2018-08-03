package com.iigo.xanimator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.iigo.library.XAnimator;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description The sample activity of {@link com.iigo.library.XAnimatorScrollView}
 */
public class ScrollViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(XAnimator.initLayout(this, R.layout.activity_scrollview));
    }
}
