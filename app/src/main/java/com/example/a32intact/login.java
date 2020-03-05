package com.example.a32intact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.google.firebase.database.core.ValueEventRegistration;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    private Button signout;
    private TextView name;
    private Button cp;
    private Button mp;
    private TextView ap;
    data user=new data();


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cp =(Button)findViewById(R.id.cpoint);
        mp = (Button) findViewById(R.id.mpoint);
        ap =(TextView) findViewById(R.id.detail);
        signout = (Button)findViewById(R.id.signout);
        name =(TextView)findViewById(R.id.name1);
        name.setVisibility(View.INVISIBLE);

        String uid= FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference("User").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(data.class);
                Log.d("puppy","user's name: "+ user.getName());
                name.setText(" WELCOME  "+ user.getName().toUpperCase());
                name.setVisibility(View.VISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase.getInstance().getReference("User").child(uid).child("appointment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        point pp = dataSnapshot.getValue(point.class);
                        ap.setText("Appointment schedule on : "+pp.getDate()+"  At Time: "+pp.getTime()+System.getProperty("line.separator")+"For :  "+pp.getProblem());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(login.this,appointment.class);
                startActivity(intent);

            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });


    }
}
