package com.android.reducescreentime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {
    Button logout;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        logout=findViewById(R.id.logout);
        sp=getSharedPreferences("Data",MODE_PRIVATE);
        editor=sp.edit();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

    }

    private void logout() {
        editor.clear();
        editor.apply();
        Toast.makeText(this, "LogOut Sucessfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AboutUs.this,LoginActivity.class));
        finish();
    }

}
