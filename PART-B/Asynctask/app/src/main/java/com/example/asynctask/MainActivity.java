package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button b1;
TextView t1;
ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.textView);
        pb = findViewById(R.id.progressBar2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T t1 = new T();
                t1.execute("10");
            }
        });

    }

    class T extends AsyncTask<String,Integer,String>{
        @Override
        protected String doInBackground(String... strings) {
            int max = Integer.parseInt(strings[0]);
            int i=0;
            while(i<max){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                i++;
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
            t1.setText(values[0].toString());
            super.onProgressUpdate(values);
        }
    }
}