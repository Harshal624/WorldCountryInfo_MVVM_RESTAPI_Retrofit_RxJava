package com.harsh.countryapp.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {
    public static final DiffUtil.ItemCallback<Country> DIFF_CALLBACK = new DiffUtil.ItemCallback<Country>() {
        @Override
        public boolean areItemsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return (oldItem.name.equals(newItem.name) && oldItem.population == newItem.population);
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return oldItem.equals(newItem);
        }
    };
    @Expose
    private String name;
    @Expose
    private String capital;
    @Expose
    private long population;
    @Expose
    private String region;
    @Expose
    private List<Currency> currencies;
    @SerializedName("latlng")
    @Expose
    private List<Double> latlng;

    public Country(String name, String capital, long population, String region, List<Currency> currencies, List<Double> latlng) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.region = region;
        this.currencies = currencies;
        this.latlng = latlng;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    /*
    public Country(String name, String capital, long population, String region, List<Currency> currencies) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.region = region;
        this.currencies = currencies;
    }*/

    public List<Double> getLatlng() {
        return latlng;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

}
