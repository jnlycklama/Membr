package com.example.jnlycklama.membr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.jnlycklama.membr.Constants.FIRST_COLUMN;
import static com.example.jnlycklama.membr.Constants.FOURTH_COLUMN;
import static com.example.jnlycklama.membr.Constants.SECOND_COLUMN;
import static com.example.jnlycklama.membr.Constants.THIRD_COLUMN;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberActivity extends AppCompatActivity {



    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_member);

        ListView listView=(ListView)findViewById(R.id.memb_list);

        list=new ArrayList<HashMap<String,String>>();

        HashMap<String,String> temp=new HashMap<String, String>();
        temp.put(FIRST_COLUMN, "Julie");
        temp.put(SECOND_COLUMN, "Lycklama");
        temp.put(THIRD_COLUMN, "20");
        temp.put(FOURTH_COLUMN, "Details");
        list.add(temp);

        HashMap<String,String> temp2=new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, "Chris");
        temp2.put(SECOND_COLUMN, "Thomas");
        temp2.put(THIRD_COLUMN, "21");
        temp2.put(FOURTH_COLUMN, "Details");
        list.add(temp2);

        HashMap<String,String> temp3=new HashMap<String, String>();
        temp3.put(FIRST_COLUMN, "Cody");
        temp3.put(SECOND_COLUMN, "Weeden");
        temp3.put(THIRD_COLUMN, "20");
        temp3.put(FOURTH_COLUMN, "Details");
        list.add(temp3);

        HashMap<String,String> temp4=new HashMap<String, String>();
        temp4.put(FIRST_COLUMN, "Will");
        temp4.put(SECOND_COLUMN, "Thompson");
        temp4.put(THIRD_COLUMN, "19");
        temp4.put(FOURTH_COLUMN, "Details");
        list.add(temp4);

        ListViewAdapter adapter=new ListViewAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                int pos = position + 1;
                Toast.makeText(MemberActivity.this, Integer.toString(pos) + " Clicked", Toast.LENGTH_SHORT).show();
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
