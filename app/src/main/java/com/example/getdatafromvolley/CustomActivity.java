package com.example.getdatafromvolley;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity { // Set dynamic data in the Recycler View...
    RecyclerView rv_items;
    ArrayList<Model> arraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom);

        String RequestURL = "https://jsonplaceholder.typicode.com/users";

        StringRequest stringRequest = new StringRequest(RequestURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) { // get the data or response from the api...
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String id = object.getString("id");
                        String name = object.getString("name");
                        String username = object.getString("username");
                        String email = object.getString("email");
                        String phone = object.getString("phone");
                        String website = object.getString("website");

                        // set the data in the model constructor...
                        Model model = new Model(id, name, username, email, phone, website);
                        arraylist.add(model); // set model data in the arraylist...
                    }
                    // id...
                    rv_items = findViewById(R.id.rv_items);

                    UserAdapter adapter = new UserAdapter(CustomActivity.this, arraylist);
                    rv_items.setLayoutManager(new LinearLayoutManager(CustomActivity.this));
                    rv_items.setAdapter(adapter);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(CustomActivity.this, "ERROR" + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}