package com.example.savjetujme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    EditText input1, input2, input3, input4, input5, input6;  //  polja za unos ocjena
    TextView kemija, fizika, tk;  // tekstovi iznad polja
    Button next, back;  // gumbovi za  kretanje unutrag i unaprijed

    // Ključevi za dijeljene postavke
    private static final String STATE_INPUT_1 = "state_input_1";
    private static final String STATE_INPUT_2 = "state_input_2";
    private static final String STATE_INPUT_3 = "state_input_3";
    private static final String STATE_INPUT_4 = "state_input_4";
    private static final String STATE_INPUT_5 = "state_input_5";
    private static final String STATE_INPUT_6 = "state_input_6";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        //Pronalaženje ključeva za  polja unosa

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        input5 = findViewById(R.id.input5);
        input6 = findViewById(R.id.input6);

        // ključevi za tekstove

        kemija = findViewById(R.id.kemija);
        fizika = findViewById(R.id.fizika);
        tk = findViewById(R.id.tk);

        //Ključevi za gumbove

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Provjera jesu li sva polja ispunjena
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity4.this, Activity3.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity4.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        // Dobivanje unosa iz polja
        String v1 = input1.getText().toString().trim();
        String v2 = input2.getText().toString().trim();
        String v3 = input3.getText().toString().trim();
        String v4 = input4.getText().toString().trim();
        String v5 = input5.getText().toString().trim();
        String v6 = input6.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !v1.isEmpty() && !v2.isEmpty() && !v3.isEmpty() && !v4.isEmpty() && !v5.isEmpty() && !v6.isEmpty();
    }

    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STATE_INPUT_1, Integer.parseInt(input1.getText().toString()));
        editor.putInt(STATE_INPUT_2, Integer.parseInt(input2.getText().toString()));
        editor.putInt(STATE_INPUT_3, Integer.parseInt(input3.getText().toString()));
        editor.putInt(STATE_INPUT_4, Integer.parseInt(input4.getText().toString()));
        editor.putInt(STATE_INPUT_5, Integer.parseInt(input5.getText().toString()));
        editor.putInt(STATE_INPUT_6, Integer.parseInt(input6.getText().toString()));
        editor.apply();
    }
}
