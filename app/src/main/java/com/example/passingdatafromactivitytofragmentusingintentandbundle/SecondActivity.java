package com.example.passingdatafromactivitytofragmentusingintentandbundle;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        // get the data from MainActivity...
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");

        // pass the data from secondActivity to fragment using bundle...
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("phone", phone);

        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
    }
}