package com.example.a32intact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class appointment extends AppCompatActivity {
    private Button create;
    private EditText date;
    private EditText time;
    private EditText probs;
    private point ap =new point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        create = (Button)findViewById(R.id.create);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        probs = (EditText) findViewById(R.id.probs);
        date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ap.setDate(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ap.setTime(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        probs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ap.setProblem(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase.getInstance().getReference("User").child(uid).child("appointment").setValue(ap);
                Toast.makeText(appointment.this,"Appointment created",Toast.LENGTH_LONG);
                finish();
            }
        });

    }
}
