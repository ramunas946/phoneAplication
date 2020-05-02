package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

    CheckBox Soup, Main, Salad;
    RadioButton radioMale, radioFemale;
    EditText Price;
    Spinner spinner;
    Button Create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final CheckBox Soup = findViewById(R.id.Soup);
        final CheckBox Main = findViewById(R.id.Main);
        final CheckBox Salad = findViewById(R.id.Salad);

        final RadioButton radioMale = findViewById(R.id.radioMale);
        final RadioButton radioFemale = findViewById(R.id.radioFemale);

        final EditText Price = findViewById(R.id.Price);

        final Spinner spinner = findViewById(R.id.spinner);

        final Button Create = findViewById(R.id.Create);



        Create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String result = "Dinner Type:";
                if(Soup.isChecked()){
                    result += " Soup ";
                }
                if(Salad.isChecked()){
                    result += " Salad ";
                }
                if(Main.isChecked()){
                    result += " Main ";
                }
                String select = "\nDelivery type:";
                if(radioMale.isChecked()){
                    select += "Yes";
                }
                if(radioFemale.isChecked()){
                    select += "No";
                }
                String price = "\nPrice:";
                if (!Price.getText().toString().isEmpty()) {
                    int price1 = Integer.parseInt(Price.getText().toString());
                    price += price1;
                }
                String Card = "\nPayment: ";
                if(!spinner.isSelected()){
                    String card = spinner.getSelectedItem().toString();
                    Card += card;
                }
                Toast.makeText(getApplicationContext(), result + select + price + Card, Toast.LENGTH_SHORT).show();
                }
        });
    }
}
