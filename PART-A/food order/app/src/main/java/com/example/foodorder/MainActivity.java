package com.example.foodorder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
CheckBox c1,c2,c3,c4;
Button b1;
TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        c1 =findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.textView3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total =0;
                StringBuilder sb = new StringBuilder();
                sb.append("Items ordered\n");
                if(c1.isChecked()){
                    sb.append("burger:100rs\n");
                    total = total + 100;
                }
                if(c2.isChecked()){
                    sb.append("pizza:150rs\n");
                    total = total + 150;
                }
                if(c3.isChecked()){
                    sb.append("sandwich:90rs\n");
                    total = total + 90;
                }
                if(c4.isChecked()){
                    sb.append("coke:50rs\n");
                    total = total + 50;
                }

                sb.append("total :"+total);
                t1.setText(sb.toString());
                Toast.makeText(MainActivity.this, "order placed succesfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}