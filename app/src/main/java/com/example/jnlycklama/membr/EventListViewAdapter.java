package com.example.jnlycklama.membr;

import static com.example.jnlycklama.membr.Constants.E_FIRST_COLUMN;
import static com.example.jnlycklama.membr.Constants.E_SECOND_COLUMN;
import static com.example.jnlycklama.membr.Constants.E_THIRD_COLUMN;
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
public class EventListViewAdapter extends BaseAdapter{
    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView txtFirst;
    TextView txtSecond;
    TextView txtThird;
    public EventListViewAdapter(Activity activity,ArrayList<HashMap<String, String>> list){
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

            convertView=inflater.inflate(R.layout.event_columns, null);

            txtFirst=(TextView) convertView.findViewById(R.id.event_name);
            txtSecond=(TextView) convertView.findViewById(R.id.event_date);
            txtThird=(TextView) convertView.findViewById(R.id.details);

        }

        HashMap<String, String> map=list.get(position);
        txtFirst.setText(map.get(E_FIRST_COLUMN));
        txtSecond.setText(map.get(E_SECOND_COLUMN));
        txtThird.setText(map.get(E_THIRD_COLUMN));

        return convertView;
    }

}
