package com.jeremiahparrack.funfacts;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView tvFactView;
    private Button btnFact;
    private FactBook fact = new FactBook();
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Assign view from the layout file to the corresponding vars

        tvFactView = (TextView) findViewById(R.id.tvFact);
        btnFact = (Button) findViewById(R.id.button);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFactView.setText(fact.getFact());
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                constraintLayout.setBackgroundColor(color);
            }
        };
        btnFact.setOnClickListener(listener);
        Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show();
        Log.d(getPackageName(), "This is a log message");

    }
}
