package com.example.weatherapp.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.model.CityIndex;

public class WeatherFragment extends Fragment {
    public static final String PARCEL = "parcel";
    private static String TAG = "WeatherFragment";
    private ImageView weather;
    private TextView cityNameView;
    private TypedArray weatherImgs;

    private int defaultIndex = 0;
    public static WeatherFragment createInstance(CityIndex parcel) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, " - onCreateView()");
        return inflater.inflate(R.layout.weather_list, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView() == null) {
            return;
        }

        weather = getView().findViewById(R.id.iv_coat_weather);
        cityNameView = getView().findViewById(R.id.tv_chosen_city);
        weatherImgs = getResources().obtainTypedArray(R.array.weather_list);

        CityIndex parcel = getParcel();
        if (parcel != null) {
            weather.setImageResource(weatherImgs.getResourceId(parcel.getIndex(), defaultIndex));
            cityNameView.setText(parcel.getCityName());
        } else {
            weather.setImageResource(weatherImgs.getResourceId(defaultIndex, defaultIndex));
            cityNameView.setText(getResources().getTextArray(R.array.cities_list)[defaultIndex].toString());
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, " - onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, " - onCreate()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, " - onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, " - onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, " - onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, " - onPause()");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, " - onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, " - onDestroyView()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, " - onDetach()");
    }

    @Nullable
    protected CityIndex getParcel() {
        CityIndex parcel = null;
        if (getArguments() != null) {
            parcel = (CityIndex) getArguments().getSerializable(PARCEL);
        }
        return parcel;
    }
}
