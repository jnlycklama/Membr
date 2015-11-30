package com.example.jnlycklama.membr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.jnlycklama.membr.PaymentOption;

public class SignUp extends AppCompatActivity implements PaymentOption.OnFragmentInteractionListener, CreditPay.OnFragmentInteractionListener, Welcome.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign_up);

        Button btn = (Button)findViewById(R.id.btnNextSignUp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, PaymentActivity.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.btnCancelSignUp);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, MemberActivity.class));
            }
        });

    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

}
