package com.example.currencyconverter;

public class Rate {
    //Attributes
    public String name;
    public double spotRate;

    //Getters and setters

    public String getName() {
        return name;
    }
    public double getSpotRate() {
        return spotRate;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSpotRate(double spotRate) {
        this.spotRate = spotRate;
    }

    //Constructor
    public Rate(String name, double spotRate) {
        this.name = name;
        this.spotRate = spotRate;
    }
    public String ToString(){
        return "Name" + this.name+" "+ "Spotrate" +this.spotRate;
    }
}
