import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

public class CppZoo {

    public static void main(String[] args){

        // array that contains all animals
        String[] animals = arrivingAnimalsArray();

        // calculates the birthday
        genBirthday(animals);

        //get names animal
        genAnimalName(animals);

        // generates id of animal
        genAnimalId(animals);

        // puts each animal in a habitat in 2d array
        String[][] habitats = new String[4][4];
        habitats = genAnimalsHabitats(animals);

        // writes file
        outputToFile(animals);
    }

    // a method that reads the arriving animals file and stores the data
    static String[] arrivingAnimalsArray(){
        //tracking the filesize
        int fileSize = 0;

        // array to contain all animals
        String[] animals;
        //read the file and scan
        try{
            File namefile = new File("arrivingAnimals.txt");
            Scanner sc = new Scanner(namefile);

            // get the size of the file with loop
            while(sc.hasNextLine()){
                sc.nextLine();
                fileSize = fileSize + 1;
            }
            // make array with file size
            animals = new String[fileSize];
            // rest from beginning
            sc = new Scanner(namefile);

            int counter = 0;

            //loop and read file until reach file size
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

                // combine info into one string, add it on to the string
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

        // loop through all animals and only string the season and age
        for (int i = 0; i < 16; i++) {
            String season = "";
            String age = "";

            // get the season from animal
            season = animals[i].split(",")[3].split(" ")[3];

            // check the season to set the birth month
            if (season.equals("season")){
                season = "unknown";
            }
            if (season.startsWith("spring"))
            {
                animals[i] = animals[i] + "March 1";
            }
            else if (season.startsWith("summer"))
            {
                animals[i] = animals[i] + "June 1";
            }
            else if (season.startsWith("fall"))
            {
                animals[i] = animals[i] + "September 1";
            }
            else if (season.startsWith("winter"))
            {
                animals[i] = animals[i] + "December 21";
            }
            else if (season.startsWith("unknown"))
            {
                animals[i] = animals[i] + "January 1";
            }

            // get the age from animal
            age = animals[i].split(" ")[0];

            // get the year the animal was born
            int thisYear = 2022;
            int year = thisYear - Integer.parseInt(age);

            // add the birthday to the animal and its arrived date
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
            //find out what species it is
            species = animals[i].split(",")[1].split(" ")[5];
            // make first two letters uppercase
            species = species.substring(0,2).toUpperCase();

            // make the id
            String id = "";
            int idNum = i + 1;
            //make the id with the first 2 letter and idNum, which starts from 1 and so on
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

        // loop through every fourth animal with i+=4
        for(int i = 0; i < 16; i+=4){
            // get the species
            species = animals[i].split(",")[1].split(" ")[5];

            // add the habitat to the animal
            animals[i] = species + " habitat:\n\n" + animals[i];
        }


        int count = 0;

        // adds animals with their name to the habitat array
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
        //open and read the file
        try{
            //read file and put it in scanner
            File namefile = new File("animalNames.txt");
            Scanner sc = new Scanner(namefile);

            // place to store each group of names
            String hyenaNames = "";
            String lionNames = "";
            String tigerNames = "";
            String bearNames = "";

            // read through file and loop
            while (sc.hasNextLine()) {
            // set the name in next line
                String animalName = sc.nextLine();

                // check the species category then skip 2 lines to where the names are
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

            // add the names to the animals based on their species inside animal array
            //loop 4 times to get all 4 of the species until it reach 16
            //the counter resets back to 0 everytime after they loop 4 times
            int counter = 0;
            for(int i = 0; i < 4; i++){
                animals[i] = hyenaNames.split(", ")[counter]  + ", " + animals[i];
                counter++;
            }
            //next 4 for lion
            counter = 0;
            for (int i = 4; i < 8 ; i++) {
                animals[i] = lionNames.split(", ")[counter]  + ", " + animals[i];
                counter++;
            }
            //next 4 for tiger
            counter = 0;
            for (int i = 8; i < 12 ; i++) {
                animals[i] = tigerNames.split(", ")[counter]  + ", " + animals[i];
                counter++;
            }
            //next 4 for bear
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
        //create new file writer
        try {
            FileWriter myWriter = new FileWriter("zooPopulation.txt");

            // loop through all animals and write them to the file until it reach 16
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

