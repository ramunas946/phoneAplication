package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;


public class Login extends AppCompatActivity {
    private static final String INSERT_URL ="https://ramunas946database.000webhostapp.com/index.php";
    CheckBox Soup, Main, Salad;
    RadioGroup radioSex;
    EditText Price;
    Spinner spinner;
    Button Create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final CheckBox SoupCB = findViewById(R.id.Soup);
        final CheckBox MainCB = findViewById(R.id.Main);
        final CheckBox SaladCB = findViewById(R.id.Salad);
        final RadioGroup radioSex = findViewById(R.id.radioSex);
        final EditText Price = findViewById(R.id.Price);
        final Spinner spinner = findViewById(R.id.spinner);
        final Button Create = findViewById(R.id.Create);


        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dinnerTypes = " ";
                if (SoupCB.isChecked()) {
                    dinnerTypes = dinnerTypes + SoupCB.getText().toString() + " ";
                }
                if (MainCB.isChecked()) {
                    dinnerTypes = dinnerTypes + MainCB.getText().toString() + " ";
                }
                if (SaladCB.isChecked()) {
                    dinnerTypes = dinnerTypes + SaladCB.getText().toString() + " ";
                }
                int selectedDeliveryType = radioSex.getCheckedRadioButtonId();
                RadioButton deliveryType = findViewById(selectedDeliveryType);
                String selectedDeliveryTypeBtnName = deliveryType.getText().toString();

                double price = Double.parseDouble(Price.getText().toString());
                String payment = String.valueOf(spinner.getSelectedItem());
                Dinner dinner = new Dinner(dinnerTypes, selectedDeliveryTypeBtnName, price, payment);
                    insertToDB(dinner);
            }

            private void insertToDB(Dinner dinner) {
                class NewEntry extends AsyncTask<String, Void,String> {

                    ProgressDialog loading;
                    DB db =new DB();

                    @Override
                    protected  void onPreExecute(){
                        super.onPreExecute();
                        loading = ProgressDialog.show(Login.this,
                                getResources().getString(R.string.new_entry_database_info),
                        null, true, true);
                    }

                    @Override
                    protected String doInBackground(String... strings){
                        HashMap<String, String> pietus =new HashMap<String, String>();
                        pietus.put("dinner_type", strings[0]);
                        pietus.put("delivery", strings[1]);
                        pietus.put("price", strings[2]);
                        pietus.put("payment", strings[3]);
                        pietus.put("action", "duotiPyzdi");
                        String result = db.sendPostRequest(INSERT_URL, pietus);
                        return result;
                    }
                    @Override
                    protected void onPostExecute(String s){
                        super.onPostExecute(s);
                        Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();
                        Intent eitiIpaieskosLanga = new Intent(Login.this,SearchActivity.class);
                        startActivity(eitiIpaieskosLanga);

                    }
                }
                NewEntry newEntry = new NewEntry();
                newEntry.execute(
                        dinner.getDinnerType(),
                        dinner.getDelivery(),
                        Double.toString(dinner.getPrice()),
                        dinner.getPayment()
                );
            }
        });
    }
}
