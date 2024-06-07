package com.example.sms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button b1;
EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       e1 = findViewById(R.id.editTextText);
       e2 = findViewById(R.id.editTextText2);
       b1 = findViewById(R.id.button);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String phno = e1.getText().toString();
               String sms = e2.getText().toString();
               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+phno));
               i.putExtra("sms_body",sms);
               startActivity(i);
           }
       });
    }
}