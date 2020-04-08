package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =findViewById(R.id.Registerbtn);
        Button button1 =findViewById(R.id.Loginbtn);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Registerbtn:
                startActivity(new Intent(MainActivity.this, Register.class));
                break;
            case R.id.Loginbtn:
                startActivity(new Intent(MainActivity.this, Login.class));
                break;
        }
    }
}
