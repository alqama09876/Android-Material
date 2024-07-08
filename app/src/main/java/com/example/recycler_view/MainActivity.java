package com.example.recycler_view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_item;
    ArrayList<Model> arrayList = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        rv_item = findViewById(R.id.rv_item);
        rv_item.setLayoutManager(new LinearLayoutManager(this));

        // Add sample data
        arrayList.add(new Model(R.drawable.food1, "Alqama", "alqamaqureshi156@gmail.com", "03104625946"));
        arrayList.add(new Model(R.drawable.food2, "Haris", "haris102@gmail.com", "03104625946"));
        arrayList.add(new Model(R.drawable.food3, "Ahmed", "ahmed543@gmail.com", "03133462447"));
        arrayList.add(new Model(R.drawable.food4, "Hasan", "hasan403@gmail.com", "03313755946"));
        arrayList.add(new Model(R.drawable.food5, "Fahad", "fahad110@gmail.com", "03134636946"));
        arrayList.add(new Model(R.drawable.food6, "Alyan", "alyan236@gmail.com", "03124335946"));
        arrayList.add(new Model(R.drawable.food7, "Sarim", "sarim334@gmail.com", "03145625946"));
        arrayList.add(new Model(R.drawable.food8, "Baqir", "baqir524@gmail.com", "03105625676"));
        arrayList.add(new Model(R.drawable.food9, "Touseef", "touseef033@gmail.com", "03484625966"));
        arrayList.add(new Model(R.drawable.food10, "Ahad", "ahad443@gmail.com", "03114625446"));
        arrayList.add(new Model(R.drawable.food1, "Haseeb", "haseeb224@gmail.com", "03304625946"));
        arrayList.add(new Model(R.drawable.food2, "Omesh", "omesh125@gmail.com", "03205625946"));
        arrayList.add(new Model(R.drawable.food3, "Vimel", "vimel533@gmail.com", "03184655946"));
        arrayList.add(new Model(R.drawable.food4, "Shahzaib", "shahzaib543@gmail.com", "03154625946"));
        arrayList.add(new Model(R.drawable.food5, "Bhawan", "bhawan976@gmail.com", "03164625546"));
        arrayList.add(new Model(R.drawable.food6, "Ronak", "ronak339@gmail.com", "03204625954"));
        arrayList.add(new Model(R.drawable.food7, "Ammad", "ammad022@gmail.com", "03154627546"));
        arrayList.add(new Model(R.drawable.food8, "Arsim", "arsim434@gmail.com", "03204625336"));
        arrayList.add(new Model(R.drawable.food9, "Zarrar", "zarrar654@gmail.com", "03134625976"));
        arrayList.add(new Model(R.drawable.food10, "Sami", "sami235@gmail.com", "03143435946"));

        // Initialize custom adapter and set it to RecyclerView
        adapter = new Adapter(this, arrayList);
        rv_item.setAdapter(adapter);
    }
}