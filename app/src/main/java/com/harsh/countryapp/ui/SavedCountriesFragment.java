package com.harsh.countryapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.harsh.countryapp.R;

public class SavedCountriesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).toolbar.setTitle("Saved Countries");
        return inflater.inflate(R.layout.fragment_savedcountries, container, false);
    }
}