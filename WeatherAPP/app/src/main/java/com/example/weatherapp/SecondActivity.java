package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.weatherapp.MainActivity.NAME_CITY;
import static com.example.weatherapp.MainActivity.PRESSURE_CITY;
import static com.example.weatherapp.MainActivity.WIND_CITY;
import static com.example.weatherapp.fragments.WeatherFragment.CITY;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvСity;
    private TextView tvDates;
    private Button btnNext;
    private String cityName;
    private String cityWind;
    private String cityPressure;
    private Date date = new Date();
    private SimpleDateFormat format1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        btnNext.setOnClickListener(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            cityName = getIntent().getStringExtra(NAME_CITY);
            cityWind = getIntent().getStringExtra(WIND_CITY);
            cityPressure = getIntent().getStringExtra(PRESSURE_CITY);
            tvСity.setText(String.valueOf(cityName));
        }
        format1 = new SimpleDateFormat("dd.MM.yyyy");
        tvDates.setText(String.valueOf(format1.format(date)));

        if (cityWind.compareToIgnoreCase("True") == 0) {
            ViewGroup elements2 = findViewById(R.id.layout);
            TextView textViewManual = new TextView(this);
            int colorAccent = ContextCompat.getColor(this, R.color.colorText);
            textViewManual.setTextColor(colorAccent);
            textViewManual.setText("Ветер 5 м/с");
            textViewManual.setTextSize(30);
            textViewManual.setGravity(Gravity.CENTER_HORIZONTAL);
            elements2.addView(textViewManual);

        }
        if (cityPressure.compareToIgnoreCase("True") == 0) {
            ViewGroup elements2 = findViewById(R.id.layout);
            TextView textViewManual = new TextView(this);
            int colorAccent = ContextCompat.getColor(this, R.color.colorText);
            textViewManual.setTextColor(colorAccent);
            textViewManual.setText("Давление 750 мм рт.ст.");
            textViewManual.setTextSize(30);
            textViewManual.setGravity(Gravity.CENTER_HORIZONTAL);
            elements2.addView(textViewManual);

        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_button) {
            Intent nextActivity = new Intent(this, WeatherHistoryActivity.class);
            startActivity(nextActivity);
        }
    }

    private void initViews() {
        tvСity = findViewById(R.id.text_city);
        tvDates = findViewById(R.id.text_data);
        btnNext = findViewById(R.id.next_button);
    }
}
