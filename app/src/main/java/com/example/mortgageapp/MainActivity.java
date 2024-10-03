//Student: Syed Airaj Hussain (100789134)
//Assignment 1

package com.example.mortgageapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    //Declaring Variables
    public EditText mortgagePrice,tenureAmount,interest; //User Inputs
    public TextView result;
    Button calcButton; //Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Setting the inputs to the IDs
        mortgagePrice= findViewById(R.id.mortgagePrice);
        tenureAmount= findViewById(R.id.tenureAmount);
        interest= findViewById(R.id.interest);
        result= findViewById(R.id.result);
        calcButton = findViewById(R.id.calcButton);


        //Having event listener for the calculation button
       calcButton.setOnClickListener(new View.OnClickListener() {
         public void onClick (View i) {


             //Parsing the values
             double mortgage = Double.parseDouble(mortgagePrice.getText().toString());
             int ten = Integer.parseInt(tenureAmount.getText().toString());
             double rate = Double.parseDouble(interest.getText().toString())/100/12; //Calculate interest rate per month (year - month)

             //Get total num of monthly payments (tenure in yrs to months)
             int monthly = ten *12;

             //Equated monthly Instalment formula
             double emi_result= (mortgage*rate*Math.pow(1+rate, monthly)) / (Math.pow(1+rate,monthly) -1);



             //Creating a new Intent to go to new page
             Intent intent = new Intent(MainActivity.this, Page2.class);
             intent.putExtra("IRES",emi_result);
             startActivity(intent);


         }

       });









    }


}