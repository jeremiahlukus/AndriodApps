package com.jparrack.searchbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar sb1;
    int MAXCOUNT = 100;
    TextView tvCounter;
    myHandler handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb1 = (SeekBar) findViewById(R.id.sb1);
        tvCounter = (TextView) findViewById(R.id.tvCounter);
        handle = new myHandler();
        sb1.setMax(MAXCOUNT);
    }

    boolean IsRunning = false;
    int CounterUp = 0;

    public void buStart(View view) {
        IsRunning = true;
        myThread t = new myThread();
        t.start();
    }

    public void buStop(View view) {
        IsRunning = false;
    }

    class myThread extends Thread{
        @Override
        public void run(){
            while(IsRunning){
                if(CounterUp <= MAXCOUNT){

                    //handler
                    Message msg = handle.obtainMessage();
                    Bundle b = new Bundle();
                    b.putInt("counter", CounterUp);
                    msg.setData(b);
                    handle.sendMessage(msg);

                //    runOnUiThread(new Runnable() {
                  //      @Override
                    //    public void run() {
                            //sb1.setProgress(CounterUp);
                            //tvCounter.setText("Counter = " + CounterUp);
                      //  }
                   // });
                    CounterUp++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class myHandler extends Handler {

        @Override
        public void handleMessage(Message msg){
            int count = msg.getData().getInt("counter");
            sb1.setProgress(CounterUp);
            tvCounter.setText("Counter" + CounterUp);
        }
    }

}
