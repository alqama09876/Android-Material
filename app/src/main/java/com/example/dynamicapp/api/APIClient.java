package com.example.dynamicapp.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient { // Create a Retrofit Object...

    public static APIClient instance;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    // Start...

    // object banane k liye method banana hai...
    private APIClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        // then create an instance of retrofit client...
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
    }

    // then create an another method...
    public static synchronized APIClient getInstance() {
        if (instance == null) {
            instance = new APIClient();
        }
        return instance;
    }

    // yhn tk retrofit client ka instance create hochuka hai...
    // ---------------------------------------------------------------------------------------------

    // then create an another method to call the API...

    // hamara jo baseurl hai uske page me se data ko lene k liye hamee ek interface banana parega...
    public APIInterface getAPI() { // is method ki madad se ham apni API ko call karenge...
        return retrofit.create(APIInterface.class);
    }
}