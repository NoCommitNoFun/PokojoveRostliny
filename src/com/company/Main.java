package com.company;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        PlantsManager allPlants = new PlantsManager();
        Plants kvetinka1 = new Plants("Masozrava");
        Plants kvetinka2 = new Plants("Ruza", LocalDate.of(2022,2,22),20);
        allPlants.addPlant(kvetinka1);
        allPlants.addPlant(kvetinka2);
        allPlants.plantOnPosition(0);
        allPlants.plantOnPosition(1);
        allPlants.plantOnPosition(2);
        allPlants.writeAllPlants();
        allPlants.removedPlant(2);
        allPlants.removedPlant(1);
        allPlants.writeAllPlants();
    }
}
