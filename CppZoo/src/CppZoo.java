import java.io.*;

import java.util.Scanner;

public class CppZoo {

    public static void main(String[] args){

        // array that contains all animals
        String[] animals = arrivingAnimalsArray();

        // calculates the birthday
        genBirthday(animals);

        // names animal
        genAnimalName(animals);

        // generates id of animal
        genAnimalId(animals);

        // puts each animal in a habitat
        String[][] habitats = new String[4][4];
        habitats = genAnimalsHabitats(animals);

        // writes file
        outputToFile(animals);
    }

    // a method that reads the arriving animals file and stores the data
    static String[] arrivingAnimalsArray(){

        int fileSize = 0;

        // array to contain all animals
        String[] animals;

        try{
            File namefile = new File("arrivingAnimals.txt");
            Scanner sc = new Scanner(namefile);

            // get the size of the file
            while(sc.hasNextLine()){
                sc.nextLine();
                fileSize = fileSize + 1;
            }

            animals = new String[fileSize];

            sc = new Scanner(namefile);

            int counter = 0;

            // read file
            while(sc.hasNextLine()){
                String arriveAnimals = sc.nextLine();

                // animal info
                String age = "" ;
                String sex = "" ;
                String species = "" ;
                String color = "" ;
                String weight = "" ;
                String season = "";
                String retValueDetail = "";
                age = arriveAnimals.split(" ")[0];
                sex = arriveAnimals.split(" ")[3];
                species = arriveAnimals.split(",")[0].split(" ")[4];
                color = arriveAnimals.split(", ")[2];
                weight = arriveAnimals.split(",")[3];
                season = arriveAnimals.split(", ")[1];

                // combine info into one string
                retValueDetail += age + " year old " + sex +" "+ species +", with "+ color +", its weight is"+ weight + ", " + season + ", ";

                //put the combined info into animal array
                animals[counter] = retValueDetail;
                counter++;
            }
            sc.close();
            // return array
            return animals;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // a method that generates the birthday of the animal
    static void genBirthday(String[] animals){

        // loop through all animals
        for (int i = 0; i < 16; i++) {
            String season = "";
            String age = "";

            // get the season
            season = animals[i].split(",")[3].split(" ")[3];

            // check the season to set the birth month
            if (season.equals("season")){
                season = "unknown";
            }

            if (season.startsWith("spring"))
            {
                animals[i] = animals[i] + "March 1";
            } else if (season.startsWith("summer"))
            {
                animals[i] = animals[i] + "June 1";
            } else if (season.startsWith("fall"))
            {
                animals[i] = animals[i] + "September 1";
            } else if (season.startsWith("winter"))
            {
                animals[i] = animals[i] + "December 21";
            } else if (season.startsWith("unknown"))
            {
                animals[i] = animals[i] + "January 1";
            }

            // get the age
            age = animals[i].split(" ")[0];

            // get the year the animal was born
            int thisYear = 2022;
            int year = thisYear - Integer.parseInt(age);

            // add the birthday to the animal
            animals[i] += ", " + year;
            animals[i] += ", arrived October 1, 2022";
        }
    }

    // a method that generates the id of the animal
    static void genAnimalId(String[] animals){

        // loop through all animals
        for(int i = 0; i < 16; i++){

            // get the species
            String species = "";
            species = animals[i].split(",")[1].split(" ")[5];
            // make first two letters uppercase
            species = species.substring(0,2).toUpperCase();

            // make the id
            String id = "";
            int idNum = i + 1;
            id = species  + idNum;

            // add the id to the animal
            animals[i] = id + ": " + animals[i] + " ";
        }
    }

    // a method that puts the animals into habitats
    static String[][] genAnimalsHabitats(String[] animals){

        // array for the habitats
        String[][] habitats = new String[4][4];
        String species = "";

        // loop through every fourth animal
        for(int i = 0; i < 16; i+=4){
            // get the species
            species = animals[i].split(",")[1].split(" ")[5];

            // add the habitat to the animal
            animals[i] = species + " habitat:\n\n" + animals[i];
        }


        int count = 0;

        // adds animals to habitat array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                habitats[i][j] = animals[count];
                count++;
            }
        }

        // returns habitat array
        return habitats;
    }

    // a method that reads the names file and gives each animal a name
    static  void genAnimalName(String[] animals){

        try{
            File namefile = new File("animalNames.txt");
            Scanner sc = new Scanner(namefile);

            // place to store each group of names
            String hyenaNames = "";
            String lionNames = "";
            String tigerNames = "";
            String bearNames = "";

            // read through file
            while (sc.hasNextLine()) {

                String animalName = sc.nextLine();

                // check the species category then skip to where the names are
                if(animalName.startsWith("Hyena")){
                    sc.nextLine();
                    hyenaNames = sc.nextLine();
                } else if(animalName.startsWith("Lion")){
                    sc.nextLine();
                    lionNames = sc.nextLine();
                } else if(animalName.startsWith("Tiger")){
                    sc.nextLine();
                    tigerNames = sc.nextLine();
                } else if(animalName.startsWith("Bear")){
                    sc.nextLine();
                    bearNames = sc.nextLine();
                }
            }

            // add the names to the animals based on their species
            int counter = 0;
            for(int i = 0; i < 4; i++){
                animals[i] = hyenaNames.split(", ")[counter]  + ", " + animals[i];
                counter++;
            }
            counter = 0;
            for (int i = 4; i < 8 ; i++) {
                animals[i] = lionNames.split(", ")[counter]  + ", " + animals[i];
                counter++;
            }
            counter = 0;
            for (int i = 8; i < 12 ; i++) {
                animals[i] = tigerNames.split(", ")[counter]  + ", " + animals[i];
                counter++;
            }
            counter = 0;
            for (int i = 12; i < 16 ; i++) {
                animals[i] = bearNames.split(", ")[counter]  + ", " + animals[i];
                counter++;
            }

            sc.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // a method that writes the final report
    static void outputToFile(String[] animals){
        try {
            FileWriter myWriter = new FileWriter("zooPopulation.txt");

            // loop through all animals and write them to the file
            for (int i = 0; i < 16; i++) {
                myWriter.write(animals[i] + "\n\n");
            }

            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}


