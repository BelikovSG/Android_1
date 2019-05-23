package com.example.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.text.SimpleDateFormat;

import static com.example.lesson1.MainActivity.NAME_CITY;


public class SecondActivity extends AppCompatActivity {
    private TextView City;
    private TextView Datas;
    private String CityName;
    private Date date = new Date();
    private SimpleDateFormat format1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            CityName = getIntent().getStringExtra(NAME_CITY);
            City.setText(String.valueOf(CityName));
        }

        format1 = new SimpleDateFormat(
                "dd.MM.yyyy");
        Datas.setText(String.valueOf(format1.format(date)));


    }

    private void initViews() {
       City = findViewById(R.id.text_city);
        Datas=findViewById(R.id.text_data);

            }
}
