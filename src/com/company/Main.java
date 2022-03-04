package com.company;

import java.time.LocalDate;

public class Main {

    public static final String INPUT_FILENAME = "C:\\Users\\admin\\IdeaProjects\\PokojoveRostliny\\pokojoveRostliny.txt";
    public static final String OUTPUT_FILENAME = "C:\\Users\\admin\\IdeaProjects\\PokojoveRostliny\\vystup.txt";
    public static final String INPUT_FILENAME_WRONG_DATE = "C:\\Users\\admin\\IdeaProjects\\PokojoveRostliny\\kvetiny-spatne-datum.txt";
    public static final String INPUT_FILENAME_WRONG_FREKVENCE = "C:\\Users\\admin\\IdeaProjects\\PokojoveRostliny\\kvetiny-spatne-frekvence.txt";
    public static final String DELIMITER = "\t";

    public static void main(String[] args) {
        PlantsManager allPlants = new PlantsManager();

        //2. Vytvořte tři konstruktory
        Plants kvetinka1 = new Plants("Masozrava");
        Plants kvetinka2 = new Plants("Ruza", LocalDate.of(2022, 2, 22), 20);
        Plants kvetinka3 = new Plants("Tulipan", "♥", LocalDate.of(2021, 5, 22), LocalDate.of(2022, 2, 28), 25);

        // System.out.println("4. Připravte metodu getWateringInfo(), která vrátí název květiny, datum poslední zálivky a datum doporučené další zálivky. (Metoda vrátí textový řetězec, obsahující požadované informace.)");
        // System.out.println(kvetinka1.getWateringInfo());

        //Ošetrní vstupu:
        // Plants zla4 = new Plants("Tulipan", "♥", LocalDate.of(2025, 5, 22), LocalDate.of(2025, 2, 28), 0);
        //allPlants.addPlant(zla4);


        //9. Přidejte metody pro přidání nové květiny, získání květiny na zadaném pořadí a odebrání květiny ze seznamu.
        allPlants.addPlant(kvetinka3);
        //získání květiny na zadaném pořadí
        allPlants.plantOnPosition(0);
        //11. Přidejte do seznamu květin metodu pro uložení aktualizovaného seznamu do souboru.
        allPlants.saveToFile(INPUT_FILENAME, DELIMITER);
        //12. Načtěte seznam květin ze souboru kvetiny.txt.
        allPlants.readFromFile(INPUT_FILENAME, DELIMITER);
        //13. Vypište na obrazovku informace o zálivce pro všechny květiny.
        allPlants.writeWateringInfoForAllPlants();
        //14. Přidejte dvě nové květiny do seznamu. Jednu květinu odeberte.
        allPlants.addPlant(kvetinka1);
        allPlants.addPlant(kvetinka2);
        //odebrání květiny ze seznamu
        allPlants.removedPlant(1);
        //15. Uložte seznam květin do nového souboru a ověřte, že je jeho obsah správný. Výsledný soubor by měl vypadat takto: vystup.txt.
        allPlants.saveToFile(OUTPUT_FILENAME, DELIMITER);
        // 16. Vyzkoušejte opětovné načtení vygenerovaného souboru.
        allPlants.readFromFile(OUTPUT_FILENAME, DELIMITER);
        // 17. Vyzkoušejte, že se aplikace bude chovat správně při načtení vadného souboru kvetiny-spatne-datum.txt.
        allPlants.readFromFile(INPUT_FILENAME_WRONG_DATE, DELIMITER);
        // 18. Vyzkoušejte, že se aplikace bude chovat správně při načtení vadného souboru kvetiny-spatne-frekvence.txt.
        allPlants.readFromFile(INPUT_FILENAME_WRONG_FREKVENCE, DELIMITER);
        allPlants.writeAllPlants();


    }
}
