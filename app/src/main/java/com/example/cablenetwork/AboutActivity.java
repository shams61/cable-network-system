package com.example.cablenetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    TextView tvdashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
        tvdashboard = findViewById(R.id.tvdashboard);

        tvdashboard.setOnClickListener(view ->{
            startActivity(new Intent(AboutActivity.this, DashboardActivity.class));
        });
    }
}