package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{


    EditText username, password;
    Button Registerbtn, Loginbtn;
    CheckBox remembarbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final CheckBox remembarbtn = findViewById(R.id.remembarbtn);
        final Button register = findViewById(R.id.Registerbtn);
        final Button submit = findViewById(R.id.Loginbtn);


        final User user = new User(MainActivity.this);

        remembarbtn.setChecked(user.isRememberedForLogin());

        if (remembarbtn.isChecked()) {
            username.setText(user.getUsernameForLogin(), EditText.BufferType.EDITABLE);
            password.setText(user.getPasswordForLogin(), EditText.BufferType.EDITABLE);
        } else {
            username.setText("", EditText.BufferType.EDITABLE);
            password.setText("", EditText.BufferType.EDITABLE);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username2 = username.getText().toString();
                String password2 = password.getText().toString();
                username.setError(null);
                password.setError(null);
                if(Validation.isCredentialsValidUsename(username2) && Validation.isCredentialsValidPassword(password2)) {
                    user.setUsernameForLogin(username2);
                    user.setPasswordForLogin(password2);
                }
                if (remembarbtn.isChecked()) {
                    user.setRemembermeKeyForLogin(true);
                } else {
                    user.setRemembermeKeyForLogin(false);
                }

                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
}
