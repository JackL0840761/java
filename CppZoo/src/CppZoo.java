
import static java.lang.System.out;

import java.io.*;
import java.util.Scanner;

public class CppZoo
{

    static void getName(){

        try{
            File namefile =new File("C:\\javainstall\\javafiles\\CppZoo\\animalNames.txt");
            Scanner sc= new Scanner(namefile);

            while(sc.hasNextLine()){
                String animalName = sc.nextLine();
                String[] nameArr = animalName.split(",",16);
                for(String temp:nameArr){
                    out.println(temp);
                }
                out.println(animalName.equals(nameArr[0]));
            }

            sc.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //an array that display the age,sex,species,color and weight of the animal from arriving animal txt
    static void arrivingAnimalsArray(){
        int lineCount = 0;
        try{
            File animalfile = new File("C:\\javainstall\\javafiles\\CppZoo\\arrivingAnimals.txt");
            BufferedReader br = new BufferedReader(new FileReader(animalfile));
            Scanner sc2 = new Scanner(animalfile);
            lineCount = 1;
            while (sc2.hasNextLine()) {
                String animals = sc2.nextLine();

                out.println(animals);
                lineCount++;
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //a method that is used to find out what is the estimate birthday of the animal
    static void calculateBirthday(){

    }

    public static void main(String[]args){
        getName();
    }
}