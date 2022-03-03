package com.company;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static final String INPUT_FILENAME = "C:\\Users\\admin\\IdeaProjects\\PokojoveRostliny\\pokojoveRostliny.txt";
    public static final String OUTPUT_FILENAME = "C:\\Users\\admin\\IdeaProjects\\PokojoveRostliny\\vystup.txt";
    public static final String DELIMITER = "\t";

    public static void main(String[] args) throws FileNotFoundException {
        PlantsManager allPlants = new PlantsManager();

        //Praca zo súborom
        allPlants.readFromFile(INPUT_FILENAME,DELIMITER);
        allPlants.writeAllPlants();
        System.out.println("Moje kvetinky");
        Plants kvetinka1 = new Plants("Masozrava");
        Plants kvetinka2 = new Plants("Ruza", LocalDate.of(2022,2,22),20);
        Plants kvetinka3 = new Plants("Tulipan","♥", LocalDate.of(2021,5,22),LocalDate.of(2022,2,28),25);
        allPlants.addPlant(kvetinka1);
        allPlants.addPlant(kvetinka2);
        allPlants.addPlant(kvetinka3);

        allPlants.writeAllPlants();

        allPlants.plantOnPosition(0);
        allPlants.plantOnPosition(1);
        allPlants.plantOnPosition(2);
        //allPlants.writeAllPlants();

        allPlants.removedPlant(1);

        allPlants.saveToFile(OUTPUT_FILENAME,DELIMITER);
        // 16. Vyzkoušejte opětovné načtení vygenerovaného souboru.
        allPlants.readFromFile(OUTPUT_FILENAME,DELIMITER);
        allPlants.writeAllPlants();


    }
}
