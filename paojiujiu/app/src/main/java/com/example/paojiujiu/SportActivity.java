package com.example.paojiujiu;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paojiujiu.camera2library.Camera2Config;
import com.example.paojiujiu.camera2library.camera.Camera2RecordActivity;

import java.util.List;

public class SportActivity extends AppCompatActivity {
    RadioButton sportTab;
    RadioButton practiseTab;
    RadioButton mineTab;
    TextView accumulateTextView;
    TextView accuracyTextView;
    TextView levelTextView;
    SeekBar accuracySeekBar;
    SeekBar levelSeekBar;
    LinearLayout accumulateLinearLayout;
    private long backTime;
    private long twoBackTime;
    Button runC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        initStatusBar();

        backTime = 0;
        twoBackTime = 0;

        sportTab = findViewById(R.id.sportActivitySportTab);
        practiseTab = findViewById(R.id.sportActivityPractiseTab);
        mineTab = findViewById(R.id.sportActivityMineTab);
        accumulateTextView = findViewById(R.id.sportActivityTextViewAccumulate);
        accuracyTextView = findViewById(R.id.sportActivityTextViewAccuracy);
        levelTextView = findViewById(R.id.sportActivityTextViewLevel);
        accuracySeekBar = findViewById(R.id.sportActivitySeekBarAccuracy);
        levelSeekBar = findViewById(R.id.sportActivitySeekBarLevel);
        accumulateLinearLayout = findViewById(R.id.sportActivityLinearLayoutAccumulate);

        runC=findViewById(R.id.runCorrect);
        runC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //配置Camera2相关参数，
                Camera2Config.RECORD_MAX_TIME = 10;//最长录制时间
                Camera2Config.RECORD_MIN_TIME=2;//最短录制时间
                Camera2Config.RECORD_PROGRESS_VIEW_COLOR=R.color.colorAccent;//录制进度条颜色
                Camera2Config.PREVIEW_MAX_HEIGHT=1000;////最大高度预览尺寸，默认大于1000的第一个
                Camera2Config.PATH_SAVE_VIDEO= Environment.getExternalStorageDirectory().getAbsolutePath() + "/CameraVideo/";;//视频保存地址，注意需要以/结束，例如Camera2/
                Camera2Config.PATH_SAVE_PIC=Environment.getExternalStorageDirectory().getAbsolutePath() + "/CameraPicture/";//图片保存地址，注意需要以/结束，例如Camera2/
                Camera2Config.ENABLE_CAPTURE=true;//是否开启拍照功能
                Camera2Config.ENABLE_RECORD=true;//是否开启录像功能
                //拍完照需要跳转的activity，这个activity自己编写，可以获取到保存的视频或者图片地址
                Camera2Config.ACTIVITY_AFTER_CAPTURE = Camera2RecordFinishActivity.class;
                Camera2RecordActivity.start(SportActivity.this);
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
                Intent intent = new Intent(SportActivity.this,PractiseActivity.class);
                startActivity(intent);
            }
        });

        mineTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });

        accumulateLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportActivity.this,SportHistoryActivity.class);
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
