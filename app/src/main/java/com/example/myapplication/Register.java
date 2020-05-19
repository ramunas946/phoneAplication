package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity{
    private static final String INSERT_URL ="https://ramunas946database.000webhostapp.com/index.php";
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
            public void onClick(View view) {
                if (!username_crediantials(username.getText().toString())) {
                    username.setError(getString(R.string.login_faill_username));
                }
                if (!password_crediantials(password.getText().toString())) {
                    password.setError(getString(R.string.login_faill_password));
                }
                if (!email_crediantials(email.getText().toString())) {
                    email.setError(getString(R.string.login_faill_email));
                }
                String loginusername = (username.getText().toString());
                String loginpassword = (password.getText().toString());
                String loginemail = (email.getText().toString());
                RegisterLogin register = new RegisterLogin(loginusername, loginpassword, loginemail);
                Toast.makeText(Register.this,loginusername +"\n"+ loginpassword +"\n"+ loginemail,Toast.LENGTH_SHORT).show();
                insertToDB(register);
            }
                private void insertToDB(RegisterLogin register) {
                    class NewEntry extends AsyncTask<String, Void,String> {

                        ProgressDialog loading;
                        DB db =new DB();

                        @Override
                        protected  void onPreExecute(){
                            super.onPreExecute();
                            loading = ProgressDialog.show(Register.this,
                                    getResources().getString(R.string.new_entry_database_info),
                                    null, true, true);
                        }

                        @Override
                        protected String doInBackground(String... strings){
                            HashMap<String, String> pietus =new HashMap<String, String>();
                            pietus.put("username", strings[0]);
                            pietus.put("password", strings[1]);
                            pietus.put("email", strings[2]);
                            pietus.put("action", "Register");
                            String result = db.sendPostRequest(INSERT_URL, pietus);
                            return result;
                        }
                        @Override
                        protected void onPostExecute(String s){
                            super.onPostExecute(s);
                            Toast.makeText(Register.this,s,Toast.LENGTH_SHORT).show();
                            Intent eitiILoginlanga = new Intent(Register.this,MainActivity.class);
                            startActivity(eitiILoginlanga);

                        }
                    }
        NewEntry newEntry = new NewEntry();
        newEntry.execute(
                register.getUsername(),
                register.getPassword(),
                register.getEmail()
        );
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