package com.harsh.countryapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.harsh.countryapp.databinding.ItemPostListBinding;
import com.harsh.countryapp.model.Country;


public class CountryRecyclerAdapter extends ListAdapter<Country, CountryRecyclerAdapter.ViewHolder> {

    public CountryRecyclerAdapter() {
        super(Country.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostListBinding binding = ItemPostListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemPostListBinding binding;

        public ViewHolder(@NonNull ItemPostListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(Country item) {
            binding.userid.setText("Country:" + item.getName());
            binding.id.setText("Capital:" + item.getCapital());
            // binding.title.setText("Region:"+item.getRegion());
            binding.body.setText("Population:" + item.getPopulation());
            binding.title.setText("Region:" + item.getCurrencies().get(0).getName());

        }
    }
}
