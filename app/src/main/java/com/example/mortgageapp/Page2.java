//Student: Syed Airaj Hussain (100789134)
//Assignment 1


package com.example.mortgageapp;

//importing libraries
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2 extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Defining Variable
        Button back2;


        setContentView(R.layout.page2);

        //Setting Back2 id
        back2 = findViewById(R.id.back2);


        //getting the intent information
        double emires= getIntent().getDoubleExtra("IRES",0.0);

        //displaying the result
        TextView emiText = findViewById(R.id.emiText);
        emiText.setText(String.format("Equated Monthly Instalment: %.2f", emires));

        //Setting event listener to go back to main activity
        back2.setOnClickListener(view-> {
          Intent intent = new Intent(getApplicationContext(),MainActivity.class);
          startActivity(intent);

        });





    }

}
