package com.company;

import java.util.ArrayList;

public class Zoo {

    private String animalID;
    private ArrayList<Animal> myAnimals;

    public Zoo(String animalID){
        this.animalID = animalID;
        this.myAnimals = new ArrayList<Animal>();
    }

    public boolean addNewAnimal(Animal animal){

        if(findAnimal(animal.getName()) >= 0){
            System.out.println("Animal is in the zoo already!");
            return false;
        }
        myAnimals.add(animal);
        return true;
    }

    public boolean updateAnimal(Animal prevAnimal, Animal newAnimal){
        int foundIndex = findAnimal(prevAnimal);
        if(foundIndex < 0){
            System.out.println(prevAnimal.getName() + ", was not found.");
            return false;
        }

        this.myAnimals.set(foundIndex, newAnimal);
        System.out.println(prevAnimal.getName() + ", was replaced with " + newAnimal.getName());
        return true;
    }

    public boolean removeAnimal(Animal animal){
        int foundIndex = findAnimal(animal);
        if(foundIndex < 0){
            System.out.println(animal.getName() + ", was not found.");
            return false;
        }
        this.myAnimals.remove(foundIndex);
        System.out.println(animal.getName() + ", was removed!");
        return true;
    }

    private int findAnimal(Animal animal){
        return this.myAnimals.indexOf(animal);
    }

    // lets overload!
    private int findAnimal(String animalName){
        for(int i = 0; i < this.myAnimals.size(); i++){
            Animal animal = this.myAnimals.get(i);
            if(animal.getName().equals(animalName)){
                return i;
            }
        }
        return -1; // if animal not found
    }

    public String searchAnimal(Animal animal){
        if(findAnimal(animal) >= 0){
            return animal.getName();
        }
        return null;
    }

    public Animal searchAnimal(String name){
        int index = findAnimal(name);
        if(index >= 0){
            return this.myAnimals.get(index);
        }
        return null;
    }

    public void printAnimals(){
        System.out.println("Here are the animals in the zoo currently: ");
        System.out.println("-----------------------------------------");
        System.out.println("NAME            |               ID");
        System.out.println("-----------------------------------------");
        for(int i = 0; i < this.myAnimals.size(); i++){
            System.out.println((i+1) + "." +
                        this.myAnimals.get(i).getName() + " ------------> " +
                        this.myAnimals.get(i).getAnimalID());
        }
    }

}
