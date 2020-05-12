package com.example.paojiujiu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.trainPoints);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TrainPoints.class);
                startActivity(intent);
            }
        });
        Button b2=findViewById(R.id.runDetail);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RunDetail.class);
                startActivity(intent);
            }
        });
        Button b3=findViewById(R.id.runPoints);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RunPoints.class);
                startActivity(intent);
            }
        });
        Button b4=findViewById(R.id.medal);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyMedal.class);
                startActivity(intent);
            }
        });
        Button b5=findViewById(R.id.changeInfo);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ChangeInfo.class);
                startActivity(intent);
            }
        });
    }
}
