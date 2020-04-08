package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


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

                break;
            case R.id.Loginbtn:
                startActivity(new Intent(Register.this, Login.class));
                break;
            case R.id.Mainbutton:
                startActivity(new Intent(Register.this, MainActivity.class));
                break;
        }
    }
}