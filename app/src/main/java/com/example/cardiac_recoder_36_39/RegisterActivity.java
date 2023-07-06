package com.example.cardiac_recoder_36_39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * This class is used to register to the app
 */
public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText  etEmail, etPassword, etConfirmPassword;
    TextView tvLogin;

    private FirebaseAuth mAuth;


    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.buttonRegister);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        etConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        tvLogin = findViewById(R.id.textViewLogin);

        mAuth = FirebaseAuth.getInstance();


        tvLogin.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class); // RegisterActivity.this, LoginActivity.class
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim(); // trim() removes spaces
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Email is required");
                }else{
                    if(!email.contains("@")){
                        etEmail.setError("Email is invalid");
                    }else{
                        if (TextUtils.isEmpty(password)) {
                            etPassword.setError("Password is required");
                        }else {
                            if (TextUtils.isEmpty(confirmPassword)) {
                                etConfirmPassword.setError("Confirm Password is required");
                            } else {
                                if (!password.equals(confirmPassword)) {
                                    etConfirmPassword.setError("Password and Confirm Password must be the same");
                                } else {
                                    registerUser(email, password);
                                }
                            }
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
    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, task -> {
                    if (task.isSuccessful()) {
                        Log.d("RegisterActivity", "createUserWithEmail:success");
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}