package com.example.jnlycklama.membr;

import static com.example.jnlycklama.membr.Constants.FIRST_COLUMN;
import static com.example.jnlycklama.membr.Constants.FOURTH_COLUMN;
import static com.example.jnlycklama.membr.Constants.SECOND_COLUMN;
import static com.example.jnlycklama.membr.Constants.THIRD_COLUMN;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * Created by jnlycklama on 2015-11-15.
 */
public class ListViewAdapter extends BaseAdapter{
    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView txtFirst;
    TextView txtSecond;
    TextView txtThird;
    TextView txtFourth;
    public ListViewAdapter(Activity activity,ArrayList<HashMap<String, String>> list){
        super();
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub



        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){

            convertView=inflater.inflate(R.layout.columns, null);

            txtFirst=(TextView) convertView.findViewById(R.id.first_name);
            txtSecond=(TextView) convertView.findViewById(R.id.last_name);
            txtThird=(TextView) convertView.findViewById(R.id.email);
            txtFourth=(TextView) convertView.findViewById(R.id.details);

        }

        HashMap<String, String> map=list.get(position);
        txtFirst.setText(map.get(FIRST_COLUMN));
        txtSecond.setText(map.get(SECOND_COLUMN));
        txtThird.setText(map.get(THIRD_COLUMN));
        txtFourth.setText("Details");

        return convertView;
    }

}
