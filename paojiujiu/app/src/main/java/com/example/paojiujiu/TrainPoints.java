package com.example.paojiujiu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.example.paojiujiu.camera2library.Camera2Config;
import com.example.paojiujiu.camera2library.camera.Camera2RecordActivity;

/*
import com.cktim.camera2library.Camera2Config;
import com.cktim.camera2library.camera.Camera2RecordActivity;
*/
public class TrainPoints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_points);
        Button start=findViewById(R.id.trainPStart);
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
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Camera2RecordActivity.start(TrainPoints.this);
            }
        });
    }
}
