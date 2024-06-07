package com.example.lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1 =  findViewById(R.id.text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","on start invoked");
        Toast.makeText(this, "on start invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","on resume invoked");
        Toast.makeText(this, "on resume invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","on pause invoked");
        Toast.makeText(this, "on pause invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","on stop invoked");
        Toast.makeText(this, "on stop invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","on destroy invoked");
        Toast.makeText(this, "on destroy invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","on restart invoked");
        Toast.makeText(this, "on resstart invoked", Toast.LENGTH_SHORT).show();
    }
}