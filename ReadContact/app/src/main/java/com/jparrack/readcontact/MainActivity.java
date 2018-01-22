package com.jparrack.readcontact;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckUserPermsions();
    }

    //access to permsions
    void CheckUserPermsions(){
        if ( Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) !=
                    PackageManager.PERMISSION_GRANTED  ){
                requestPermissions(new String[]{
                                Manifest.permission.READ_CONTACTS},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }
        }

        ReadContact();// init the contact list

    }
    //get acces to location permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //display news list
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ReadContact();// init the contact list
                } else {
                    // Permission Denied
                    Toast.makeText(this, "You denied access", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    ArrayList<ContactItems> listContact = new ArrayList<ContactItems>();
        void ReadContact () {
            String selection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "like '%j%";
            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);

            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                listContact.add(new ContactItems(name, phone));
            }
            MyCustomAdapter myadapter = new MyCustomAdapter(listContact);
            ListView lvContact = (ListView) findViewById(R.id.lvContact);
            lvContact.setAdapter(myadapter);//intisal with data
            // myadapter.notifyDataSetChanged();


        }

        private class MyCustomAdapter extends BaseAdapter {
            public  ArrayList<ContactItems>  listcontactDataAdpater ;

            public MyCustomAdapter(ArrayList<ContactItems>  listnewsDataAdpater) {
                this.listcontactDataAdpater =listnewsDataAdpater;
            }


            @Override
            public int getCount() {
                return listcontactDataAdpater.size();
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
                View myView = mInflater.inflate(R.layout.list_item, null);

                final   ContactItems s = listcontactDataAdpater.get(position);

                TextView tvName = ( TextView) myView.findViewById(R.id.tvnName);
                tvName.setText(s.name);
                TextView tvPhone = ( TextView) myView.findViewById(R.id.tvPhone);
                tvPhone.setText(s.phoneNumber);

                return myView;
            }

        }


}

