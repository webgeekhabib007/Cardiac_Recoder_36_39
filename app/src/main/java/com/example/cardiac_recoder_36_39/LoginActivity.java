package com.example.cardiac_recoder_36_39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * This class is used to login to the app
 */
public class LoginActivity extends AppCompatActivity {
    EditText etEmail,etPassword;
    Button btnLogin;
    TextView tvRegister;

    private FirebaseAuth mAuth;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.editTextEmail1);
        etPassword = findViewById(R.id.editTextPassword1);
        tvRegister = findViewById(R.id.textViewRegister);
        btnLogin = findViewById(R.id.buttonLogin);

        mAuth = FirebaseAuth.getInstance();
        tvRegister.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim(); // trim() removes spaces
                String password = etPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email is empty");
                }else{
                    if(!email.contains("@")){
                        etEmail.setError("Email is invalid");
                    }else{
                        if(TextUtils.isEmpty(password)){
                            etPassword.setError("Password is empty");
                        }else{
                            userLogin(email,password);
                        }
                    }
                }
            }
        });

    }

    /**
     * @param email
     * @param password
     */
    private void userLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // User login is successful
                        // You can redirect to the next activity or perform any desired action
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,ListActivity.class);
                        startActivity(intent);
                    } else {
                        // User login failed
                        // You can display an error message or handle the failure in any desired way
                        Toast.makeText(LoginActivity.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}