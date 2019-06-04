package com.example.lesson1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.lesson1.MainActivity.NAME_CITY;


public class SecondActivity extends AppCompatActivity {
    private TextView city;
    private TextView datas;
    private String cityName;
    private Date date = new Date();
    private SimpleDateFormat format1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.MyTheme);
        setContentView(R.layout.activity_second);
        initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            cityName = getIntent().getStringExtra(NAME_CITY);
            city.setText(String.valueOf(cityName));
        }
        format1 = new SimpleDateFormat("dd.MM.yyyy");
        datas.setText(String.valueOf(format1.format(date)));
    }

    private void initViews() {
        city = findViewById(R.id.text_city);
        datas = findViewById(R.id.text_data);
    }
}
