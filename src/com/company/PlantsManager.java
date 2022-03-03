package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantsManager {
    private List<Plants> plantsList = new ArrayList<>();

    public void addPlant(Plants newPlant){
        if(!newPlant.getPlanted().isAfter(LocalDate.now()) && !newPlant.getWatering().isAfter(LocalDate.now()) && newPlant.getFrequencyOfWatering()>0){
            plantsList.add(newPlant);
        }
        else{
            System.out.println("Plan can be added to list of plants, some parameters is wrong");
//            System.out.println(newPlant.getPlanted());
//            System.out.println(newPlant.getWatering());
//            System.out.println(newPlant.getFrequencyOfWatering());
            //TODO switch on write wrong parameters
        }

    }
    public void plantOnPosition(int position){
        try {
            System.out.println(plantsList.get(position));
        }
        catch (java.lang.RuntimeException e){
            System.out.println("Plant on position " + position + " not exist");
        }

    }

    public void removedPlant(int position){
        try {
            System.out.println("Plant " + plantsList.get(position).getName()+ " on position "+position+" was removed.");
            plantsList.remove(position);
        }
        catch (java.lang.RuntimeException e){
            System.out.println("The plant at position " + position + " cannot be removed because it does not exist.");
        }
    }

    public void writeAllPlants() {
        System.out.println("-----List of all plants: -----");
        for (int i = 0; i < plantsList.size(); i++) {
            System.out.println(plantsList.get(i));
        }
    }
    public void readFromFile(String filename, String delimiter){

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));

            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                String[] parts = inputLine.split(delimiter);
                // System.out.println(Arrays.toString(parts));

                // puts values from file into variables
                String name = String.valueOf(parts[0]); //String notes = parts[1];
                String notes = String.valueOf(parts[1]);
                int frequencyOfWatering = Integer.valueOf(parts[2]);
                LocalDate watering = LocalDate.parse(parts[3]);
                LocalDate planted = LocalDate.parse(parts[4]);
                // add to list
                addPlant(new Plants(name, notes,planted,watering,frequencyOfWatering));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The file was not loaded!");
        }

    }

    public void saveToFile(String outputFilename, String delimiter){
        try(PrintWriter writer =
                    new PrintWriter(new FileWriter(outputFilename))
        ) {
            for (Plants plants : plantsList) {
                String outputLine = plants.getName()+delimiter;
                outputLine += plants.getNotes()+delimiter;
                outputLine += plants.getFrequencyOfWatering()+delimiter;
                outputLine += plants.getWatering().toString()+delimiter;
                outputLine += plants.getPlanted().toString();
                writer.println(outputLine);
            }
            System.out.println("Save successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
