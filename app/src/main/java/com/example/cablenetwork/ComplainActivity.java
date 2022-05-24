package com.example.cablenetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.lang.reflect.Member;

public class ComplainActivity extends AppCompatActivity {
    TextView tvLoginHere;
    EditText txtname, txtemail, txtphone, txtcomplain;
    Button btnsave;
    DatabaseReference reff;
    Complain complain;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_complain);
        tvLoginHere = findViewById(R.id.tvLoginHere);
        txtname = (EditText) findViewById(R.id.txtname);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtphone = (EditText) findViewById(R.id.txtphone);
        txtcomplain = (EditText) findViewById(R.id.txtcomplain);
        btnsave = (Button) findViewById(R.id.btnsave);
        complain = new Complain();
        tvLoginHere.setOnClickListener(view -> {
            startActivity(new Intent(ComplainActivity.this, DashboardActivity.class));
        });

        //--------------------------------------------
        complain = new Complain();
        //--------------------------------------------
        reff = FirebaseDatabase.getInstance().getReference().child("Complain");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                    maxid = (snapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtname.getText().toString().trim();
                String phone = txtphone.getText().toString().trim();
                String email = txtemail.getText().toString().trim();
                String complain2 = txtcomplain.getText().toString().trim();


                if (name.isEmpty()) {
                    txtname.setError("Name can not be empty");
                    txtname.requestFocus();
                } else if (email.isEmpty()) {
                    txtemail.setError("Email can not be empty");
                    txtemail.requestFocus();
                } else if (phone.isEmpty()) {
                    txtphone.setError("Phone can not be empty");
                    txtphone.requestFocus();
                } else if (phone.length() < 11) {
                    txtphone.setError("Phone number is not correct");
                    txtphone.requestFocus();

                } else if (complain2.isEmpty()) {
                    txtcomplain.setError("Complain can not be empty");
                    txtcomplain.requestFocus();
                } else {
                    complain.setName(txtname.getText().toString().trim());
                    complain.setEmail(txtemail.getText().toString().trim());
                    complain.setComplain(txtcomplain.getText().toString().trim());
                    complain.setPh(txtphone.getText().toString().trim());
                    reff.child(String.valueOf(maxid + 1)).setValue(complain);

                    Toast.makeText(ComplainActivity.this, "Complain Submit,Contact you within 24 Hours", Toast.LENGTH_LONG).show();

                    openNewActivity();
                }


            }
        });
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, DashboardActivity .class);
        startActivity(intent);
    }


}