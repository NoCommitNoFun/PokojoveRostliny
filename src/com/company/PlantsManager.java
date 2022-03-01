package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public void readFromFile(){
        //TODO
    }

    public void saveToFile(){
        //TODO
    }
}
