package com.android.reducescreentime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText username,email,password;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=findViewById(R.id.user_name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        TextView SignIn=findViewById(R.id.signintv);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        Helper helper=new Helper(this);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname,uemail,upassword;
                uname=username.getText().toString();
                uemail=email.getText().toString();
                upassword=password.getText().toString();

                if (uname.equals("")||uemail.equals("")||upassword.equals("")){
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean i=helper.check_email(uemail);
                    if (i==false){
                        boolean insertfun=helper.insert_record(uname,uemail,upassword);
                        if (insertfun==true){
                            Toast.makeText(SignUpActivity.this, "Record saved successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(SignUpActivity.this, "Failed to save record", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(SignUpActivity.this, "please choose another email", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });




    }
}