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

public class Register extends AppCompatActivity{

    EditText username,password,email;
    Button registerbtn,loginbtn,mainbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final EditText email = findViewById(R.id.email);

        Button register = findViewById(R.id.registerbtn);
        Button login = findViewById(R.id.loginbtn);
        Button main = findViewById(R.id.mainbutton);


        register.setOnClickListener(new View.OnClickListener() {
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
                if (!email_crediantials(email.getText().toString())) {
                    email.setError(getString(R.string.login_faill_email));
                    cancel = true;
                }
                if (cancel) {

                } else {
                    Toast.makeText(Register.this, username.getText().toString() + "\n" + password.getText().toString() + "\n" + email.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register.this, MainActivity.class));
                }
            }
        });
        main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {
                startActivity(new Intent(Register.this, Login.class));
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
    private boolean email_crediantials(String crediantails) {
        final String CREDENTIALS_PATERN = "^([a-zA-Z0-9!@#$%^&*(),.?\":{}|<>_]{10,50})+$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATERN);
        Matcher matcher = pattern.matcher(crediantails);
        return matcher.matches();
    }

}