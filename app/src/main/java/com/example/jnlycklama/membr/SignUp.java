package com.example.jnlycklama.membr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jnlycklama.membr.MemberActivity;
import static com.example.jnlycklama.membr.Constants.FIRST_COLUMN;
import static com.example.jnlycklama.membr.Constants.FOURTH_COLUMN;
import static com.example.jnlycklama.membr.Constants.SECOND_COLUMN;
import static com.example.jnlycklama.membr.Constants.THIRD_COLUMN;
import static com.example.jnlycklama.membr.Constants.FIFTH_VAR;

import com.example.jnlycklama.membr.PaymentOption;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUp extends AppCompatActivity implements PaymentOption.OnFragmentInteractionListener, CreditPay.OnFragmentInteractionListener, Welcome.OnFragmentInteractionListener{


    public static String email_save;
    public boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign_up);

        Button btn = (Button)findViewById(R.id.btnNextSignUp);

        System.out.println("helloooo");

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

        final EditText email_text=(EditText)findViewById(R.id.email_input);
        email_text.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                System.out.println("The key pressed email is having code: " + keyCode);
                System.out.println("The key pressed email is having event: " + event);
                String email = email_text.getText().toString();
                System.out.println("wait what");
                email_save = email;
                addToList(THIRD_COLUMN, email);
                //showResults();
                return false;
            }
        });

        final EditText first_name_text=(EditText)findViewById(R.id.first_name_input);
        first_name_text.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                System.out.println("The key pressed first is having code: "+keyCode);
                System.out.println("The key pressed first is having event: "+event);
                String first = first_name_text.getText().toString();
                addToList(FIRST_COLUMN, first);
                //showResults();
                return false;
            }
        });

        final EditText last_name_text=(EditText)findViewById(R.id.last_name_input);
        last_name_text.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                System.out.println("The key pressed last is having code: "+keyCode);
                System.out.println("The key pressed last is having event: " + event);
                String last = last_name_text.getText().toString();
                addToList(SECOND_COLUMN, last);
                //showResults();
                return false;
            }
        });

        final EditText experience_text=(EditText)findViewById(R.id.experience_input);
        experience_text.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                System.out.println("The key pressed experience is having code: "+keyCode);
                System.out.println("The key pressed experience is having event: "+event);
                //showResults();
                System.out.println("boo pt2");
                String experience = experience_text.getText().toString();
                addToList(FOURTH_COLUMN, experience);
                return false;
            }
        });

    }

    HashMap<String,String> temp=new HashMap<String, String>();

    public void addToList(String constant, String item){
        System.out.println("boo");
        if (constant.equals(FOURTH_COLUMN) && !flag){
            temp.put(constant, "Details");
            temp.put(FIFTH_VAR, item);
            MemberActivity.list.add(temp);
            System.out.println("ummmmmm pt2");
            flag = true;
        } else{
            System.out.println("ummmmmm");
            temp.put(constant, item);
        }
    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

}
