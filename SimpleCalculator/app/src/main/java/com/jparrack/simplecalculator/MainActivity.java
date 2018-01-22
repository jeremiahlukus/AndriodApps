package com.jparrack.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;
    EditText etnum1;
    EditText etnum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = (TextView) findViewById(R.id.tvresult);
        etnum1 = (EditText) findViewById(R.id.etnum1);
        etnum2 = (EditText) findViewById(R.id.etnum2);
    }

    public void buClick(View view) {
        double n1 = Double.parseDouble(etnum1.getText().toString());
        double n2 = Double.parseDouble(etnum2.getText().toString());
        double r = n1 + n2;
        txtResult.setText("sum = " + r);


    }
}
