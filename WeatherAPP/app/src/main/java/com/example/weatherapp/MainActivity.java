package com.example.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String NAME_CITY = "NAME_CITY";
    private EditText etEnteredCity;
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
        if (v.getId() == R.id.CityButton) {
            Intent nextActivity = new Intent(this, SecondActivity.class);
            nextActivity.putExtra(NAME_CITY, String.valueOf(etEnteredCity.getText()));
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
        choiceCity = findViewById(R.id.CityButton);
        etEnteredCity = findViewById(R.id.CityEdit);
    }
}
