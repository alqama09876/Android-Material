package com.example.storedatausingfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    EditText edt_name, edt_email, edt_password, edt_confirm_password;
    TextView txt_login;
    AppCompatButton btn_signup;
    FirebaseAuth auth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        // id...
        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_confirm_password = findViewById(R.id.edt_confirm_password);
        txt_login = findViewById(R.id.txt_login);
        btn_signup = findViewById(R.id.btn_signup);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name.getText().toString();
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();
                String confirm_password = edt_confirm_password.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirm_password.isEmpty()) {
                    edt_name.setError("Required");
                    edt_email.setError("Required");
                    edt_password.setError("Required");
                    edt_confirm_password.setError("Required");
                } else if (!password.equals(confirm_password)) {
                    edt_confirm_password.setError("Password not match");
                } else {
                    registerUser(email, password);
                }
            }
        });
    }

    private void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("Signup: ", "User is Registered Successfully");
                    StoreData();
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("Error: ", "User is Not Registered", e);
                Toast.makeText(SignupActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void StoreData() {
        String name = edt_name.getText().toString();
        String email = edt_email.getText().toString();
        String password = edt_password.getText().toString();
        String confirm_password = edt_confirm_password.getText().toString();

        Map<String, Object> user = new HashMap();
        user.put("name", name);
        user.put("email", email);
        user.put("password", password);
        user.put("confirm_password", confirm_password);

        DocumentReference reference = db.collection("users").document();
        reference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(SignupActivity.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignupActivity.this, "Error while storing the data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}