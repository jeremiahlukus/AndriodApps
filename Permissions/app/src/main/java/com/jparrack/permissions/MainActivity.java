package com.jparrack.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
    }

    public void buGet(View view) {

        CheckUserPermsions();
    }

    //access to permsions
    void CheckUserPermsions(){
        if ( Build.VERSION.SDK_INT >= 23){
            if ((ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED  ) &&
                    (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) !=
                            PackageManager.PERMISSION_GRANTED  )){
                requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }
        }

        getLocation();// init the contact list

    }
    //get acces to location permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();// init the contact list
                }
                else if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                }
                else {
                    // Permission Denied
                    Toast.makeText( this,"You denied Location" , Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    void getLocation() {
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        tvDisplay.setText("Longitude: " + String.valueOf(location.getLongitude()) +
                "Latitude: " + String.valueOf(location.getLatitude()));
    }
}
