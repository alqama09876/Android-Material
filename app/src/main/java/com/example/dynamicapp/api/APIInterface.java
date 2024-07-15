package com.example.dynamicapp.api;

import com.example.dynamicapp.model.UserModel;
import com.example.dynamicapp.model.UserModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("users") // end point of the API ( ye hamne isliye banaya hai k jab API call hogi to ye base url k end me add hojaega or hamara data fetch hojaega )...

    Call<List<UserModelItem>> getUserData();
}
