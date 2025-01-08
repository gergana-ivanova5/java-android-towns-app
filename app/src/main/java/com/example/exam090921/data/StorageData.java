package com.example.exam090921.data;

import com.example.exam090921.models.Town;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StorageData {

    public static List<Town> generateTowns(int count){

        List<Town> townList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            townList.add(generateTown("TownName"+i));
        }
        return townList;
    }

    public static Town generateTown(String s) {
        Random rand = new Random();
        int temperature = rand.nextInt(21)+10;

        return new Town(s, temperature);
    }
}
