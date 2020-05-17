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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class PractiseActivity extends AppCompatActivity {
    private long twoBackTime;
    private long backTime;
    Button runP;
    View trainP;
    RadioButton sportTab;
    RadioButton practiseTab;
    RadioButton mineTab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);
        initStatusBar();

        twoBackTime = 0;
        backTime = 0;

        sportTab = findViewById(R.id.practiseActivitySportTab);
        practiseTab = findViewById(R.id.practiseActivityPractiseTab);
        mineTab = findViewById(R.id.practiseActivityMineTab);
        runP=findViewById(R.id.runPoint);
        runP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PractiseActivity.this, RunPoints.class);
                startActivity(intent);
            }
        });
        trainP=findViewById(R.id.trainPoint);
        trainP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PractiseActivity.this, TrainPoints.class);
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

        sportTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PractiseActivity.this,SportActivity.class);
                startActivity(intent);
            }
        });

        mineTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PractiseActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed(){
        if(twoBackTime == 0) {
            Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
            backTime = System.currentTimeMillis();
            twoBackTime = System.currentTimeMillis() + 5000;
        }else {
            twoBackTime = System.currentTimeMillis();
            if(twoBackTime - backTime <= 2000){
//                this.finish();
//                System.exit(0);
                exitAPP();
            }else {
                Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
                backTime = System.currentTimeMillis();
                twoBackTime = System.currentTimeMillis() + 5000;
            }
        }
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void exitAPP() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        for (ActivityManager.AppTask appTask : appTaskList) {
            appTask.finishAndRemoveTask();
        }
    }
}
