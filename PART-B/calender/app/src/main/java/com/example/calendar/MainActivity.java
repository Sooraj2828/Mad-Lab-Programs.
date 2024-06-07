package com.example.calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
DatePicker d;
ArrayAdapter ad;
Spinner sp;
String date,br;
String s[]={"cse","ece","ise","me"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        d = findViewById(R.id.datepick);
        sp = findViewById(R.id.spinner);
        ad = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,s);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        date = d.getDayOfMonth()+"-"+(d.getMonth()+1)+"-"+d.getYear();
        br = ad.getItem(i).toString();
        String t = "date :"+date+"branch :"+br;
        Toast.makeText(this,t, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}