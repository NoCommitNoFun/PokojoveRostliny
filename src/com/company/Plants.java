package com.company;

import java.time.LocalDate;

public class Plants {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }
    //jeden pro nastavení všech atributů
    public Plants(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }
    //druhý nastaví jako poznámku prázdný řetězec a datum poslední zálivky nastaví na dnešní datum.
    public Plants(String name, LocalDate planted, int frequencyOfWatering) {
        this.name = name;
        this.notes = "";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }
    //třetí nastaví totéž co druhý a navíc výchozí frekvenci zálivky na 7 dnů a datum zasazení na dnešní datum. (Uživatel tedy bude zadávat pouze název rostliny.)
    public Plants(String name) {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }


    @Override
    public String toString() {
        return "Plants{" +
                "name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", planted=" + planted +
                ", watering=" + watering +
                ", frequencyOfWatering=" + frequencyOfWatering +
                '}';
    }

    public String getWateringInfo(){
        return "Plant name: " + name + ", date of last watering: " + watering + ", date of next watering" + watering.plusDays(frequencyOfWatering);
    }

    private String name;
    String notes;
    LocalDate planted;
    LocalDate watering;
    int frequencyOfWatering;
}
