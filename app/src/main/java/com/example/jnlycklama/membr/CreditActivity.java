package com.example.jnlycklama.membr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_credit_pay);

        Button btn = (Button)findViewById(R.id.btnNextCredit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreditActivity.this, WelcomeActivity.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.btnCancelCredit);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreditActivity.this, MemberActivity.class));
            }
        });

        Button btn3 = (Button)findViewById(R.id.btnBackCredit);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreditActivity.this, PaymentActivity.class));
            }
        });
    }

}
