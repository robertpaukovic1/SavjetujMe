package com.example.savjetujme;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity11 extends AppCompatActivity {

    Button calcButton;

    // za kem, fiz, tk
    EditText input1, input2, input3, input4, input5, input6;

    // za  pov, geo, lk
    EditText inputA, inputB, inputC, inputD, inputE, inputF;

    //za pov, geo, tk
    EditText inputA1, inputB1, inputC1, inputD1, inputE1, inputF1;

    // Za bio, pov, geo
    EditText inputA2, inputB2, inputC2, inputD2, inputE2, inputF2;

    // Za kem, fiz, lk
    EditText inputA3, inputB3, inputC3, inputD3, inputE3, inputF3;

    //za kem, fiz, lk

    EditText inputA4, inputB4, inputC4, inputD4, inputE4, inputF4;


    //za bio, kem, fiz

    EditText inputA5, inputB5, inputC5, inputD5, inputE5, inputF5;

    // Ocjene hrv, str, mat
    EditText et5, et6, et7, et8, et9, et10;

    // Prosjeci ocjena
    EditText et1, et2, et3, et4;

    //Odabrani sektor i zanimanje

    private static final String STATE_SELECTED_SEKTOR = "state_selected_sektor";
    private static final String STATE_SELECTED_ZANIMANJE = "state_selected_zanimanje";

    //Za elektrotehniku i računalstvo
    private static final String STATE_INPUT_1 = "state_input_1";
    private static final String STATE_INPUT_2 = "state_input_2";
    private static final String STATE_INPUT_3 = "state_input_3";
    private static final String STATE_INPUT_4 = "state_input_4";
    private static final String STATE_INPUT_5 = "state_input_5";
    private static final String STATE_INPUT_6 = "state_input_6";

    //Za turizam i ugostiteljstvo
    private static final String STATE_INPUT_A = "state_input_A";
    private static final String STATE_INPUT_B = "state_input_B";
    private static final String STATE_INPUT_C = "state_input_C";
    private static final String STATE_INPUT_D = "state_input_D";
    private static final String STATE_INPUT_E = "state_input_E";
    private static final String STATE_INPUT_F = "state_input_F";

    //Za ekonomiju i poslovnu administraciju
    private static final String STATE_INPUT_A1 = "state_input_A1";
    private static final String STATE_INPUT_B1 = "state_input_B1";
    private static final String STATE_INPUT_C1 = "state_input_C1";
    private static final String STATE_INPUT_D1 = "state_input_D1";
    private static final String STATE_INPUT_E1 = "state_input_E1";
    private static final String STATE_INPUT_F1 = "state_input_F1";

    // Za Gimnaziju

    private static final String STATE_INPUT_A2 = "state_input_A2";
    private static final String STATE_INPUT_B2 = "state_input_B2";
    private static final String STATE_INPUT_C2 = "state_input_C2";
    private static final String STATE_INPUT_D2 = "state_input_D2";
    private static final String STATE_INPUT_E2 = "state_input_E2";
    private static final String STATE_INPUT_F2 = "state_input_F2";


    // Za grafičke tehnologije i audiovizualne komunikacije

    private static final String STATE_INPUT_A3 = "state_input_A3";
    private static final String STATE_INPUT_B3 = "state_input_B3";
    private static final String STATE_INPUT_C3 = "state_input_C3";
    private static final String STATE_INPUT_D3 = "state_input_D3";
    private static final String STATE_INPUT_E3 = "state_input_E3";
    private static final String STATE_INPUT_F3 = "state_input_F3";

    // Za poljoprivredu,prehanu i veterinu

    private static final String STATE_INPUT_A4 = "state_input_A4";
    private static final String STATE_INPUT_B4 = "state_input_B4";
    private static final String STATE_INPUT_C4 = "state_input_C4";
    private static final String STATE_INPUT_D4 = "state_input_D4";
    private static final String STATE_INPUT_E4 = "state_input_E4";
    private static final String STATE_INPUT_F4 = "state_input_F4";


    // Za Zdravstvo i socijalnu skrb
    private static final String STATE_INPUT_A5 = "state_input_A5";
    private static final String STATE_INPUT_B5 = "state_input_B5";
    private static final String STATE_INPUT_C5 = "state_input_C5";
    private static final String STATE_INPUT_D5 = "state_input_D5";
    private static final String STATE_INPUT_E5 = "state_input_E5";
    private static final String STATE_INPUT_F5= "state_input_F5";



    // Obavezni predmeti
    private static final String STATE_INPUT_7 = "state_input_7";
    private static final String STATE_INPUT_8 = "state_input_8";
    private static final String STATE_INPUT_9 = "state_input_9";
    private static final String STATE_INPUT_10 = "state_input_10";
    private static final String STATE_INPUT_11 = "state_input_11";
    private static final String STATE_INPUT_12 = "state_input_12";

    // Prosjeci ocjena
    private static final String STATE_INPUT_13 = "state_input_13";
    private static final String STATE_INPUT_14 = "state_input_14";
    private static final String STATE_INPUT_15 = "state_input_15";
    private static final String STATE_INPUT_16 = "state_input_16";

    private String selectedSektor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);

        calcButton = findViewById(R.id.calcButton);

        //Za elektrotehniku i računalstvo
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        input5 = findViewById(R.id.input5);
        input6 = findViewById(R.id.input6);

        //Za turizam i ugostiteljstvo
        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        inputC = findViewById(R.id.inputC);
        inputD = findViewById(R.id.inputD);
        inputE = findViewById(R.id.inputE);
        inputF = findViewById(R.id.inputF);

        //za  ekonomiju i poslovnu administraciju
        inputA1 = findViewById(R.id.inputA1);
        inputB1 = findViewById(R.id.inputB1);
        inputC1 = findViewById(R.id.inputC1);
        inputD1 = findViewById(R.id.inputD1);
        inputE1 = findViewById(R.id.inputE1);
        inputF1 = findViewById(R.id.inputF1);

        // za  gimnaziju
        inputA2 = findViewById(R.id.inputA2);
        inputB2 = findViewById(R.id.inputB2);
        inputC2 = findViewById(R.id.inputC2);
        inputD2 = findViewById(R.id.inputD2);
        inputE2 = findViewById(R.id.inputE2);
        inputF2 = findViewById(R.id.inputF2);

        // za  grafičke tehnologije i audiovizualne komunikacije
        inputA3 = findViewById(R.id.inputA3);
        inputB3 = findViewById(R.id.inputB3);
        inputC3 = findViewById(R.id.inputC3);
        inputD3 = findViewById(R.id.inputD3);
        inputE3 = findViewById(R.id.inputE3);
        inputF3 = findViewById(R.id.inputF3);

        // Za poljoprivredu, prehranu i veterinu
        inputA4 = findViewById(R.id.inputA4);
        inputB4 = findViewById(R.id.inputB4);
        inputC4 = findViewById(R.id.inputC4);
        inputD4 = findViewById(R.id.inputD4);
        inputE4 = findViewById(R.id.inputE4);
        inputF4 = findViewById(R.id.inputF4);

        // Za zdravstvo i socijalnu skrb
        inputA5 = findViewById(R.id.inputA5);
        inputB5 = findViewById(R.id.inputB5);
        inputC5 = findViewById(R.id.inputC5);
        inputD5 = findViewById(R.id.inputD5);
        inputE5 = findViewById(R.id.inputE5);
        inputF5 = findViewById(R.id.inputF5);

        // Za sve sektore hrv str i mat
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);
        et9 = findViewById(R.id.et9);
        et10 = findViewById(R.id.et10);

        // Prosjeci ocjena
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        et4 = findViewById(R.id.editText4);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        selectedSektor = sharedPreferences.getString(STATE_SELECTED_SEKTOR, "");


    }

    public void Zbrajanje(View v) {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

            // za Elektrotehniku i Računalstvo
            int kem7 = sharedPreferences.getInt(STATE_INPUT_1, 0);
            int kem8 = sharedPreferences.getInt(STATE_INPUT_2, 0);
            int fiz7 = sharedPreferences.getInt(STATE_INPUT_3, 0);
            int fiz8 = sharedPreferences.getInt(STATE_INPUT_4, 0);
            int tk7 = sharedPreferences.getInt(STATE_INPUT_5, 0);
            int tk8 = sharedPreferences.getInt(STATE_INPUT_6, 0);

            //Za Turizam i ugostiteljstvo
            int pov7 = sharedPreferences.getInt(STATE_INPUT_A, 0);
            int pov8 = sharedPreferences.getInt(STATE_INPUT_B, 0);
            int geo7 = sharedPreferences.getInt(STATE_INPUT_C, 0);
            int geo8 = sharedPreferences.getInt(STATE_INPUT_D, 0);
            int lk7 = sharedPreferences.getInt(STATE_INPUT_E, 0);
            int lk8 = sharedPreferences.getInt(STATE_INPUT_F, 0);

            //Za ekonomiju i poslovnu administraciju


            int pov7a = sharedPreferences.getInt(STATE_INPUT_A1, 0);
            int pov8a = sharedPreferences.getInt(STATE_INPUT_B1, 0);
            int geo7a = sharedPreferences.getInt(STATE_INPUT_C1, 0);
            int geo8a = sharedPreferences.getInt(STATE_INPUT_D1, 0);
            int tk7a = sharedPreferences.getInt(STATE_INPUT_E1, 0);
            int tk8a = sharedPreferences.getInt(STATE_INPUT_F1, 0);

            // Za gimnaziju

            int bio7b = sharedPreferences.getInt(STATE_INPUT_A2, 0);
            int bio8b = sharedPreferences.getInt(STATE_INPUT_B2, 0);
            int pov7b = sharedPreferences.getInt(STATE_INPUT_C2, 0);
            int pov8b = sharedPreferences.getInt(STATE_INPUT_D2, 0);
            int geo7b = sharedPreferences.getInt(STATE_INPUT_E2, 0);
            int geo8b = sharedPreferences.getInt(STATE_INPUT_F2, 0);

            // Za grafičke tehnologije i audiovizualne komunikacije

            int kem7c = sharedPreferences.getInt(STATE_INPUT_A3, 0);
            int kem8c = sharedPreferences.getInt(STATE_INPUT_B3, 0);
            int fiz7c = sharedPreferences.getInt(STATE_INPUT_C3, 0);
            int fiz8c = sharedPreferences.getInt(STATE_INPUT_D3, 0);
            int lk7c = sharedPreferences.getInt(STATE_INPUT_E3, 0);
            int lk8c = sharedPreferences.getInt(STATE_INPUT_F3, 0);

            //Za poljoprivredu, prehranu i veterinu

            int bio7d = sharedPreferences.getInt(STATE_INPUT_A4, 0);
            int bio8d = sharedPreferences.getInt(STATE_INPUT_B4, 0);
            int kem7d = sharedPreferences.getInt(STATE_INPUT_C4, 0);
            int kem8d = sharedPreferences.getInt(STATE_INPUT_D4, 0);
            int tk7d = sharedPreferences.getInt(STATE_INPUT_E4, 0);
            int tk8d = sharedPreferences.getInt(STATE_INPUT_F4, 0);

            //Za zdravstvo i socijalnu skrb

            int bio7e = sharedPreferences.getInt(STATE_INPUT_A5, 0);
            int bio8e = sharedPreferences.getInt(STATE_INPUT_B5, 0);
            int kem7e = sharedPreferences.getInt(STATE_INPUT_C5, 0);
            int kem8e = sharedPreferences.getInt(STATE_INPUT_D5, 0);
            int fiz7e = sharedPreferences.getInt(STATE_INPUT_E4, 0);
            int fiz8e = sharedPreferences.getInt(STATE_INPUT_F5, 0);

            //Za sve sektore
            int hrv7 = sharedPreferences.getInt(STATE_INPUT_7, 0);
            int hrv8 = sharedPreferences.getInt(STATE_INPUT_8, 0);
            int str7 = sharedPreferences.getInt(STATE_INPUT_9, 0);
            int str8 = sharedPreferences.getInt(STATE_INPUT_10, 0);
            int mat7 = sharedPreferences.getInt(STATE_INPUT_11, 0);
            int mat8 = sharedPreferences.getInt(STATE_INPUT_12, 0);

            float p1 = sharedPreferences.getFloat(STATE_INPUT_13, 0.0f);
            float p2 = sharedPreferences.getFloat(STATE_INPUT_14, 0.0f);
            float p3 = sharedPreferences.getFloat(STATE_INPUT_15, 0.0f);
            float p4 = sharedPreferences.getFloat(STATE_INPUT_16, 0.0f);

            float result = 0.0f;

            if (selectedSektor.equals("Turizam i ugostiteljstvo")) {
                result = pov7 + pov8 + geo7 + geo8 + lk7 + lk8 + hrv7 + hrv8 + str7 + str8 + mat7 + mat8 + p1 + p2 + p3 + p4;
            }
            else if(selectedSektor.equals("Elektrotehnika i Računalstvo")) {

                 result = kem7 + kem8 + fiz7 + fiz8 + tk7 + tk8 + hrv7 + hrv8 + str7 + str8 + mat7 + mat8 + p1 + p2 + p3 + p4;
            }
            else if(selectedSektor.equals("Ekonomija i poslovna administracija")) {

                result = pov7a + pov8a + geo7a + geo8a + tk7a + tk8a + hrv7 + hrv8 + str7 + str8 + mat7 + mat8 + p1 + p2 + p3 + p4;
            }
            else if(selectedSektor.equals("Gimnazija")) {

                result = bio7b + bio8b + pov7b + pov8b + geo7b + geo8b + hrv7 + hrv8 + str7 + str8 + mat7 + mat8 + p1 + p2 + p3 + p4;
            }

            else if(selectedSektor.equals("Grafička tehnologija i audiovizualne komunikacije")) {

                result = kem7c + kem8c + fiz7c + fiz8c + lk7c + lk8c + hrv7 + hrv8 + str7 + str8 + mat7 + mat8 + p1 + p2 + p3 + p4;

            }
            else if(selectedSektor.equals("Poljoprivreda, prehrana i veterina")) {

                result = bio7d + bio8d + kem7d + kem8d + tk7d + tk8d + hrv7 + hrv8 + str7 + str8 + mat7 + mat8 + p1 + p2 + p3 + p4;

            }

            else if(selectedSektor.equals("Zdravstvo i socijalna skrb")) {

                result = bio7e + bio8e + kem7e + kem8e + fiz7e + fiz8e + hrv7 + hrv8 + str7 + str8 + mat7 + mat8 + p1 + p2 + p3 + p4;

            }
            else {
                Toast.makeText(Activity11.this, "Obrazovni sektor ne postoji!", Toast.LENGTH_SHORT).show();

            }
            prikaziRezultat(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void prikaziRezultat(float result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("rezultat", result);
        startActivity(intent);
    }
}






