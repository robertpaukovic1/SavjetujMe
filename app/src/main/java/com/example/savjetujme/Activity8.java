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

public class Activity8 extends AppCompatActivity {

    EditText inputA3, inputB3, inputC3, inputD3, inputE3, inputF3;
    TextView kemija, fizika, lk;
    Button next, back;


    //Ključevi dijeljenih postavki
    private static final String STATE_INPUT_A3 = "state_input_A4";
    private static final String STATE_INPUT_B3 = "state_input_B3";
    private static final String STATE_INPUT_C3 = "state_input_C2";
    private static final String STATE_INPUT_D3 = "state_input_D2";
    private static final String STATE_INPUT_E3 = "state_input_E2";
    private static final String STATE_INPUT_F3 = "state_input_F3";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);
        inputA3 = findViewById(R.id.inputA3);
        inputB3 = findViewById(R.id.inputB3);
        inputC3 = findViewById(R.id.inputC3);
        inputD3 = findViewById(R.id.inputD3);
        inputE3 = findViewById(R.id.inputE3);
        inputF3 = findViewById(R.id.inputF3);


        kemija = findViewById(R.id.kemija);
        fizika = findViewById(R.id.fizika);
        lk = findViewById(R.id.lk);

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity8.this, Activity3.class);
                    startActivity(intent);
                } else {
                    // Ako polja nisu ispunjena, prikaži poruku korisniku
                    Toast.makeText(Activity8.this, "Molimo ispunite sva polja", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity8.this, Activity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields() {
        String vA3 = inputA3.getText().toString().trim();
        String vB3 = inputB3.getText().toString().trim();
        String vC3 = inputC3.getText().toString().trim();
        String vD3 = inputD3.getText().toString().trim();
        String vE3= inputE3.getText().toString().trim();
        String vF3 = inputF3.getText().toString().trim();

        // Ako bilo koje od polja nisu ispunjena, vrati false
        return !vA3.isEmpty() && !vB3.isEmpty() && !vC3.isEmpty() && !vD3.isEmpty() && !vE3.isEmpty() && !vF3.isEmpty();
    }


    private void saveUserInputs() {
        // Spremanje unosa u Dijeljene postavke
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STATE_INPUT_A3, Integer.parseInt(inputA3.getText().toString()));
        editor.putInt(STATE_INPUT_B3, Integer.parseInt(inputB3.getText().toString()));
        editor.putInt(STATE_INPUT_C3, Integer.parseInt(inputC3.getText().toString()));
        editor.putInt(STATE_INPUT_D3, Integer.parseInt(inputD3.getText().toString()));
        editor.putInt(STATE_INPUT_E3, Integer.parseInt(inputE3.getText().toString()));
        editor.putInt(STATE_INPUT_F3, Integer.parseInt(inputF3.getText().toString()));
        editor.apply();
    }

}
