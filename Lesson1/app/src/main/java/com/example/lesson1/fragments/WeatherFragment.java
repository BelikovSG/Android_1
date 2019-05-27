package com.example.lesson1.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lesson1.R;
import com.example.lesson1.model.CityIndex;

public class WeatherFragment extends Fragment {
    public static final String PARCEL = "parcel";

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
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView() == null) {
            return;
        }

        weather = getView().findViewById(R.id.iv_coat_of_arms_view);
        cityNameView = getView().findViewById(R.id.tv_chosen_city);

        weatherImgs = getResources().obtainTypedArray(R.array.coat_of_arms_list);

        CityIndex parcel = getParcel();
        if (parcel != null) {
            weather.setImageResource(weatherImgs.getResourceId(parcel.getIndex(), defaultIndex));
            cityNameView.setText(parcel.getCityName());
        } else {
            weather.setImageResource(weatherImgs.getResourceId(defaultIndex, defaultIndex));
            cityNameView.setText(getResources().getTextArray(R.array.cities_list)[defaultIndex].toString());
        }
    }

    public @Nullable CityIndex getParcel() {
        CityIndex parcel = null;
        if (getArguments() != null) {
            parcel = (CityIndex) getArguments().getSerializable(PARCEL);
        }
        return parcel;
    }
}
