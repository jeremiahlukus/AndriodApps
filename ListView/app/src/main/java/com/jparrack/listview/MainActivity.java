package com.jparrack.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AdapterItems> listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvList = (ListView) findViewById(R.id.lvList);
        listnewsData.add(new AdapterItems(R.drawable.hey,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(R.drawable.hey,"tester"," develop apps"));
        listnewsData.add(new AdapterItems(R.drawable.hey2,"admin"," develop apps"));
        myadapter = new MyCustomAdapter(listnewsData);

        lvList.setAdapter(myadapter);
        lvList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final AdapterItems s = listnewsData.get(position);
                TextView tvID = (TextView) view.findViewById(R.id.tvID);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //display news list
    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            ImageView tvID = (ImageView) myView.findViewById(R.id.tvID);
            tvID.setImageResource(s.ID);

            TextView tvTitle = (TextView)  myView.findViewById(R.id.tvTitle);
            tvTitle.setText(s.JobTitle);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), s.JobTitle, Toast.LENGTH_LONG).show();
                }
            });

            TextView tvDesc = (TextView) myView.findViewById(R.id.tvDesc);
            tvDesc.setText(s.Description);
            return myView;
        }

    }
}
