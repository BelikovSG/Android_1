package com.example.lesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private EditText etEnteredCity;
    private Button ChoiceCity;

    private String CityName;
    public static final String NAME_CITY = "NAME_CITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        ChoiceCity.setOnClickListener(this);

    }
    private void initViews() {
       ChoiceCity = findViewById(R.id.CityButton);
        etEnteredCity=findViewById(R.id.CityEdit);


    }
    @Override
    public void onClick(View v) {
      switch (v.getId()) {
            case R.id.CityButton:
                Intent nextActivity = new Intent(this, SecondActivity.class);
                nextActivity.putExtra(NAME_CITY, String.valueOf(etEnteredCity.getText()));
                startActivity(nextActivity);
                break;


        }
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
          super.onSaveInstanceState(outState);
          outState.putString(NAME_CITY, String.valueOf(etEnteredCity.getText()));
        }
        @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
         super.onRestoreInstanceState(savedInstanceState);
            CityName = savedInstanceState.getString(NAME_CITY);
            etEnteredCity.setText(String.valueOf(CityName));
        }


}
