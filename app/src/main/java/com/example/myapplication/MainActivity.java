package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView password_text_input,username_text_input;
    EditText username, password;
    Button Registerbtn, Loginbtn;
    CheckBox remembarbtn;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "username";
    public static final String pass = "password";
    public static final String remeb = "checked";
    private String Username;
    private String Password;
    private Boolean checked;

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textViewuser = findViewById(R.id.password_text_input);
        final TextView textViewpass = findViewById(R.id.username_text_input);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final CheckBox remembarbtn = findViewById(R.id.remembarbtn);



        final Button register = findViewById(R.id.Registerbtn);
        final Button submit = findViewById(R.id.Loginbtn);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String usernames = sharedpreferences.getString(Name, null);
        String passwords = sharedpreferences.getString(pass, null);
        Boolean checked = sharedpreferences.getBoolean(remeb, false);

        remembarbtn.setActivated(sharedpreferences.getBoolean("checked", false));
        if(checked = true) {
            username.setText(sharedpreferences.getString("username", null));
            password.setText(sharedpreferences.getString("password", null));
        }
        else{

        }




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean cancel = false;
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
                    startActivity(new Intent(MainActivity.this, Login.class));
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
        remembarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                if (remembarbtn.isChecked()){
                    remembarbtn.setChecked(true);
                    editor.putString(Name, username.getText().toString());
                    editor.putString(pass, password.getText().toString());
                    editor.putBoolean("checked", true);
                    editor.apply();
                }
                else{
                    remembarbtn.setChecked(false);
                    Toast.makeText(MainActivity.this, "ur login wont be saved",
                            Toast.LENGTH_SHORT).show();
                    editor.clear();
                    editor.apply();
                }
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
