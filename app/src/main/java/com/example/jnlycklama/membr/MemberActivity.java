package com.example.jnlycklama.membr;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.jnlycklama.membr.Constants.FIRST_COLUMN;
import static com.example.jnlycklama.membr.Constants.FOURTH_COLUMN;
import static com.example.jnlycklama.membr.Constants.SECOND_COLUMN;
import static com.example.jnlycklama.membr.Constants.THIRD_COLUMN;
import static com.example.jnlycklama.membr.Constants.FIFTH_VAR;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberActivity extends AppCompatActivity {


    final public Context context = this;
    public static ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();

    public static void makeArray() {
        HashMap<String, String> temp = new HashMap<String, String>();
        temp.put(FIRST_COLUMN, "Julie");
        temp.put(SECOND_COLUMN, "Lycklama");
        temp.put(THIRD_COLUMN, "julielycklama@gmail.com");
        temp.put(FOURTH_COLUMN, "Details");
        temp.put(FIFTH_VAR, "Extremely experienced");
        list.add(temp);

        HashMap<String, String> temp2 = new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, "Chris");
        temp2.put(SECOND_COLUMN, "Thomas");
        temp2.put(THIRD_COLUMN, "cmt11@gmail.com");
        temp2.put(FOURTH_COLUMN, "Details");
        temp2.put(FIFTH_VAR, "None");
        list.add(temp2);

        HashMap<String, String> temp3 = new HashMap<String, String>();
        temp3.put(FIRST_COLUMN, "Cody");
        temp3.put(SECOND_COLUMN, "Weeden");
        temp3.put(THIRD_COLUMN, "codyweeden@hotmail.com");
        temp3.put(FOURTH_COLUMN, "Details");
        temp3.put(FIFTH_VAR, "A handful of lessons");
        list.add(temp3);

        HashMap<String, String> temp4 = new HashMap<String, String>();
        temp4.put(FIRST_COLUMN, "Will");
        temp4.put(SECOND_COLUMN, "Thompson");
        temp4.put(THIRD_COLUMN, "willthompson@yahoo.ca");
        temp4.put(FOURTH_COLUMN, "Details");
        temp4.put(FIFTH_VAR, "3 Years of Sailing");
        list.add(temp4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_member);

        ListView listView=(ListView)findViewById(R.id.memb_list);

        if (list.isEmpty()){
            makeArray();
        }


        ListViewAdapter adapter=new ListViewAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

                String name = list.get(position).get(FIRST_COLUMN) +" "+ list.get(position).get(SECOND_COLUMN);
                String email = list.get(position).get(THIRD_COLUMN);
                String experience = list.get(position).get(FIFTH_VAR);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                final EditText et = new EditText(context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(et);

                alertDialogBuilder.setTitle(name + "'s Information: ");
                alertDialogBuilder.setMessage("Email: "+email+"\nExperience: "+experience+"\n");
                // set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }

        });


        Button btn = (Button)findViewById(R.id.btnAdd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemberActivity.this, SignUp.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.btnHome);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemberActivity.this, MainActivity.class));
            }
        });


    }


}
