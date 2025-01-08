package com.example.exam090921.holders;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam090921.R;

public class TownViewHolder extends RecyclerView.ViewHolder{

    private TextView name, temperature;
    private Button buttonDelete;

    public TownViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.textViewName);
        temperature = itemView.findViewById(R.id.textViewTemp);
        buttonDelete = itemView.findViewById(R.id.buttonDelete);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setTemperature(String temperature) {
        this.temperature.setText(temperature);
    }

    public void setButtonOnClickListener(View.OnClickListener listener){
        this.buttonDelete.setOnClickListener(listener);
    }

    public void setOnClickListener(int temperature){
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temperature>=10 && temperature<=15){
                    Toast.makeText(TownViewHolder.this.itemView.getContext(),"Chilly weather", Toast.LENGTH_SHORT).show();
                }else if(temperature>=16 && temperature<=20){
                    Toast.makeText(TownViewHolder.this.itemView.getContext(),"Warm weather", Toast.LENGTH_SHORT).show();
                }else if(temperature>=21 && temperature<=30){
                    Toast.makeText(TownViewHolder.this.itemView.getContext(),"Hot weather", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
