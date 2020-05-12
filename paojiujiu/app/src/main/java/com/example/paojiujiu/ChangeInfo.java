package com.example.paojiujiu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class ChangeInfo extends AppCompatActivity {
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
        //判断父Activity是否为空
        if(NavUtils.getParentActivityName(ChangeInfo.this)!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示导航箭头
        }
        Calendar ca = Calendar.getInstance();
        int  myYear = ca.get(Calendar.YEAR);
        int  myMonth = ca.get(Calendar.MONTH);
        int  myDay = ca.get(Calendar.DAY_OF_MONTH);
        dpd=new DatePickerDialog(this,DatePickerDialog.THEME_DEVICE_DEFAULT_LIGHT,
                new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth){

                    }
                },myYear,myMonth,myDay);
        TextView Birthday=findViewById(R.id.chooseBirthday);
        Birthday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dpd.show();
            }
        });
    }
}
