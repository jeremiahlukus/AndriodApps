package com.jparrack.storedata;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBManager dbManager;
    EditText etUserName;
    EditText etPassword;
    int recordID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sharedRef = new SharedRef(this)
        dbManager = new DBManager(this);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

    }
    //SharedRef sharedRef;
    public void buSave(View view) {
       ContentValues values = new ContentValues();
        values.put(DBManager.ColUserName, etUserName.getText().toString());
        values.put(DBManager.ColPassWord, etPassword.getText().toString());

        long id = dbManager.Insert(values);
        if(id > 0 ){
            Toast.makeText(getApplicationContext(), "Data is added user id:" + id, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Cannot insert", Toast.LENGTH_LONG).show();
        }
      //  sharedRef.SaveData(etUserName.getText().toString(), etPassword.getText().toString());
    }
    ArrayList<AdapterItems>    listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;
    public void buLoad(View view) {
        //String Data = sharedRef.LoadData();
        //Toast.makeText(getApplicationContext(), Data, Toast.LENGTH_LONG).show();
        LoadElement();

    }

    void LoadElement(){

        String [] SelectionArgs = { "%"+ etUserName.getText().toString()+ "%",
                "%"+ etPassword.getText().toString() + "%"};

        //add data and view it
        listnewsData.clear();
        Cursor cursor = dbManager.query(null, "UserName like ? and Password like ? ", SelectionArgs, DBManager.ColUserName);

        if (cursor.moveToFirst()){
            String tableData = "";
            do{
                //tableData += cursor.getString(cursor.getColumnIndex(DBManager.ColUserName)) + "," +
                // cursor.getString(cursor.getColumnIndex(DBManager.ColPassWord)) + "::";
                listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID))
                        ,cursor.getString(cursor.getColumnIndex(DBManager.ColUserName))
                        ,cursor.getString(cursor.getColumnIndex(DBManager.ColPassWord))));

            }while(cursor.moveToNext());
            //Toast.makeText(getApplicationContext(), tableData, Toast.LENGTH_LONG).show();

        }
        myadapter=new MyCustomAdapter(listnewsData);

        ListView lsNews=(ListView)findViewById(R.id.LVNews);
        lsNews.setAdapter(myadapter);//intisal with data
    }

    public void buUpdate(View view) {
        ContentValues values = new ContentValues();
        values.put(DBManager.ColUserName, etUserName.getText().toString());
        values.put(DBManager.ColPassWord, etPassword.getText().toString());
        values.put(DBManager.ColID, recordID);

        String [] SelectionArgs = {String.valueOf(recordID)};
        dbManager.Update(values, "ID=?", SelectionArgs);
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
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView tvID =( TextView)myView.findViewById(R.id.tvID);
            tvID.setText(String.valueOf(s.ID));

            TextView tvUserName =( TextView)myView.findViewById(R.id.tvUserName);
            tvUserName.setText(s.UserName);

            TextView tvPassWord =( TextView)myView.findViewById(R.id.tvPassWord);
            tvPassWord.setText(s.PassWord);


            Button buDelete = (Button) myView.findViewById(R.id.delete);
            buDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String [] SelectionArgs = {String.valueOf(s.ID)};
                    int count = dbManager.Delete("ID=?", SelectionArgs);
                    if (count > 0 ){
                        LoadElement();

                    }
                }
            });

            Button buUpdate = (Button) myView.findViewById(R.id.update);
            buUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etUserName.setText(s.UserName);
                    etPassword.setText(s.PassWord);
                    recordID = s.ID;
                }
            });
            return myView;
        }

    }
}
