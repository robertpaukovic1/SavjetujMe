package com.example.savjetujme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button;

    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button1);   //  Pronalaženje ključa ID- za gumb "Započni aktivnost"

        textView=findViewById(R.id.text1); // Pronalaženje ključa za  uvodni tekst

        button.setBackgroundColor(Color.parseColor("#00FF00"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //Postavljanje slušača  za gumb koji se krećemo na Activity1
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity1.class);
                startActivity(intent);
            }
        });

    }
}