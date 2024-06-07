package com.example.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Myservice extends Service {
MediaPlayer music;
    @Override
    public void onCreate() {
        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
        music= MediaPlayer.create(this,R.raw.puspa);
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        music.start();
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        music.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
