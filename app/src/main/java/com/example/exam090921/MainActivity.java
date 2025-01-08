package com.example.exam090921;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.exam090921.adapters.TownAdapter;
import com.example.exam090921.data.StorageData;
import com.example.exam090921.fragments.TownFragment;
import com.example.exam090921.listeners.OnTempChangedListener;
import com.example.exam090921.listeners.OnTownAddListener;
import com.example.exam090921.models.Town;
import com.example.exam090921.tasks.ChangeTempTask;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements OnTownAddListener, OnTempChangedListener {

    private RecyclerView recyclerView;
    private FloatingActionButton buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        buttonMain = findViewById(R.id.buttonMain);

        TownAdapter adapter = new TownAdapter(StorageData.generateTowns(10));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Town newTown = new Town("NewTown", 0);
                TownFragment fragment = TownFragment.newInstance(newTown);
                fragment.show(getSupportFragmentManager(), "Add");
            }
        });

        new Thread(new ChangeTempTask(MainActivity.this, adapter.getItems())).start();
    }



    @Override
    public void onTownAdd(Town town) {
        if(recyclerView!=null){
            TownAdapter adapter = (TownAdapter) recyclerView.getAdapter();
            adapter.add(town);
        }
    }

    @Override
    public void onTempChanged(Town town) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TownAdapter adapter = (TownAdapter) recyclerView.getAdapter();
                adapter.editTown(town);
            }
        });
     }

}