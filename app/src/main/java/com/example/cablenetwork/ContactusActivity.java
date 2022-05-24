package com.example.cablenetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ContactusActivity extends AppCompatActivity {
    TextView tvdashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contactus);

        tvdashboard = findViewById(R.id.tvdashboard);

        tvdashboard.setOnClickListener(view ->{
            startActivity(new Intent(ContactusActivity.this, DashboardActivity.class));
        });
    }
}