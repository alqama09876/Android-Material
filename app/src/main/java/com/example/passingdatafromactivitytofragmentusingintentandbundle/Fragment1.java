package com.example.passingdatafromactivitytofragmentusingintentandbundle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {
    TextView txt_name, txt_phone;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        //ids...
        txt_name = view.findViewById(R.id.txt_name);
        txt_phone = view.findViewById(R.id.txt_phone);

        // get the data from bundle...
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");

            // set the data in the textview...
            txt_name.setText(name);
            txt_phone.setText(phone);
        }
        return view;
    }
}