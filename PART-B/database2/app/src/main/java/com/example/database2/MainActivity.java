package com.example.database2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
Button b1,b2;
SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextText1);
        e2 = findViewById(R.id.editTextText2);
        e3 = findViewById(R.id.editTextText3);
        e4 = findViewById(R.id.editTextText4);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        sq = openOrCreateDatabase("PERSONDB1",MODE_PRIVATE,null);
        sq.execSQL("CREATE TABLE IF NOT EXISTS PERSON(NAME TEXT,USN TEXT,PHNO TEXT)");

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
                long result = sq.insert("PERSON",null,values);
                if(result!=-1){
                    Toast.makeText(MainActivity.this, "succesfully inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usn = e4.getText().toString();
                Cursor c = sq.rawQuery("SELECT * FROM PERSON WHERE USN = ?",new String[]{usn});

                if(c.getCount()!=1){
                    Toast.makeText(MainActivity.this, "usn not matched", Toast.LENGTH_SHORT).show();
                }else{
                    c.moveToNext();
                    String phnocall = c.getString(2);
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phnocall));
                    startActivity(i);
                }
            }
        });


    }
}