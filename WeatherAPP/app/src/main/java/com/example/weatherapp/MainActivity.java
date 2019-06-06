package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import static com.example.weatherapp.fragments.WeatherFragment.CITY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String NAME_CITY = "NAME_CITY";
    public static final String WIND_CITY = "WIND_CITY";
    public static final String PRESSURE_CITY = "PRESSURE_CITY";
    private EditText etEnteredCity;
    private CheckBox wind;
    private CheckBox pressure;
    private Button choiceCity;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        choiceCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cityButton) {
            Intent nextActivity = new Intent(this, SecondActivity.class);
            String cityName = String.valueOf(etEnteredCity.getText());

            if (cityName.compareToIgnoreCase("city") == 0 ||
                    cityName.compareToIgnoreCase("город") == 0) {
                nextActivity.putExtra(NAME_CITY, String.valueOf(CITY));
            } else {
                nextActivity.putExtra(NAME_CITY, cityName);
            }
            String choiceWind = "False";
            if (wind.isChecked()) {
                choiceWind = "True";
            }
            nextActivity.putExtra(WIND_CITY, choiceWind);

            String choicePressure = "False";
            if (pressure.isChecked()) {
                choicePressure = "True";
            }
            nextActivity.putExtra(PRESSURE_CITY, choicePressure);
            startActivity(nextActivity);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NAME_CITY, String.valueOf(etEnteredCity.getText()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cityName = savedInstanceState.getString(NAME_CITY);
        etEnteredCity.setText(String.valueOf(cityName));
    }

    private void initViews() {
        choiceCity = findViewById(R.id.cityButton);
        etEnteredCity = findViewById(R.id.CityEdit);
        wind = findViewById(R.id.wind);
        pressure = findViewById(R.id.pressure);
    }
}
