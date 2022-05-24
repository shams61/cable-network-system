package com.example.cablenetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PaymentintroActivity extends AppCompatActivity {
    TextView tvpayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_paymentintro);

        tvpayment = findViewById(R.id.tvpayment);
        tvpayment.setOnClickListener(view ->{
            startActivity(new Intent(PaymentintroActivity.this, PaymentActivity.class));
        });
    }

}