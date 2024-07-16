package com.example.servicesinandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer; // is k through ham gana play karenge

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI); // is se ap user k mobile me se uski default ringtone get krsakte hn

        mediaPlayer.setLooping(true); // is se ap ki service background me run hoti rahegi rukegi nhi

        mediaPlayer.start(); // is se service start hogi

        return START_NOT_STICKY; // start sticky means agr ap apni service bankground me chalwana chahte hai to lagate hai
    }

    @Override
    public void onDestroy() {

        mediaPlayer.stop(); // is se service destroy hojaegi means ruk jaegi

        super.onDestroy();
    }
}


// create a service class
// entends class with service
// create onStart method for unbound services. (onStart is depricated (use onStartCommand() instead of onStart))
// jo bhi aap kaam karoge wo sab onStartCommand me hoga
// create onDestroy method to destroy the service
// then go to mainActivity