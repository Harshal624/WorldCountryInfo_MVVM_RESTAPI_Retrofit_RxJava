package com.harsh.countryapp.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;

import com.harsh.countryapp.model.Country;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class CountryRepo {
    private static final String TAG = "CountryRepo";
    private static CountryRepo instance;
    private MutableLiveData<List<Country>> countryListMutableLiveData = new MutableLiveData<>();


    public static synchronized CountryRepo getInstance() {
        if (instance == null)
            instance = new CountryRepo();
        return instance;
    }


    public LiveData<List<Country>> makeReactiveQuery() {
        return LiveDataReactiveStreams.fromPublisher(ServiceGenerator.getRequestApi()
                .getAllCountries()
                .subscribeOn(Schedulers.io()));
    }
}
