package com.example.jnlycklama.membr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MemberActivity extends AppCompatActivity {

    private String[] membersArray = { "Janet", "Kyle", "Olsen", "Hannah", "Penelope", "Edward"};

    private ListView memberListView;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_member);

        memberListView = (ListView) findViewById(R.id.memb_list);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, membersArray);
        memberListView.setAdapter(arrayAdapter);
    }

}
