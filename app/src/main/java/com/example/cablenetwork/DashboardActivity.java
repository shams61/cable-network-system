package com.example.cablenetwork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {
    TextView textpayment,textlogout,textcomplain,textcoverage,textabout,textcontact;
    ImageView payment,complain,about,contact,logout;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);

        //paymentActivity click
        textpayment = findViewById(R.id.textpayment);
        textpayment.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, PaymentintroActivity.class));
        });

        payment = findViewById(R.id.payment);
        payment.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, PaymentintroActivity.class));
        });

        //LogoutActivity click
        mAuth = FirebaseAuth.getInstance();
        textlogout = findViewById(R.id.textlogout);
        textlogout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
        });
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
        });

        //ComplainActivity click
        textcomplain = findViewById(R.id.textcomplain);
        textcomplain.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, ComplainActivity.class));
        });
        complain = findViewById(R.id.complain);
        complain.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, ComplainActivity.class));
        });

        //CoverageActivity click
        textcoverage = findViewById(R.id.textcoverage);
        textcoverage.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, MapsActivity.class));
        });

        //AboutActivity click
        textabout = findViewById(R.id.textabout);
        textabout.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, AboutActivity.class));
        });
        about = findViewById(R.id.about);
        about.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, AboutActivity.class));
        });

        //ContactUS activity
        textcontact = findViewById(R.id.textcontact);
        textcontact.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, ContactusActivity.class));
        });
        contact = findViewById(R.id.contact);
        contact.setOnClickListener(view ->{
            startActivity(new Intent(DashboardActivity.this, ContactusActivity.class));
        });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DashboardActivity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want to exit app ?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }
}