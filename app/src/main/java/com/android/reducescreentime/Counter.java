package com.android.reducescreentime;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class Counter extends AppCompatActivity {

    private int second = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            second = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("runnning");
            wasRunning = savedInstanceState.getBoolean("wasRunnning");

        }
        runTimer();
    }

    public void runTimer() {
        //Get the textview
        final TextView timeview = findViewById(R.id.time_view);
        //create Handler
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = second / 3600;
                int minutes = (second % 3600) / 60;
                int sec = second % 3600;

                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, sec);
                timeview.setText(time);
                if (running) {
                    second++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning=running;
        running=false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning){
            running=true;
        }
    }

    public void onClickStart(View view) {
        running=true;



    }

    public void onClickStop(View view) {
        running=false;
    }

    public void onClickStopReset(View view) {
        running=false;
        second=0;


    }
}