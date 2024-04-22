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

public class Activity5 extends AppCompatActivity {

    EditText inputA, inputB, inputC, inputD, inputE, inputF;  // Tekstualna polja
    TextView povijest, geografija, lk; // tekstovi iznad polja
    Button next, back; // gumbovi za naprijed i natrag


    // Ključevi za dijeljene postavke
    private static final String STATE_INPUT_A = "state_input_A";
    private static final String STATE_INPUT_B = "state_input_B";
    private static final String STATE_INPUT_C = "state_input_C";
    private static final String STATE_INPUT_D = "state_input_D";
    private static final String STATE_INPUT_E = "state_input_E";
    private static final String STATE_INPUT_F = "state_input_F";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        inputC = findViewById(R.id.inputC);
        inputD = findViewById(R.id.inputD);
        inputE = findViewById(R.id.inputE);
        inputF = findViewById(R.id.inputF);


        povijest = findViewById(R.id.povijest);
        geografija = findViewById(R.id.fizika);
        lk = findViewById(R.id.lk);

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Provjera jesu li sva polja ispunjena
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity5.this, Activity3.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity5.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity5.this, Activity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        String vA = inputA.getText().toString().trim();
        String vB = inputB.getText().toString().trim();
        String vC = inputC.getText().toString().trim();
        String vD = inputD.getText().toString().trim();
        String vE = inputE.getText().toString().trim();
        String vF = inputF.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !vA.isEmpty() && !vB.isEmpty() && !vC.isEmpty() && !vD.isEmpty() && !vE.isEmpty() && !vF.isEmpty();
    }

    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STATE_INPUT_A, Integer.parseInt(inputA.getText().toString()));
        editor.putInt(STATE_INPUT_B, Integer.parseInt(inputB.getText().toString()));
        editor.putInt(STATE_INPUT_C, Integer.parseInt(inputC.getText().toString()));
        editor.putInt(STATE_INPUT_D, Integer.parseInt(inputD.getText().toString()));
        editor.putInt(STATE_INPUT_E, Integer.parseInt(inputE.getText().toString()));
        editor.putInt(STATE_INPUT_F, Integer.parseInt(inputF.getText().toString()));
        editor.apply();
    }

}
