package com.example.dynamicapp;

import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dynamicapp.api.APIClient;
import com.example.dynamicapp.model.UserModelItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    TextView txt_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // id...
        txt_data = findViewById(R.id.txt_data);

        Call<List<UserModelItem>> call = APIClient.getInstance().getAPI().getUserData();

        call.enqueue(new Callback<List<UserModelItem>>() {
            @Override
            public void onResponse(Call<List<UserModelItem>> call, Response<List<UserModelItem>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successfully Get Data", Toast.LENGTH_SHORT).show();
                    List<UserModelItem> userModelItems = response.body();
                    for (int i = 0; i < userModelItems.size(); i++) {
                        txt_data.append("" + userModelItems.get(i).getId() + "\n");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Failed to Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserModelItem>> call, Throwable t) {

            }
        });

    }
}