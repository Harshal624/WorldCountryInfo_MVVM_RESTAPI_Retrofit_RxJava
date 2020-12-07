package com.harsh.countryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.harsh.countryapp.model.Country;
import com.harsh.countryapp.repo.CountryRepo;

import java.util.List;

public class CountryListViewModel extends ViewModel {

    private CountryRepo repository;
    private LiveData<List<Country>> listLiveData;

    public CountryListViewModel() {
        repository = CountryRepo.getInstance();
        if (listLiveData == null)
            listLiveData = repository.makeReactiveQuery();
    }

    public LiveData<List<Country>> makeQuery() {
        return listLiveData;
    }
}