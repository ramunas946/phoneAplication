package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button =findViewById(R.id.Registerbtn);
        Button button1 =findViewById(R.id.Loginbtn);
        Button button2 =findViewById(R.id.Mainbutton);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Registerbtn:
                startActivity(new Intent(Login.this, Register.class));
                break;
            case R.id.Loginbtn:

                break;
            case R.id.Mainbutton:
                startActivity(new Intent(Login.this, MainActivity.class));
                break;
        }
    }

}
