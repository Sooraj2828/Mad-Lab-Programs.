package com.example.randcolorchange;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        ConstraintLayout c1 = findViewById(R.id.main);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int color = Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                c1.setBackgroundColor(color);
                Toast.makeText(MainActivity.this, "backgroung changed succesfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}