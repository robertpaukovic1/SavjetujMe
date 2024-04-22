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

public class Activity9 extends AppCompatActivity {

    EditText inputA4, inputB4, inputC4, inputD4, inputE4, inputF4;
    TextView biologija, kemija, tk;
    Button next, back;


    private static final String STATE_INPUT_A4 = "state_input_A4";
    private static final String STATE_INPUT_B4 = "state_input_B4";
    private static final String STATE_INPUT_C4 = "state_input_C4";
    private static final String STATE_INPUT_D4 = "state_input_D4";
    private static final String STATE_INPUT_E4 = "state_input_E4";
    private static final String STATE_INPUT_F4 = "state_input_F4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        inputA4 = findViewById(R.id.inputA4);
        inputB4 = findViewById(R.id.inputB4);
        inputC4 = findViewById(R.id.inputC4);
        inputD4 = findViewById(R.id.inputD4);
        inputE4 = findViewById(R.id.inputE4);
        inputF4 = findViewById(R.id.inputF4);

        biologija = findViewById(R.id.biologija);
        kemija = findViewById(R.id.kemija);
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
                    Intent intent = new Intent(Activity9.this, Activity3.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity9.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity9.this, Activity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        String vA4 = inputA4.getText().toString().trim();
        String vB4 = inputB4.getText().toString().trim();
        String vC4 = inputC4.getText().toString().trim();
        String vD4 = inputD4.getText().toString().trim();
        String vE4 = inputE4.getText().toString().trim();
        String vF4 = inputF4.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !vA4.isEmpty() && !vB4.isEmpty() && !vC4.isEmpty() && !vD4.isEmpty() && !vE4.isEmpty() && !vF4.isEmpty();
    }


    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STATE_INPUT_A4, Integer.parseInt(inputA4.getText().toString()));
        editor.putInt(STATE_INPUT_B4, Integer.parseInt(inputB4.getText().toString()));
        editor.putInt(STATE_INPUT_C4, Integer.parseInt(inputC4.getText().toString()));
        editor.putInt(STATE_INPUT_D4, Integer.parseInt(inputD4.getText().toString()));
        editor.putInt(STATE_INPUT_E4, Integer.parseInt(inputE4.getText().toString()));
        editor.putInt(STATE_INPUT_F4, Integer.parseInt(inputF4.getText().toString()));
        editor.apply();
    }


}
