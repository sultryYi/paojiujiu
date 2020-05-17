package com.example.paojiujiu;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SportHistoryActivity extends AppCompatActivity {
    ImageButton backBtn;
    RadioButton sportTab;
    RadioButton practiseTab;
    RadioButton mineTab;
    View runD;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_history);
        initStatusBar();

        backBtn = findViewById(R.id.sportHistoryActivityBackBtn);
        sportTab = findViewById(R.id.sportHistoryActivitySportTab);
        practiseTab = findViewById(R.id.sportHistoryActivityPractiseTab);
        mineTab = findViewById(R.id.sportHistoryActivityMineTab);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportHistoryActivity.this.onBackPressed();
            }
        });
        runD=findViewById(R.id.runDetail);
        runD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportHistoryActivity.this, RunDetail.class);
                startActivity(intent);
            }
        });
        sportTab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Drawable dark = getResources().getDrawable(R.drawable.ic_sport_mouseover);
                        //2.6
                        dark.setBounds(0,0,107,83);
                        ((RadioButton) v).setCompoundDrawables(null, dark, null, null);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        Drawable light = getResources().getDrawable(R.drawable.ic_sport);
                        //2.6
                        light.setBounds(0,0,107,83);
                        ((RadioButton) v).setCompoundDrawables(null, light, null, null);
                        break;
                }
                return false;
            }
        });

        practiseTab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Drawable dark = getResources().getDrawable(R.drawable.ic_practise_mouseover);
                        //2.6
                        dark.setBounds(0,0,101,85);
                        ((RadioButton) v).setCompoundDrawables(null, dark, null, null);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        Drawable light = getResources().getDrawable(R.drawable.ic_practise);
                        //2.6
                        light.setBounds(0,0,101,85);
                        ((RadioButton) v).setCompoundDrawables(null, light, null, null);
                        break;
                }
                return false;
            }
        });

        mineTab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Drawable dark = getResources().getDrawable(R.drawable.ic_mine_mouseover);
                        //2.6
                        dark.setBounds(0,0,88,88);
                        ((RadioButton) v).setCompoundDrawables(null, dark, null, null);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        Drawable light = getResources().getDrawable(R.drawable.ic_mine);
                        //2.6
                        light.setBounds(0,0,88,88);
                        ((RadioButton) v).setCompoundDrawables(null, light, null, null);
                        break;
                }
                return false;
            }
        });

        practiseTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportHistoryActivity.this,PractiseActivity.class);
                startActivity(intent);
            }
        });

        mineTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportHistoryActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }
}
