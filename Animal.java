package com.company;

public class Animal {

    private String name;
    private String animalID;

    public Animal(String name, String animalID){
        this.name = name;
        this.animalID = animalID;
    }

    public String getName(){
        return name;
    }

    public String getAnimalID(){
        return animalID;
    }

    //create animal without making instantiation within main
    public static Animal createAnimal(String name, String animalID){
        return new Animal(name, animalID);
    }

}
