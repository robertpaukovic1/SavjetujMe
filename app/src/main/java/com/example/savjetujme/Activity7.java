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

public class Activity7 extends AppCompatActivity {

    EditText inputA2, inputB2, inputC2, inputD2, inputE2, inputF2;
    TextView biologija, povijest, geografija;
    Button next, back;

    //Ključevi za dijeljene postavke
    private static final String STATE_INPUT_A2 = "state_input_A2";
    private static final String STATE_INPUT_B2 = "state_input_B2";
    private static final String STATE_INPUT_C2 = "state_input_C2";
    private static final String STATE_INPUT_D2 = "state_input_D2";
    private static final String STATE_INPUT_E2 = "state_input_E2";
    private static final String STATE_INPUT_F2 = "state_input_F2";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        inputA2 = findViewById(R.id.inputA2);
        inputB2 = findViewById(R.id.inputB2);
        inputC2 = findViewById(R.id.inputC2);
        inputD2 = findViewById(R.id.inputD2);
        inputE2 = findViewById(R.id.inputE2);
        inputF2 = findViewById(R.id.inputF2);


        povijest = findViewById(R.id.povijest);
        geografija = findViewById(R.id.geografija);
        biologija = findViewById(R.id.biologija);

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Provjera jesu li sva polja ispunjena
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity7.this, Activity3.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity7.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity7.this, Activity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        String vA2 = inputA2.getText().toString().trim();
        String vB2 = inputB2.getText().toString().trim();
        String vC2 = inputC2.getText().toString().trim();
        String vD2 = inputD2.getText().toString().trim();
        String vE2 = inputE2.getText().toString().trim();
        String vF2 = inputF2.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !vA2.isEmpty() && !vB2.isEmpty() && !vC2.isEmpty() && !vD2.isEmpty() && !vE2.isEmpty() && !vF2.isEmpty();
    }

    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STATE_INPUT_A2, Integer.parseInt(inputA2.getText().toString()));
        editor.putInt(STATE_INPUT_B2, Integer.parseInt(inputB2.getText().toString()));
        editor.putInt(STATE_INPUT_C2, Integer.parseInt(inputC2.getText().toString()));
        editor.putInt(STATE_INPUT_D2, Integer.parseInt(inputD2.getText().toString()));
        editor.putInt(STATE_INPUT_E2, Integer.parseInt(inputE2.getText().toString()));
        editor.putInt(STATE_INPUT_F2, Integer.parseInt(inputF2.getText().toString()));
        editor.apply();
    }

}