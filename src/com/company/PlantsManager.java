package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantsManager {
    private final List<Plants> plantsList = new ArrayList<>();

    public void addPlant(Plants newPlant) {
        if (!newPlant.getPlanted().isAfter(LocalDate.now()) && !newPlant.getWatering().isAfter(LocalDate.now()) && newPlant.getFrequencyOfWatering() > 0) {
            plantsList.add(newPlant);
        } else {
            System.out.println(" - Plan can be added to list of plants, some parameters is wrong:");
            if (newPlant.getPlanted().isAfter(LocalDate.now())) {
                System.out.println(" - The plant cannot be planted in the future.");
            }
            if (newPlant.getWatering().isAfter(LocalDate.now())) {
                System.out.println(" - The plant cannot be watering in the future.");
            }
            if (newPlant.getFrequencyOfWatering() <= 0) {
                System.out.println(" - Watering value cannot be less than zero inclusive.");
            }
        }

    }

    public void plantOnPosition(int position) {
        try {
            System.out.println(plantsList.get(position));
        } catch (java.lang.RuntimeException e) {
            System.out.println("Plant on position " + position + " not exist");
        }

    }

    public void removedPlant(int position) {
        try {
            System.out.println("Plant " + plantsList.get(position).getName() + " on position " + position + " was removed.");
            plantsList.remove(position);
        } catch (java.lang.RuntimeException e) {
            System.out.println("The plant at position " + position + " cannot be removed because it does not exist.");
        }
    }

    public void writeAllPlants() {
        System.out.println("-----List of all plants: -----");
        for (Plants plants : plantsList) {
            System.out.println(plants);
        }
    }

    public void writeWateringInfoForAllPlants() {
        for (Plants plants : plantsList) {
            System.out.println(plants.getWateringInfo());
        }
    }

    public void readFromFile(String filename, String delimiter) {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
            int counter = 0;
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                String[] parts = inputLine.split(delimiter);
                counter++;
                // System.out.println(Arrays.toString(parts));
                // puts values from file into variables
                try {
                    String name = String.valueOf(parts[0]); //String notes = parts[1];
                    String notes = String.valueOf(parts[1]);
                    //int frequencyOfWatering = wateringFormater(String.valueOf(parts[2]));
                    int frequencyOfWatering = Integer.parseInt(parts[2]);
                    LocalDate watering = dateFormater(String.valueOf(parts[3]));
                    LocalDate planted = dateFormater(String.valueOf(parts[4]));
                    // add to list
                    addPlant(new Plants(name, notes, planted, watering, frequencyOfWatering));

                } catch (java.lang.RuntimeException e) {
                    System.out.println("From file " + filename + " cannot read line " + counter);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The file was not loaded!");
        }

    }

    public void saveToFile(String outputFilename, String delimiter) {
        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(outputFilename))
        ) {
            for (Plants plants : plantsList) {
                String outputLine = plants.getName() + delimiter;
                outputLine += plants.getNotes() + delimiter;
                outputLine += plants.getFrequencyOfWatering() + delimiter;
                outputLine += plants.getWatering().toString() + delimiter;
                outputLine += plants.getPlanted().toString();
                writer.println(outputLine);
            }
            System.out.println("Save successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LocalDate dateFormater(String date) {
        date = date.replaceAll("\\D+", "-");
        return LocalDate.parse(date);
    }

    private int wateringFormater(String watering) {//nevedel som ako upraviť 36ř na 365 napadol ma switch ale na každý znak by to bolo extrémne dlhé za mňa by to bolo lepšie nechať vyhorieť na RuntimeException
        watering = watering.replaceAll("\\D+", "");
        return Integer.parseInt(watering);
    }

}
