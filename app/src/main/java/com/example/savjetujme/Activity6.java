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

public class Activity6 extends AppCompatActivity {

    EditText inputA1, inputB1, inputC1, inputD1, inputE1, inputF1;
    TextView povijest, geografija, tk;
    Button next, back;


    //Ključevi  dijeljenih postavki
    private static final String STATE_INPUT_A1 = "state_input_A1";
    private static final String STATE_INPUT_B1 = "state_input_B1";
    private static final String STATE_INPUT_C1 = "state_input_C1";
    private static final String STATE_INPUT_D1 = "state_input_D1";
    private static final String STATE_INPUT_E1 = "state_input_E1";
    private static final String STATE_INPUT_F1 = "state_input_F1";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        inputA1 = findViewById(R.id.inputA1);
        inputB1 = findViewById(R.id.inputB1);
        inputC1 = findViewById(R.id.inputC1);
        inputD1 = findViewById(R.id.inputD1);
        inputE1 = findViewById(R.id.inputE1);
        inputF1 = findViewById(R.id.inputF1);


        povijest = findViewById(R.id.povijest);
        geografija = findViewById(R.id.geografija);
        tk = findViewById(R.id.tk);

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Provjera jesu li sva polja ispunjena
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity6.this, Activity3.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity6.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity6.this, Activity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        String vA1 = inputA1.getText().toString().trim();
        String vB1 = inputB1.getText().toString().trim();
        String vC1 = inputC1.getText().toString().trim();
        String vD1 = inputD1.getText().toString().trim();
        String vE1 = inputE1.getText().toString().trim();
        String vF1 = inputF1.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !vA1.isEmpty() && !vB1.isEmpty() && !vC1.isEmpty() && !vD1.isEmpty() && !vE1.isEmpty() && !vF1.isEmpty();
    }

    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STATE_INPUT_A1, Integer.parseInt(inputA1.getText().toString()));
        editor.putInt(STATE_INPUT_B1, Integer.parseInt(inputB1.getText().toString()));
        editor.putInt(STATE_INPUT_C1, Integer.parseInt(inputC1.getText().toString()));
        editor.putInt(STATE_INPUT_D1, Integer.parseInt(inputD1.getText().toString()));
        editor.putInt(STATE_INPUT_E1, Integer.parseInt(inputE1.getText().toString()));
        editor.putInt(STATE_INPUT_F1, Integer.parseInt(inputF1.getText().toString()));
        editor.apply();
    }

}