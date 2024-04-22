package com.example.savjetujme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    Button emailButton, smsButton, endButton;

    boolean hasSentData = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        if (intent.hasExtra("rezultat")) {
            float result = getIntent().getFloatExtra("rezultat", 0.0f);
            Log.d("ResultActivity", "Primljeni rezultat: " + result);

            // Postavljanje slušača za gumb za slanje SMS-a
            smsButton = findViewById(R.id.sms);
            smsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ResultActivity", "smsButton clicked");
                    String advice = generateAdvice(result);
                    Toast.makeText(ResultActivity.this, advice, Toast.LENGTH_LONG).show();
                    sendSMS(result, advice);
                }
            });

            // Postavljanje slušača za gumb za slanje e-pošte
            emailButton = findViewById(R.id.email);
            emailButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ResultActivity", "emailButton clicked");
                    String advice = generateAdvice(result);
                    Toast.makeText(ResultActivity.this, advice, Toast.LENGTH_LONG).show();
                    sendEmail(result, advice);
                }
            });
        }

        endButton = findViewById(R.id.endButton);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasSentData) {
                    Intent intent = new Intent(ResultActivity.this, ActivityEnd.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ResultActivity.this, "Morate poslati podatke prije prelaska na sljedeću aktivnost.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendEmail(float result, String advice) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        String[] to = {"robert.paukovic@gmail.com"};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ostvareni bodovi");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Imaš ostvarenih " + result + " bodova - " + advice);

        Intent chooserIntent = Intent.createChooser(emailIntent, "Izaberite klijenta za slanje e-pošte");

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooserIntent);
        } else {
            Toast.makeText(this, "Nema podržane aplikacije za slanje e-pošte.", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendSMS(float result, String advice) {
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.putExtra("sms_body", "Imam " + result + " bodova - " + advice);

        Intent chooserIntent = Intent.createChooser(smsIntent, "Izaberite klijenta za slanje SMS-a");

        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooserIntent);
        } else {
            Toast.makeText(this, "Nema podržane aplikacije za slanje SMS-a.", Toast.LENGTH_SHORT).show();
        }
    }

    private String generateAdvice(float result) {
        if (result > 25.0 || result == 25.0 || result <= 25.0 ) {
            return "Potrebno je poboljšati engleski jezik i matematiku jer će biti potrebno za tvoju struku. Bio bi negdje na 16. mjestu.";
        }
        else if (result >= 25.0) {
            return "Potrebno je da barem 2 dodatna perdmeta položiš sa 5 kako bi ušao bar u top 10. Bio bi negdje na 12. mjestu.";
        }

        else {
            return "Dobro još razmisli koje zanimanje bi bilo idealno za tebe!";
        }
    }
}










