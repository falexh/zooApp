package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Zoo zoo = new Zoo("800");

    public static void main(String[] args) {
	// write your code here
        boolean flag = false;

        zooTitle();
        printChoices();

        while(!flag){
            System.out.println("\n Enter a choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    System.out.println("\n Quitting Program...");
                    flag = true;
                    break;
                case 1:
                    zoo.printAnimals();
                    break;
                case 2:
                    addNewAnimal();
                    break;
                case 3:
                    updateAnimal();
                    break;
                case 4:
                    removeAnimal();
                    break;
                case 5:
                    searchAnimal();
                    break;
                case 6:
                    printChoices();
                    break;
            }
        }
    }

    private static void addNewAnimal(){
        System.out.println("Enter a new animal name: ");
        String name = scanner.nextLine();
        System.out.println("Enter animal ID: ");
        String animalID = scanner.nextLine();

        Animal newAnimal = Animal.createAnimal(name, animalID);

        if(zoo.addNewAnimal(newAnimal)){
            System.out.println("New animal added: name = " + name + ", ID = " + animalID);
        }else{
            System.out.println("Cannot add! " + name + " already on file! " );
        }
    }

    private static void updateAnimal(){
        System.out.println("Enter existing animal name: ");
        String name = scanner.nextLine();
        Animal existingAnimal = zoo.searchAnimal(name);

        if(existingAnimal == null){
            System.out.println("Animal not found!");
            return;
        }

        System.out.print("Enter new animal name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter a new animal ID: ");
        String newAnimalID = scanner.nextLine();
        Animal newAnimal = Animal.createAnimal(newName, newAnimalID);

        if(zoo.updateAnimal(existingAnimal, newAnimal)){
            System.out.println("Animal successfully updated!");
        }else{
            System.out.println("Error updating!");
        }
    }

    private static void removeAnimal(){
        System.out.println("Enter existing animal name: ");
        String name = scanner.nextLine();
        Animal existingAnimal = zoo.searchAnimal(name);

        if(existingAnimal == null){
            System.out.println("Animal not found!");
            return;
        }

        if(zoo.removeAnimal(existingAnimal)){
            System.out.println("Animal deleted!");
        }else{
            System.out.println("Error deleting animal!");
        }
    }

    private static void searchAnimal(){
        System.out.println("Enter existing animal name: ");
        String name = scanner.nextLine();
        Animal existingAnimal = zoo.searchAnimal(name);

        if(existingAnimal == null){
            System.out.println("Animal not found!");
            return;
        }

        System.out.println("Animal name: " + existingAnimal.getName() + " ID is " + existingAnimal.getAnimalID());
    }

    private static void printChoices(){
        System.out.println("\n Choices: \n");
        System.out.println("0 - to shutdown\n" +
                "1 - to print animals\n" +
                "2 - to add a new animal\n" +
                "3 - to update an existing animal\n" +
                "4 - to remove an existing animal\n" +
                "5 - search for an existing animal\n" +
                "6 - print the choices again!");
        System.out.println("Choose your action: ");
    }

    private static void zooTitle(){
        System.out.println("\n ________ Welcome to the Zoo! _________");
    }
}
