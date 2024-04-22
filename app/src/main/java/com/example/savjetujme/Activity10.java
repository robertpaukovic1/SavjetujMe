package com.example.savjetujme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity10 extends AppCompatActivity {

    EditText inputA5, inputB5, inputC5, inputD5, inputE5, inputF5;
    TextView biologija, kemija, fizika;
    Button next, back;

    private static final String STATE_INPUT_A5 = "state_input_A5";
    private static final String STATE_INPUT_B5 = "state_input_B5";
    private static final String STATE_INPUT_C5 = "state_input_C5";
    private static final String STATE_INPUT_D5 = "state_input_D5";
    private static final String STATE_INPUT_E5 = "state_input_E5";
    private static final String STATE_INPUT_F5= "state_input_F5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);

        inputA5 = findViewById(R.id.inputA5);
        inputB5 = findViewById(R.id.inputB5);
        inputC5 = findViewById(R.id.inputC5);
        inputD5 = findViewById(R.id.inputD5);
        inputE5 = findViewById(R.id.inputE5);
        inputF5 = findViewById(R.id.inputF5);

        biologija = findViewById(R.id.biologija);
        kemija = findViewById(R.id.kemija);
        fizika = findViewById(R.id.fizika);

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Provjera jesu li sva polja ispunjena
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity10.this, Activity3.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity10.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity10.this, Activity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        String vA5 = inputA5.getText().toString().trim();
        String vB5 = inputB5.getText().toString().trim();
        String vC5 = inputC5.getText().toString().trim();
        String vD5 = inputD5.getText().toString().trim();
        String vE5 = inputE5.getText().toString().trim();
        String vF5 = inputF5.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !vA5.isEmpty() && !vB5.isEmpty() && !vC5.isEmpty() && !vD5.isEmpty() && !vE5.isEmpty() && !vF5.isEmpty();
    }

    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STATE_INPUT_A5, Integer.parseInt(inputA5.getText().toString()));
        editor.putInt(STATE_INPUT_B5, Integer.parseInt(inputB5.getText().toString()));
        editor.putInt(STATE_INPUT_C5, Integer.parseInt(inputC5.getText().toString()));
        editor.putInt(STATE_INPUT_D5, Integer.parseInt(inputD5.getText().toString()));
        editor.putInt(STATE_INPUT_E5, Integer.parseInt(inputE5.getText().toString()));
        editor.putInt(STATE_INPUT_F5, Integer.parseInt(inputF5.getText().toString()));
        editor.apply();
    }









}
