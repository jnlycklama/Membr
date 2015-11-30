package com.example.jnlycklama.membr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import static com.example.jnlycklama.membr.Constants.E_FIRST_COLUMN;
import static com.example.jnlycklama.membr.Constants.E_SECOND_COLUMN;
import static com.example.jnlycklama.membr.Constants.E_THIRD_COLUMN;
import java.util.ArrayList;
import java.util.HashMap;

public class EventsActivity extends AppCompatActivity {



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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                int pos = position + 1;
                //do click stuff?
            }

        });

        Button btn2 = (Button)findViewById(R.id.btnHomeEvents);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, MainActivity.class));
            }
        });

    }


}
