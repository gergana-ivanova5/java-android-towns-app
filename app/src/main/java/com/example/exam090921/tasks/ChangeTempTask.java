package com.example.exam090921.tasks;

import android.os.Handler;
import android.os.HandlerThread;

import com.example.exam090921.listeners.OnTempChangedListener;
import com.example.exam090921.models.Town;

import java.util.List;
import java.util.Random;

public class ChangeTempTask implements Runnable{

    private HandlerThread thread;
    private Handler handler;
    private OnTempChangedListener listener;
    private List<Town> list;

    public ChangeTempTask(OnTempChangedListener listener, List<Town> list) {
        this.listener = listener;
        this.list = list;
        thread = new HandlerThread("Add");
        thread.start();
        handler = new Handler(thread.getLooper());
    }

    @Override
    public void run() {
        Random rand = new Random();
        int newTemp = rand.nextInt(21)+10;

        for (Town t: list) {
            t.setTemperature(newTemp);
            listener.onTempChanged(t);
        }
        handler.postDelayed(this::run,300);
    }
}
