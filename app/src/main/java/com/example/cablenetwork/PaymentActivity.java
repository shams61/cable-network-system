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

public class PaymentActivity extends AppCompatActivity {
    String j = "jazzcash";
    String e = "easypaisa";
    TextView tvLoginHere;
    EditText txtname, txtemail, txtphone, txtamount, txtpaymentmethod, txttransactionid;
    Button btnsave;
    DatabaseReference reff;
    Payment payment;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_payment);
        txtname = (EditText) findViewById(R.id.txtname);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtphone = (EditText) findViewById(R.id.txtphone);
        txtamount = (EditText) findViewById(R.id.txtamount);
        txtpaymentmethod = (EditText) findViewById(R.id.txtpaymentmethod);
        txttransactionid = (EditText) findViewById(R.id.txttransactionid);
        btnsave = (Button) findViewById(R.id.btnsave);
        payment = new Payment();
        tvLoginHere = findViewById(R.id.tvLoginHere);

        tvLoginHere.setOnClickListener(view -> {
            startActivity(new Intent(PaymentActivity.this, DashboardActivity.class));
        });

        reff = FirebaseDatabase.getInstance().getReference().child("Payments");
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
                String paymethod = txtpaymentmethod.getText().toString().trim();
                String transid = txttransactionid.getText().toString().trim();
                String amount = txtamount.getText().toString().trim();

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

                } else if (paymethod.isEmpty()) {
                    txtpaymentmethod.setError("Payment method can not be empty");
                    txtpaymentmethod.requestFocus();
                } else if ( !(paymethod.equals(j) || paymethod.equals(e)) ) {
                    txtpaymentmethod.setError("INPUT JAZZCASH OR EASYPAISA ONLY");
                } else {


                    payment.setName(txtname.getText().toString().trim());
                    payment.setEmail(txtemail.getText().toString().trim());
                    payment.setPmethod(txtpaymentmethod.getText().toString().trim());
                    payment.setPh(txtphone.getText().toString().trim());
                    payment.setTranid(txttransactionid.getText().toString().trim());
                    payment.setAmount(txtamount.getText().toString().trim());
                    reff.child(String.valueOf(maxid + 1)).setValue(payment);


                    Toast.makeText(PaymentActivity.this, "Contact you within 24 Hours", Toast.LENGTH_LONG).show();
                    openNewActivity();

                }

            }
        });
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
}