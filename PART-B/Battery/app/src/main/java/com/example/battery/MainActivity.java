package com.example.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
ProgressBar pr;
TextView t1;
BroadcastReceiver b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        pr = findViewById(R.id.progressBar2);
        t1 = findViewById(R.id.textView);
        ConstraintLayout c1 = findViewById(R.id.main);
        b = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                t1.setText(Integer.toString(level));
                pr.setProgress(level);
                if(level>=80){
                    c1.setBackgroundColor(Color.RED);
                }else if (level>=40){
                    c1.setBackgroundColor(Color.GREEN);
                }else{
                    c1.setBackgroundColor(Color.BLUE);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        registerReceiver(b,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(b);
        super.onStop();
    }
}