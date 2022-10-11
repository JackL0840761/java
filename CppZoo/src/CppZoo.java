
import static java.lang.System.out;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CppZoo
{
	// ArrayList that contains the data of all Animals
	private static ArrayList<Animal> animals = new ArrayList<>();
	
	// a method that gets a String array and returns a random string by using random.nextInt function
	static String getRandomName(String[] namesArray) {
		Random random = new Random();
		int max = namesArray.length - 1;
		int min = 0;
		int randomNumber = random.nextInt(max + 1 - min) + min;
		return namesArray[randomNumber];
	}
	
	// a method to return name according to specie
	static String getName(ArrayList<String[]> names, String specie) {
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
            File namefile1 =new File("animalNames.txt");
            Scanner sc1= new Scanner(namefile1);
            
            // Animal Names ArrayList to hold animal names list to choose a name from
            ArrayList<String[]> animalNames = new ArrayList<>();
            while(sc1.hasNextLine()){
                String animalName = sc1.nextLine();
                String[] nameArr = animalName.split(",",16);
                if(!nameArr[0].equals("")) {
                animalNames.add(nameArr);
                }
            }
            
            // Now looping through the array list and get random animal name from the string list using a random function
            for(int i = 0; i < animals.size(); i++) {
            	Animal animal = animals.get(i);
            	// Get name function returns a random name 
            	// Set the name of the animal using animal object
            	animal.setName(getName(animalNames, animal.getSpecies()));
            	out.println(animal.getName());
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //an array that display the age,sex,species,color and weight of the animal from arriving animal txt
    static void arrivingAnimalsArray(){
        try{
            File namefile =new File("arrivingAnimals.txt");
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
            
            // Creating animal object and adding it to the animals ArrayList
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
            File namefile = new File("arrivingAnimals.txt");
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
                // Setting animal birthday after getting animal from ArrayList through index i
                animals.get(i).setBirthday(retValBirthDay);
                i += 1;
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // a method that is used to process habitats for each animals
    static void genAnimalsHabitats() {
    	for(int i = 0; i < animals.size(); i++) {
    		Animal animal = animals.get(i);
    		String specie = animal.getSpecies();
    		String mySpecie = specie.replace(',', ' ');
    		mySpecie = mySpecie.trim();
    		
    		if(mySpecie.equals("hyena")) {
    			String[] array = {"Forest"};
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
    	      // Write the string that is passed to the funciton
    	      myWriter.write(data);
    	      myWriter.close();
    	    } 
    	catch (IOException e) {
    	      e.printStackTrace();
    	    }
    }
    
    // a method that is used to output animals report
    static void genAnimalsReport() {
    	// The string to output to zooPopulation.txt
    	// Outputting animal reports and also adding it to the outputString that will be written to file
    	String outputString = "";
    	int id = 1;
    	// print hyenas
    	out.println("\nHyena Habitat:");
    	outputString += "\nHyena Habitat:";
    	for(int i = 0; i < animals.size(); i++) {
    		Animal animal = animals.get(i);
    		if(animal.getHabitats().length == 1) {
    			if(id < 10) {
    				out.println("Hy0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nHy0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
    			}
    			else {
    				out.println("Hy" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail()  + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nHy" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
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
    				out.println("Li0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nLi0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
    			}
    			else {
    				out.println("Li" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nLi" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
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
    				out.println("Ti0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nTi0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
    			}
    			else {
    				out.println("Ti" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nTi" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
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
    				out.println("Be0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nBe0" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
    			}
    			else {
    				out.println("Be" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday());
    				outputString += "\nBe" + id + ":" + animal.getName() + ";" + animal.getRetValueDetail() + ";" + animal.getAddress() + " arrived " + animal.getBirthday();
    			}
    			id += 1;
    		}
    	}
    	
    	// The file name and the outputString that needs to be written to file
    	outputToFile("zooPopulation.txt", outputString);
    }

    public static void main(String[]args){
    	// Getting animals data into ArrayList 
        arrivingAnimalsArray();
        // Generating animal birthdays
        genBirthday();
        // Generating animal names
        genAnimalNames();
        // Generating animal habitats
        genAnimalsHabitats();
        // Generating report and outputting to file
        genAnimalsReport();
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
    	private String birthday;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBirthday() {
			return this.birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		

    }
    
    
    
    }


