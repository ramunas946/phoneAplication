package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button Registerbtn, Loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final EditText username = findViewById(R.id.username);
       final EditText password = findViewById(R.id.password);

        Button register = findViewById(R.id.Registerbtn);
        Button submit = findViewById(R.id.Loginbtn);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {
                boolean cancel = false;
                focusView = null;
                if (!username_crediantials(username.getText().toString())) {
                    username.setError(getString(R.string.login_faill_username));
                    cancel = true;
                }

                if (!password_crediantials(password.getText().toString())) {
                    password.setError(getString(R.string.login_faill_password));
                    cancel = true;
                }
                if (cancel) {

                } else {
                    Toast.makeText(MainActivity.this, username.getText().toString() + "\n" + password.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Login.class));
                }


            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {
                    startActivity(new Intent(MainActivity.this, Register.class));
                }
        });

    }

    private boolean username_crediantials(String crediantails) {
        final String CREDENTIALS_PATERN = "^([a-zA-Z0-9]{3,20})+$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATERN);
        Matcher matcher = pattern.matcher(crediantails);
        return matcher.matches();
    }

    private boolean password_crediantials(String crediantails) {
        final String CREDENTIALS_PATERN = "^([a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]{5,20})+$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATERN);
        Matcher matcher = pattern.matcher(crediantails);
        return matcher.matches();
    }
}
