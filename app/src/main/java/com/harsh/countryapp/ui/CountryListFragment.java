package com.harsh.countryapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.harsh.countryapp.databinding.FragmentCountryListBinding;
import com.harsh.countryapp.model.Country;
import com.harsh.countryapp.ui.adapter.CountryRecyclerAdapter;
import com.harsh.countryapp.viewmodel.CountryListViewModel;

import java.util.List;

public class CountryListFragment extends Fragment {
    private static final String TAG = "CountryListFragment";
    FragmentCountryListBinding binding;
    CountryListViewModel viewModel;
    CountryRecyclerAdapter adapter;
    int list_type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).toolbar.setTitle("Country List");
        viewModel =
                new ViewModelProvider(requireActivity()).get(CountryListViewModel.class);
        binding = FragmentCountryListBinding.inflate(inflater, container, false);
        adapter = new CountryRecyclerAdapter();
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setAdapter(adapter);
        list_type = getArguments().getInt("list_type");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switch (list_type) {
            case 1:
                showAllCountries();
                break;
            default:
                break;
        }
    }

    private void showAllCountries() {
        viewModel.makeQuery().observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                adapter.submitList(countries);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}