package com.jparrack.hellogoodbye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvUserName;
    Button btHello;
    Button btGoodbye;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUserName = findViewById(R.id.tvUserName);
        btHello = findViewById(R.id.btHello);
        btGoodbye = findViewById(R.id.btGoodbye);
        tvDisplay = findViewById(R.id.tvDisplay);

    }

    public void btHello(View view) {
        tvDisplay.setText("Hello, " + tvUserName.getText().toString());

    }

    public void btGoodbye(View view) {
        tvDisplay.setText("Goodbye,  " + tvUserName.getText().toString());

    }
}
