package com.example.jnlycklama.membr;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static com.example.jnlycklama.membr.Constants.E_FIRST_COLUMN;
import static com.example.jnlycklama.membr.Constants.E_SECOND_COLUMN;
import static com.example.jnlycklama.membr.Constants.E_THIRD_COLUMN;
import java.util.ArrayList;
import java.util.HashMap;

public class EventsActivity extends AppCompatActivity {


    final public Context context = this;
    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ListView listView=(ListView)findViewById(R.id.event_list);

        list=new ArrayList<HashMap<String,String>>();

        HashMap<String,String> temp=new HashMap<String, String>();
        temp.put(E_FIRST_COLUMN, "Sailing Practice");
        temp.put(E_SECOND_COLUMN, "May 10, 2016");
        temp.put(E_THIRD_COLUMN, "Details");
        list.add(temp);

        HashMap<String,String> temp2=new HashMap<String, String>();
        temp2.put(E_FIRST_COLUMN, "Team BBQ");
        temp2.put(E_SECOND_COLUMN, "June 18, 2016");
        temp2.put(E_THIRD_COLUMN, "Details");
        list.add(temp2);

        HashMap<String,String> temp3=new HashMap<String, String>();
        temp3.put(E_FIRST_COLUMN, "Semi-Finals Race");
        temp3.put(E_SECOND_COLUMN, "July 2, 2016");
        temp3.put(E_THIRD_COLUMN, "Details");
        list.add(temp3);

        HashMap<String,String> temp4=new HashMap<String, String>();
        temp4.put(E_FIRST_COLUMN, "Finals Race");
        temp4.put(E_SECOND_COLUMN, "July 10, 2016");
        temp4.put(E_THIRD_COLUMN, "Details");
        list.add(temp4);

        EventListViewAdapter adapter=new EventListViewAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                position = position + 1;

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                final EditText et = new EditText(context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(et);
                System.out.println(position);
                if (position == 1) {
                    alertDialogBuilder.setTitle("There are 2 members attending the Sailing Practice: Julie Lycklama, and Chris Thomas");
                } else if (position == 2) {
                    alertDialogBuilder.setTitle("There is 1 member attending the Team BBQ: William Thompson");
                } else if (position == 3) {
                    alertDialogBuilder.setTitle("There are 3 members attending the Semi-Finals Race: Julie Lycklama, Cody Weedon, and William Thompson");
                } else if (position == 4) {
                    alertDialogBuilder.setTitle("There are 4 members attending the Finals Race: Julie Lycklama, Chris Thomas, Cody Weeden, and Will Thompson");
                }

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

        Button btn2 = (Button) findViewById(R.id.btnHomeEvents);

        btn2.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(EventsActivity.this, MainActivity.class));
                                    }
            }

            );

        }


    }
