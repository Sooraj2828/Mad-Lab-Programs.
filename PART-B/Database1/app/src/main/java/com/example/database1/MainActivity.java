package com.example.database1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
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
Button b1,b2;
SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        e3 = findViewById(R.id.editTextText3);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        sq = openOrCreateDatabase("PERSONDB",MODE_PRIVATE,null);
        sq.execSQL("CREATE TABLE IF NOT EXISTS Person1(NAME TEXT,USN TEXT,PHNO TEXT)");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = e1.getText().toString();
               String usn = e2.getText().toString();
               String phno = e3.getText().toString();
                ContentValues values = new ContentValues();
                values.put("NAME",name);
                values.put("USN",usn);
                values.put("PHNO",phno);
                long result = sq.insert("Person1",null,values);
                if(result!=-1){
                    Toast.makeText(MainActivity.this, "information saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "error in saving", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = sq.rawQuery("Select * from Person1",null);
                StringBuilder sb = new StringBuilder();
                if (c.moveToFirst()) {
                    do {
                        sb.append("\nname:" + c.getString(0) + "\nusn:" + c.getString(1) + "\nphno" + c.getString(2));
                    } while (c.moveToNext());
                }
                Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
            }

        });
    }


}