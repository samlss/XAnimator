package com.iigo.xanimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void start2ShowScrollView(View view) {
        startActivity(new Intent(this, ScrollViewActivity.class));
    }

    public void start2ShowHorizontalScrollView(View view) {
        startActivity(new Intent(this, HorizontalScrollViewActivity.class));
    }
}
