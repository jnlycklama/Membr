package com.example.jnlycklama.membr;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_welcome);

        String the_url = "http://cisc-325.azurewebsites.net/send/" + SignUp.email_save;
        System.out.println(the_url);

        TextView newtext = (TextView) findViewById(R.id.email_fill);
        newtext.setText("We just sent an email to " + SignUp.email_save + " with your membership QR code!");

        //Asynchronous.doInBackground(the_url);
        Asynchronous mJSONParser = new Asynchronous() {
            @Override
            protected Long doInBackground(URL... params) {

                try {
                    String the_url = "http://cisc-325.azurewebsites.net/send/" + SignUp.email_save;
                    // Replace it with your own WCF service path
                    URL json = new URL(the_url);
                    URLConnection jc = json.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));

                    String line = reader.readLine();

                    JSONObject jsonResponse = new JSONObject(line);
                    String pls = jsonResponse.toString();
                    if (pls.equals("Sent.")) {
                        System.out.println("the gods are smiling on us");
                    }else {
                        System.out.println("die");
                    }


                    reader.close();

                } catch(Exception e){
                    System.out.println("??: "+e.toString());
                }
                return null;
            }
        };
        mJSONParser.execute();

/*        try {
            URL url = new URL(the_url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //urlConnection.setRequestProperty("Cookie", cookie);
            //Set to POST
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setReadTimeout(10000);
            Writer writer = new OutputStreamWriter(urlConnection.getOutputStream());
            writer.write("jnlycklama@gmail.com");
            writer.flush();
            writer.close();
            urlConnection.disconnect();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //Log.e(Tag, e.toString());
        }*/


        Button btn = (Button)findViewById(R.id.btnFinished);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, MemberActivity.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.btnAnother);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, SignUp.class));
            }
        });

    }



}


