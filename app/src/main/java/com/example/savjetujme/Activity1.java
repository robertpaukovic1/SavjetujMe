package com.example.savjetujme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity1 extends AppCompatActivity {

    Button next, back;  // Gumbovi za kretanje prema naprijed i natrag
    Spinner spinner, spinner2; // Padajući izbornici za odabir sektora i zanimanja

    private Map<String, List<String>> zanimanjaMap;  // mapa koja definira spinnere tj izbornike

    // Ključevi za pohranu odabira sekotra i zanimanja u dijeljene postavke
    private static final String STATE_SELECTED_SEKTOR = "state_selected_sektor";
    private static final String STATE_SELECTED_ZANIMANJE = "state_selected_zanimanje";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        next = findViewById(R.id.button2);
        back = findViewById(R.id.button1);

        // Stvaranje liste sektora
        List<String> sektori = Arrays.asList("Odaberi obrazovni sektor",
                "Ekonomija i poslovna administracija",
                "Elektrotehnika i Računalstvo",
                "Gimnazija",
                "Turizam i ugostiteljstvo",
                "Grafička tehnologija i audiovizualne komunikacije",
                "Poljoprivreda, prehrana i veterina",
                "Zdravstvo i socijalna skrb"
        );

        // Stvaranje adaptera za prvi spinner
        ArrayAdapter<String> sektorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sektori);
        sektorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(sektorAdapter);

        // Inicijalizacija mape sa sektorima i pripadajućim zanimanjima
        initializeZanimanjaMap();

        // Pokušaj obnavljanja odabranih sektora i zanimanja iz SharedPreferences
        restoreSelectedData(savedInstanceState);

        // Postavljanje slušača za prvi spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedSektor = (String) spinner.getSelectedItem();
                updateZanimanjaSpinner(selectedSektor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        // Postavljanje slušača za gumb "next"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedSektor = (String) spinner.getSelectedItem();
                String selectedZanimanje = (String) spinner2.getSelectedItem();

                Log.d("Activity1", "Odabrani sektor: " + selectedSektor);

                if (!selectedSektor.equals("Odaberi obrazovni sektor") && !selectedZanimanje.equals("Odaberi zanimanje")) {
                    // Spremanje odabranih podataka u SharedPreferences
                    saveSelectedData(selectedSektor, selectedZanimanje);

                    // Ovisno o odabranom sektoru, pokreće se  odgovarajuća aktivnost
                    if (selectedSektor.equals("Elektrotehnika i Računalstvo")) {
                        Intent intent = new Intent(Activity1.this, Activity4.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedSektor.equals("Turizam i ugostiteljstvo")) {
                        Intent intent = new Intent(Activity1.this, Activity5.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedSektor.equals("Ekonomija i poslovna administracija")) {
                        Intent intent = new Intent(Activity1.this, Activity6.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedSektor.equals("Gimnazija")) {
                        Intent intent = new Intent(Activity1.this, Activity7.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedSektor.equals("Grafička tehnologija i audiovizualne komunikacije")) {
                        Intent intent = new Intent(Activity1.this, Activity8.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedSektor.equals("Poljoprivreda, prehrana i veterina")) {
                        Intent intent = new Intent(Activity1.this, Activity9.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedSektor.equals("Zdravstvo i socijalna skrb")) {
                        Intent intent = new Intent(Activity1.this, Activity10.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    // Prikazivanje Toast poruke
                    Toast.makeText(Activity1.this, "Molimo odaberite sektor i zanimanje", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Postavljanje slušača za gumb "back"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Inicijalizacija mape sa sektorima i pripadajućim zanimanjima
    private void initializeZanimanjaMap() {
        zanimanjaMap = new HashMap<>();
        zanimanjaMap.put("Ekonomija i poslovna administracija", Arrays.asList("Odaberi zanimanje", "Ekonomist", "Komercijalist", "Poslovni tajnik", "Marketinški stručnjak", "Upravni referent"));
        zanimanjaMap.put("Elektrotehnika i Računalstvo", Arrays.asList("Odaberi zanimanje", "Elektrotehničar", "Tehničar za računalstvo", "Tehničar za elektroniku", "Tehničar za električne strojeve sa primjenjivim računalstvom", "Tehničar za mehatroniku", "Tehničar za radio i telekomunikacije"));
        zanimanjaMap.put("Gimnazija", Arrays.asList("Odaberi zanimanje", "Opća gimnazija", "Prirodoslovno-Matematička gimnazija", "Klasična gimnazija", "Jezična Gimnazija"));
        zanimanjaMap.put("Turizam i ugostiteljstvo", Arrays.asList("Odaberi zanimanje", "Kuhar", "Konobar", "Slastičar", "Hoteljersko-turistički komercijalist"));
        zanimanjaMap.put("Grafička tehnologija i audiovizualne komunikacije", Arrays.asList("Odaberi zanimanje", "Grafički dizajner", "Grafički tehničar", "Medijski tehničar", "Tehnički urednik", "Web dizajner"));
        zanimanjaMap.put("Poljoprivreda, prehrana i veterina", Arrays.asList("Odaberi zanimanje", "Tehničar biljne proizvodnje", "Fitofarmaceut", "Agrotehničar", "Stočar", "Mljekarski tehničar", "Prehrambeni tehničar"));
        zanimanjaMap.put("Zdravstvo i socijalna skrb", Arrays.asList("Odaberi zanimanje", "Medicinska sestra", "Tehničar za dentalnu medicinu", "Laboratorijski tehničar", "Socijalni radnik", "Fizioterapeut", "Zdravstveni menadžment"));
    }

    // Ažuriranje drugog spinnera s odgovarajućim zanimanjima
    private void updateZanimanjaSpinner(String selectedSektor) {
        List<String> zanimanja = zanimanjaMap.get(selectedSektor);
        if (zanimanja != null) {
            ArrayAdapter<String> zanimanjeAdapter = new ArrayAdapter<>(Activity1.this, android.R.layout.simple_spinner_item, zanimanja);
            zanimanjeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(zanimanjeAdapter);

            // Resetiranje poruke na gumbu "next"
            next.setText("Dalje");
        }
    }

    private void saveSelectedData(String sektor, String zanimanje) {
        Log.d("Activity1", "Spremljen sektor: " + sektor);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STATE_SELECTED_SEKTOR, sektor);
        editor.putString(STATE_SELECTED_ZANIMANJE, zanimanje);
        editor.apply();
    }

    private void restoreSelectedData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Pokušaj obnove odabranih podataka iz spremljenog stanja
            String selectedSektor = savedInstanceState.getString(STATE_SELECTED_SEKTOR, "");
            String selectedZanimanje = savedInstanceState.getString(STATE_SELECTED_ZANIMANJE, "");

            // Ako postoje spremljeni podaci, postavi ih
            if (!selectedSektor.isEmpty() && !selectedZanimanje.isEmpty()) {
                spinner.setSelection(getIndex(spinner, selectedSektor));
                updateZanimanjaSpinner(selectedSektor);
                spinner2.setSelection(getIndex(spinner2, selectedZanimanje));
            }
        } else {
            // Ako nema spremljenog stanja, pokušaj obnove odabranih podataka iz SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String selectedSektor = sharedPreferences.getString(STATE_SELECTED_SEKTOR, "");
            String selectedZanimanje = sharedPreferences.getString(STATE_SELECTED_ZANIMANJE, "");

            // Ako postoje spremljeni podaci, postavljaju se
            if (!selectedSektor.isEmpty() && !selectedZanimanje.isEmpty()) {
                spinner.setSelection(getIndex(spinner, selectedSektor));
                updateZanimanjaSpinner(selectedSektor);
                spinner2.setSelection(getIndex(spinner2, selectedZanimanje));
            }
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Spremanje odabranih podataka u Bundle
        outState.putString(STATE_SELECTED_SEKTOR, (String) spinner.getSelectedItem());
        outState.putString(STATE_SELECTED_ZANIMANJE, (String) spinner2.getSelectedItem());
    }

    private int getIndex(Spinner spinner, String value) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(value)) {
                return i;
            }
        }
        return 0;
    }


}







