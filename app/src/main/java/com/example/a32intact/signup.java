package com.example.a32intact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class signup extends AppCompatActivity {
    private Button submit;
    private EditText name;
    private EditText phno;
    private EditText email;
    private EditText pwd;
    private EditText cpd;
    private data dp;


    String p;
    String cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final FirebaseAuth mAuth;
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference();
        mAuth =FirebaseAuth.getInstance();
        submit = (Button) findViewById(R.id.sup);
        name = (EditText)findViewById(R.id.n);
        phno = (EditText)findViewById(R.id.phno);
        email = (EditText)findViewById(R.id.email);
        pwd = (EditText) findViewById(R.id.pwd);
        cpd = (EditText) findViewById(R.id.cpd);
        dp =new data();
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dp.setName(s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        phno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dp.setPhno(s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dp.setEmail(s.toString().trim());
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
                p= s.toString().trim();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cpd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cp= s.toString().trim();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cp.equals(p)) {

                    mAuth.createUserWithEmailAndPassword(dp.getEmail(),p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                               String uid = mAuth.getCurrentUser().getUid();
                               FirebaseDatabase.getInstance().getReference("User").child(uid).setValue(dp);
                               finish();
                            }
                            else
                                Toast.makeText(signup.this,"Authentication failed please try again",Toast.LENGTH_LONG);
                        }
                    });

                }

            }
        });
    }

}
