package com.example.lesson1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.lesson1.fragments.WeatherFragment;
import com.example.lesson1.model.CityIndex;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static com.example.lesson1.fragments.WeatherFragment.PARCEL;

public class WeatherActivity extends AppCompatActivity {
    public static Intent start(@NonNull Context context, @NonNull CityIndex parcel) {
        Intent intent = new Intent(context, WeatherActivity.class);
        intent.putExtra(PARCEL, parcel);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            WeatherFragment coatOfArmsFragment = new WeatherFragment();
            coatOfArmsFragment.setArguments(getIntent().getExtras());

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.placeholder_coat_of_arms, coatOfArmsFragment)
                    .commit();
        }
    }
}
