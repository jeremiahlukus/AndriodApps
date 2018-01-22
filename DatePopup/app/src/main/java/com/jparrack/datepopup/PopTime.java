package com.jparrack.datepopup;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by jeremiahparrack on 1/14/18.
 */

public class PopTime extends DialogFragment implements View.OnClickListener{

    View view;
    TimePicker tp;
    Button buDone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.pop_time, container, false);
        tp = view.findViewById(R.id.timePicker);
        buDone = view.findViewById(R.id.button);
        buDone.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View v) {
        this.dismiss();
        String timeOn = tp.getHour() + " : " + tp.getMinute();
        MainActivity ma = (MainActivity) getActivity();
        ma.setTime(timeOn);
    }
}
