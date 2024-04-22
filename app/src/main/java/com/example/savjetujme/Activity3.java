package com.example.savjetujme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText et5, et6, et7, et8, et9, et10;
    TextView text5, text6, text7;
    Button next, back;

    // Ključevi za dijeljene postavke
    private static final String STATE_ET_5 = "state_et5";
    private static final String STATE_ET_6 = "state_et6";
    private static final String STATE_ET_7 = "state_et7";
    private static final String STATE_ET_8 = "state_et8";
    private static final String STATE_ET_9 = "state_et9";
    private static final String STATE_ET_10 = "state_et10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);
        et9 = findViewById(R.id.et9);
        et10 = findViewById(R.id.et10);

        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Provjera jesu li sva polja ispunjena
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity3.this, Activity2.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity3.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedSektor = getSelectedSektor();
                Intent intent;

                switch (selectedSektor) {
                    case "Elektrotehnika i Računalstvo":
                        intent = new Intent(Activity3.this, Activity4.class);
                        break;
                    case "Turizam i ugostiteljstvo":
                        intent = new Intent(Activity3.this, Activity5.class);
                        break;
                    case "Ekonomija i poslovna administracija":
                        intent = new Intent(Activity3.this, Activity6.class);
                        break;
                    case "Gimnazija":
                        intent = new Intent(Activity3.this, Activity7.class);
                        break;
                    case "Grafička tehnologija i audiovizualne komunikacije":
                        intent = new Intent(Activity3.this, Activity8.class);
                        break;
                    case "Poljoprivreda, prehrana i veterina":
                        intent = new Intent(Activity3.this, Activity9.class);
                        break;
                    case "Zdravstvo i socijalna skrb":
                        intent = new Intent(Activity3.this, Activity10.class);
                        break;
                    default:
                        intent = new Intent(Activity3.this, MainActivity.class);
                }

                Log.d("Activity3", "SelectedSektor: " + selectedSektor);
                Log.d("Activity3", "Intent class: " + intent.getComponent().getShortClassName());

                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        String value5 = et5.getText().toString().trim();
        String value6 = et6.getText().toString().trim();
        String value7 = et7.getText().toString().trim();
        String value8 = et8.getText().toString().trim();
        String value9 = et9.getText().toString().trim();
        String value10 = et10.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !value5.isEmpty() && !value6.isEmpty() && !value7.isEmpty() && !value8.isEmpty() && !value9.isEmpty() && !value10.isEmpty();
    }

    private String getSelectedSektor() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getString("selectedSektor", "");
    }

    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STATE_ET_5, et5.getText().toString());
        editor.putString(STATE_ET_6, et6.getText().toString());
        editor.putString(STATE_ET_7, et7.getText().toString());
        editor.putString(STATE_ET_8, et8.getText().toString());
        editor.putString(STATE_ET_9, et9.getText().toString());
        editor.putString(STATE_ET_10, et10.getText().toString());
        editor.apply();
    }
}



