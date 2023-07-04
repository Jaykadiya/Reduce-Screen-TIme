package com.android.reducescreentime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    Button setAlarm,Widget,tips,NotificationReminder,G_report,Darkmode,about,AboutApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setAlarm = findViewById(R.id.set_alarm);
        Widget = findViewById(R.id.widget);
        G_report = findViewById(R.id.G_Report);
        NotificationReminder = findViewById(R.id.notification_reminder);
        tips = findViewById(R.id.tips);
        Darkmode=findViewById(R.id.darkmode);
        about = findViewById(R.id.about);
        AboutApp = findViewById(R.id.about_app);


        Widget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this,"Please long tap on home screen and take our app widget on your home screen!!!",Toast.LENGTH_LONG).show();
                Toast.makeText(MenuActivity.this,"Using widget you can use stopwatch or focus mode!!!",Toast.LENGTH_LONG).show();
            }
        });
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Tips.class);
                startActivity(intent);
            }
        });
        NotificationReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),NotificationReminder.class);
                startActivity(intent);
            }
        });
        G_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),GenerateReport.class);
                startActivity(intent);
            }
        });
        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SetAlarm.class);
                startActivity(intent);

            }
        });
        Darkmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DarkMode.class);
                startActivity(intent);

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AboutUs.class);
                startActivity(intent);
            }
        });
        AboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AboutAppActivity.class);
                startActivity(intent);
            }
        });
    }
}