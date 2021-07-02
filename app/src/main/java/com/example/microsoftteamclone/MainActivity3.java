package com.example.microsoftteamclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity3 extends AppCompatActivity {

    FirebaseAuth auth;
    EditText emailBox, passwordBox,nameBox;
    Button loginButton, signUpButton;
//    FirebaseFirestore database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        database = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        emailBox = findViewById(R.id.editTextEmailAddress);
        passwordBox = findViewById(R.id.editTextEmailAddress);
        nameBox = findViewById(R.id.UserNameBox);

        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.createButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,name,pass;
                email = emailBox.getText().toString();
                name = nameBox.getText().toString();
                pass = passwordBox.getText().toString();
//
//                User user = new User();
//                user.setEmail(email);
//                user.setPass(pass);
//                user.setEmail(name);

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(MainActivity3.this,MainActivity4.class));
                            Toast.makeText(MainActivity3.this,"Account is created",Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity3.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}