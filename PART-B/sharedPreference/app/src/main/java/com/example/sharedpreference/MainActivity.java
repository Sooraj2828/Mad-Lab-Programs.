package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3;
Button b1,b2,b3;
public static final String Myprefs = "Myprefs";
public  static final String Name = "name";
public  static final String Phno = "phno";
public  static final String Email = "email";

SharedPreferences sp;
SharedPreferences.Editor se;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1= findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        e3 = findViewById(R.id.editTextText3);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        sp = getSharedPreferences(Myprefs,MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String name = e1.getText().toString();
              String phno = e2.getText().toString();
              String email = e3.getText().toString();
              SharedPreferences.Editor editor= sp.edit();
              editor.putString(Name,name);
              editor.putString(Phno,phno);
              editor.putString(Email,email);
              editor.commit();
                Toast.makeText(MainActivity.this, "saved successfully", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String s;
             s = "name:"+sp.getString(Name,null)+"\nphno:"+sp.getString(Phno,null)+"\nemail:"+sp.getString(Email,null);
                Toast.makeText(MainActivity.this,s, Toast.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                se = sp.edit();
                se.clear();
                se.commit();
                e1.setText("");
                e2.setText("");
                e3.setText("");
            }
        });
    }
}