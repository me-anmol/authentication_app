package com.example.a32intact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button signup;
    private EditText usename;
    private EditText pwd;
    private String usname;
    private String pass;
    private FirebaseAuth mAuth;



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser u = FirebaseAuth.getInstance().getCurrentUser();
        if(u!=null)
        {
            Intent intent = new Intent(MainActivity.this,login.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        setup();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "fdmf", Toast.LENGTH_LONG);
            }
        });
        usename.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                usname = s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pass = s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass != null && usename != null )
                {
                    mAuth.signInWithEmailAndPassword(usname,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(MainActivity.this,login.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(MainActivity.this,"Wrong Id or Password",Toast.LENGTH_LONG);
                        }
                    });
                }

            }
        });
    }


       private void setup()
        {
            login = (Button) findViewById(R.id.signin);
            signup = (Button) findViewById(R.id.signup);
            usename = (EditText) findViewById(R.id.usname);
            pwd = (EditText) findViewById(R.id.pwd);

        }
    }

