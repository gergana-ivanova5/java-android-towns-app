package com.example.exam090921.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam090921.R;
import com.example.exam090921.holders.TownViewHolder;
import com.example.exam090921.models.Town;

import java.util.List;

public class TownAdapter extends RecyclerView.Adapter<TownViewHolder> {

    private List<Town> townList;

    public TownAdapter(List<Town> townList) {
        this.townList = townList;
    }

    @NonNull
    @Override
    public TownViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new TownViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TownViewHolder holder, int position) {
        Town town = townList.get(position);

        holder.setName(town.getName());
        holder.setTemperature(String.valueOf(town.getTemperature())+"C");
        holder.setButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(town);
            }
        });

        holder.setOnClickListener(town.getTemperature());
    }

    private void delete(Town town) {

        if(townList.size()>0){
            int position = townList.indexOf(town);
            townList.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public int getItemCount() {
        return townList.size();
    }

    public void add(Town town) {
        townList.add(0, town);
        notifyItemInserted(0);
    }

    public List<Town> getItems(){
        return townList;
    }



    public void editTown(Town town) {
        if(townList.size()>0){
            int position = townList.indexOf(town);
            notifyItemChanged(position);
        }
    }

    public Town getItemAt(int position) {
        return townList.get(position);
    }
}
