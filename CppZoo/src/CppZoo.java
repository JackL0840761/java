
import static java.lang.System.out;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CppZoo
{
    // ArrayList that contains the data of all Animals
    private static ArrayList<Animal> animals = new ArrayList<>();

    static String getRandomName(String[] namesArray) {
        Random random = new Random();
        int max = namesArray.length - 1;
        int min = 0;
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return namesArray[randomNumber];
    }

    static String genAnimalName(ArrayList<String[]> names, String specie) {
        String mySpecie = specie.replace(',', ' ');
        mySpecie = mySpecie.trim();

        String name = "";
        if(mySpecie.equals("hyena")) {
            String[] array = names.get(1);
            name = getRandomName(array);
        }
        else if(mySpecie.equals("lion")) {
            String[] array = names.get(3);
            name = getRandomName(array);
        }
        else if(mySpecie.equals("tiger")) {
            String[] array = names.get(7);
            name = getRandomName(array);
        }
        else if(mySpecie.equals("bear")) {
            String[] array = names.get(5);
            name = getRandomName(array);
        }

        return name;
    }

    static void genAnimalNames(){
        String species = "" ;

        try{
            File namefile1 =new File("C:\\javainstall\\javafiles\\CppZoo\\animalNames.txt");
            Scanner sc1= new Scanner(namefile1);

            ArrayList<String[]> animalNames = new ArrayList<>();
            while(sc1.hasNextLine()){
                String animalName = sc1.nextLine();
                String[] nameArr = animalName.split(",",16);
                if(!nameArr[0].equals("")) {
                    animalNames.add(nameArr);
                }
            }

            for(int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                animal.setName(genAnimalName(animalNames, animal.getSpecies()));
                out.println(animal.genAnimalName());
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //an array that display the age,sex,species,color and weight of the animal from arriving animal txt
    static void arrivingAnimalsArray(){
        try{
            File namefile =new File("C:\\javainstall\\javafiles\\CppZoo\\arrivingAnimals.txt");
            Scanner sc= new Scanner(namefile);

            while(sc.hasNextLine()){
                String arriveAnimals = sc.nextLine();

                String age = "" ;
                String sex = "" ;
                String species = "" ;
                String color = "" ;
                String weight = "" ;
                String retValueDetail = "";
                age = arriveAnimals.split(" ")[0];
                sex = arriveAnimals.split(" ")[3];
                species = arriveAnimals.split(" ")[4];
                color = arriveAnimals.split(",")[2];
                weight = arriveAnimals.split(",")[3];
                String addr1 = arriveAnimals.split(",")[4];
                String addr2 = arriveAnimals.split(",")[5];
                String address = addr1 + "," + addr2 + ";";

                retValueDetail += "age "+ age +" "+ sex +" "+ species +" with"+ color +" and its weight is"+ weight;
                out.println(retValueDetail + ".");
                Animal animal = new Animal(age, sex, species, weight, retValueDetail, address);
                animals.add(animal);
            }
            sc.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //a method that is used to find out what is the estimate birthday of the animal
    static void genBirthday()
    {

        // Open a file and read it line by line.

        try
        {
            File namefile = new File("C:\\javainstall\\javafiles\\CppZoo\\arrivingAnimals.txt");
            Scanner sc = new Scanner(namefile);
            int i = 0;

            // get both the age and season
            while (sc.hasNextLine())
            {
                String birthDay = sc.nextLine();

                String season = "";
                String age = "";
                season = birthDay.split(",")[1].split(" ")[3];
                if (season.equals("season")){
                    season = "unknown";
                }
                //out.println(season);

                String retValBirthDay = "";
                if (season.startsWith("spring"))
                {
                    retValBirthDay = "March 1";
                } else if (season.startsWith("summer"))
                {
                    retValBirthDay = "June 1";
                } else if (season.startsWith("fall"))
                {
                    retValBirthDay = "September 1";
                } else if (season.startsWith("winter"))
                {
                    retValBirthDay = "December 21";
                } else if (season.startsWith("unknown"))
                {
                    retValBirthDay = "January 1";
                }

                age = birthDay.split(" ")[0];

                int currentYear = 2022;
                int year = currentYear - Integer.parseInt(age);

                retValBirthDay += ", " + year;
                out.println(retValBirthDay);
                animals.get(i).setBirthDay(retValBirthDay);
                i += 1;
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // a method that is used to process habitats for each animals
    static void genZooHabitats() {
        for(int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            String specie = animal.getSpecies();
            String mySpecie = specie.replace(',', ' ');
            mySpecie = mySpecie.trim();

            if(mySpecie.equals("hyena")) {
                String[] array = {"Forest", "Savannas","Woodlands", "Subdeserts", "Mountains"};
                animal.setHabitats(array);
            }
            else if(mySpecie.equals("lion")) {
                String[] array = {"Forest", "Open plains"};
                animal.setHabitats(array);
            }
            else if(mySpecie.equals("tiger")) {
                String[] array = {"Rain Forest", "Savannas", "Mangrove Swamps"};
                animal.setHabitats(array);
            }
            else if(mySpecie.equals("bear")) {
                String[] array = {"Forest", "Mountains", "Tundra", "Deserts"};
                animal.setHabitats(array);
            }
        }
    }

    // a method that is used to output string data to a file providing the file name
    static void outputToFile(String fileName, String data) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(data);
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // a method that is used to output animals report
    static void outputAnimalsReport() {
        // The string to output to zooPopulation.txt
        String outputString = "";
        int id = 1;
        // print hyenas
        out.println("\nHyena Habitat:");
        outputString += "\nHyena Habitat:";
        for(int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if(animal.getHabitats().length == 5) {
                if(id < 10) {
                    out.println("Hy0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is  " + animal.getBirthDay());
                    outputString += "\nHy0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                else {
                    out.println("Hy" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail()  + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay());
                    outputString += "\nHy" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                id += 1;
            }
        }

        outputString += "\n";

        id = 1;
        // print lions
        out.println("\nLion Habitat:");
        outputString += "\nLion Habitat:";
        for(int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if(animal.getHabitats().length == 2) {
                if(id < 10) {
                    out.println("Li0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay());
                    outputString += "\nLi0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                else {
                    out.println("Li" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay());
                    outputString += "\nLi" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                id += 1;
            }
        }

        outputString += "\n";

        id = 1;
        // print tigers
        out.println("\nTiger Habitat:");
        outputString += "\nTiger Habitat:";
        for(int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if(animal.getHabitats().length == 3) {
                if(id < 10) {
                    out.println("Ti0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay());
                    outputString += "\nTi0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                else {
                    out.println("Ti" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay());
                    outputString += "\nTi" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                id += 1;
            }
        }

        outputString += "\n";

        id = 1;
        // print bears
        out.println("\nBear Habitat:");
        outputString += "\nBear Habitat:";
        for(int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if(animal.getHabitats().length == 4) {
                if(id < 10) {
                    out.println("Be0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay());
                    outputString += "\nBe0" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                else {
                    out.println("Be" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay());
                    outputString += "\nBe" + id + ":" + animal.genAnimalName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " birthday is " + animal.getBirthDay();
                }
                id += 1;
            }
        }

        outputToFile("C:\\javainstall\\javafiles\\CppZoo\\zooPopulation.txt", outputString);
    }

    public static void main(String[]args){

        arrivingAnimalsArray();
        genBirthday();
        genAnimalNames();
        genZooHabitats();
        outputAnimalsReport();
    }


    // Class to hold Animal data
    public static class Animal {
        // Used in creating unique ids for each Animal
        private static int currentID = 1;
        private int id;
        private String name;
        private String age;
        private String sex;
        private String species;
        private String weight;
        private String retValueDetail;
        private String[] habitats;
        private String birthDay;
        private String address;

        // Constructor
        public Animal(String age, String sex, String species, String weight, String retValueDetail, String address) {
            this.age = age;
            this.sex = sex;
            this.species = species;
            this.weight = weight;
            this.retValueDetail = retValueDetail;
            this.id = Animal.currentID;
            this.address = address;
            Animal.currentID += 1;
            this.habitats = new String[10];
        }

        // Getters and Setters
        public static int getCurrentID() {
            return currentID;
        }

        public static void setCurrentID(int currentID) {
            Animal.currentID = currentID;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getRetValueDetail() {
            return retValueDetail;
        }

        public void setRetValueDetail(String retValueDetail) {
            this.retValueDetail = retValueDetail;
        }


        public String[] getHabitats() {
            return habitats;
        }

        public void setHabitats(String[] habitats) {
            this.habitats = habitats;
        }

        public String genAnimalName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }



    }



}

