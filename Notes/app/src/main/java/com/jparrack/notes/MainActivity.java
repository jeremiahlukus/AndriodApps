package com.jparrack.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cbStatus;
    RadioButton rbMale;
    RadioButton rbFemale;
    Switch switchGraduated;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbStatus = (CheckBox) findViewById(R.id.checkBoxStatus);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        switchGraduated = (Switch) findViewById(R.id.switchGraduated);
        tvResult = (TextView) findViewById(R.id.result);

    }

    public void buCheck(View view) {
        String result = "";
        if(cbStatus.isChecked()) {
            result = " They are  married";
        } else {
            result = " They are not married";
        }
        if (rbMale.isChecked()){
            result += " also he is male";
        }else {
            result += " also she is a female";
        }
        if (switchGraduated.isChecked()){
            result += " this student is a grad";
        }else {
            result += " this student is not a grad";
        }
        tvResult.setText(result);



    }
}
