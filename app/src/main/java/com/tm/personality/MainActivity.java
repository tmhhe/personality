package com.tm.personality;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tm.customer.util.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setStatusBarTransparent(this, true);
    }
}
