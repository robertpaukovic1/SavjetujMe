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

public class Activity2 extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    TextView text1, text2, text3, text4;
    Button next, back;

    // Ključevi za dijeljene postavke
    private static final String STATE_ET_1 = "state_et1";
    private static final String STATE_ET_2 = "state_et2";
    private static final String STATE_ET_3 = "state_et3";
    private static final String STATE_ET_4 = "state_et4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String selectedSektor = sharedPreferences.getString("selectedSektor", "");
        String selectedZanimanje = sharedPreferences.getString("selectedZanimanje", "");

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);

        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        et4 = findViewById(R.id.editText4);

        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Set the listener for the "next" button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if all fields are filled
                if (validateFields()) {
                    saveUserInputs();
                    Intent intent = new Intent(Activity2.this, Activity11.class);
                    startActivity(intent);
                } else {
                    // If any field is empty, show a message to the user
                    Toast.makeText(Activity2.this, "Molimo ispunite sva polja!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set the listener for the "back" button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });
    }

    // Method to check if all fields are filled
    private boolean validateFields() {
        String value1 = et1.getText().toString().trim();
        String value2 = et2.getText().toString().trim();
        String value3 = et3.getText().toString().trim();
        String value4 = et4.getText().toString().trim();

        // If any field is empty, return false
        return !value1.isEmpty() && !value2.isEmpty() && !value3.isEmpty() && !value4.isEmpty();
    }

    // Method to save user inputs in SharedPreferences
    private void saveUserInputs() {
        // Save inputs to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STATE_ET_1, et1.getText().toString());
        editor.putString(STATE_ET_2, et2.getText().toString());
        editor.putString(STATE_ET_3, et3.getText().toString());
        editor.putString(STATE_ET_4, et4.getText().toString());
        editor.apply();
    }
}

