package com.example.pushnotificationusingcloudmessaging;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // image ko phele drawable me convert karenge then drawable se bitmap drawable me convert karenge then bitmap drawable se bitmap me convert karenge...
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.vector, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); // ye ek system call hai tabhi getSystemService kia hai takee easily notification ko get krsaken... ab yhn ek error araha hai ye error is liye araha hai q k right side pr object return kraha hai or left side pr notificationManager to isse object nhi milraha hai to hamee typecast krna pareega...
        Notification notification;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) { // ye tab khalega jab version 8 ya 8 se bara hoga means agr oreo se bara hoga tab chalega...
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.vector)
                    .setContentText("New Message")
                    .setSubText("New Message from Alqama Qureshi")
                    .setChannelId(CHANNEL_ID)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.vector)
                    .setContentText("New Message")
                    .setSubText("New Message from Alqama Qureshi")
                    .build();
        }

        nm.notify(NOTIFICATION_ID, notification); // ye notification id is liye di hai k q k for suppose agr 2 notification sath agaye
        // hai to 2sare wala 1st wale me merge hojaega or 1st wale ko update krdega...
    }
}