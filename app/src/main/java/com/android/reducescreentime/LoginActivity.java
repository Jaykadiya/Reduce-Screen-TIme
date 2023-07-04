package com.android.reducescreentime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button Login;
    SharedPreferences sp;
    CheckBox checkbox;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        email=findViewById(R.id.email_login);
        password=findViewById(R.id.password_login);
        Login=findViewById(R.id.signin_btn);
        TextView signup=findViewById(R.id.signuptv);
        checkbox=findViewById(R.id.checkbox);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
        Helper helper=new Helper(this);
        sp=getSharedPreferences("Data",MODE_PRIVATE);
        editor=sp.edit();
        boolean login=sp.getBoolean("ISLOGGEDIN",false);
        if (login==true){
            startActivity(new Intent( LoginActivity.this,WelcomeActivity.class));
            finish();
        }
    Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uemail,upassword;
                uemail=email.getText().toString();
                upassword=password.getText().toString();
                if (uemail.equals("")||upassword.equals("")){
                    Toast.makeText(LoginActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    boolean validate=helper.checkemailandpassword(uemail,upassword);
                    if (validate==true){
                        if (checkbox.isChecked()){
                            editor.putString("email",uemail);
                            editor.putString("password",upassword);
                            editor.putBoolean("ISLOGGEDIN",true);
                            editor.apply();
                            Toast.makeText(LoginActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(LoginActivity.this,WelcomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }else{
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}