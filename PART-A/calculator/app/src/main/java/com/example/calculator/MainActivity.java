package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button b2,b3,b4,b5,clear,res,add,sub,mul,div;
EditText e1,e2;
TextView t1;
int op1,op2,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        clear = findViewById(R.id.clear);
        res = findViewById(R.id.res);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        t1 = findViewById(R.id.textView);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    e2.setText("2");
                }else{
                    e1.setText("2");
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    e2.setText("3");
                }else{
                    e1.setText("3");
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    e2.setText("4");
                }else{
                    e1.setText("4");
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    e2.setText("5");
                }else{
                    e1.setText("5");
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    e1.setText("");
                    e2.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1 = Integer.parseInt(e1.getText().toString());
                op2 = Integer.parseInt(e2.getText().toString());
                total = op1 + op2;
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1 = Integer.parseInt(e1.getText().toString());
                op2 = Integer.parseInt(e2.getText().toString());
                total = op1 - op2;
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1 = Integer.parseInt(e1.getText().toString());
                op2 = Integer.parseInt(e2.getText().toString());
                total = op1 * op2;
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1 = Integer.parseInt(e1.getText().toString());
                op2 = Integer.parseInt(e2.getText().toString());
                total = op1 / op2;
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(Integer.toString(total));
            }
        });
    }
}