package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // id...
        listView = findViewById(R.id.listView);

        String[] arrItem = {"Alqama", "Haris", "Ahmed", "Hasan", "Touseef", "Rohaan", "Sarim", "Baqir", "Arsim", "Alyan", "Ahad", "Shayan", "Fahad", "Saqlain", "Alqama", "Haris", "Ahmed", "Hasan", "Touseef", "Rohaan", "Sarim", "Baqir", "Arsim", "Alyan", "Ahad", "Shayan", "Fahad", "Saqlain"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrItem);
        listView.setAdapter(adapter);

        // click and check index...
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String arrItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Clicked " + arrItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}