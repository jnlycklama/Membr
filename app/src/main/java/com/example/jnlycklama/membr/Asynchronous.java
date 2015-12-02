package com.example.jnlycklama.membr;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jnlycklama on 2015-12-02.
 */
public abstract class Asynchronous extends AsyncTask<URL, Integer, Long> {

    public static void doInBackground(String the_url){
        try {

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

    }
}
