package com.jparrack.datepopup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setTime(String time){
        Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG).show();
    }

    public void buShow(View view) {
        android.app.FragmentManager fm = getFragmentManager();
        PopTime popTime = new PopTime();
        popTime.show(fm, "Show frag");
    }
}
