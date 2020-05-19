package com.example.perklucenieyazika2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initSpinnerLanguage();

    }

    private void initViews() {
        languageSpinner = findViewById(R.id.languageSpinner);
        btnOk = findViewById(R.id.btnOk);
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        TextView txtChooseLanguage = findViewById(R.id.txtChooseLanguage);

    }

    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLanguage);


        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] languages = getResources().getStringArray(R.array.language);

                setOnClickButton(languages[i]);
            }

            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

    }

    private void setOnClickButton(final String lang) {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (lang) {

                    case "Английский":
                        Locale localeEn = new Locale("en");
                        Configuration configEn = new Configuration();
                        configEn.setLocale(localeEn);
                        getResources().updateConfiguration(configEn, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        return;
                    case "Russian":
                        Locale localeRu = new Locale("ru");
                        Configuration configRu = new Configuration();
                        configRu.setLocale(localeRu);
                        getResources().updateConfiguration(configRu, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        return;

                }

            }
        });

    }
}

