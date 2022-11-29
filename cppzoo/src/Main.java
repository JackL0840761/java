import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//main that contains everything that is used
    public static void main(String[] args){

        //2d array for animal info
        String[][] animalInfo=getAnimalsInfo();
        //2d array that has id of all animal
        //for example,habitat row 0 will have all hyenas and their id can be get by column number
        String[][] Habitat=genZooHabitats(animalInfo);

        //methods that use info that is stored in animalInfo
        genBirthDay(animalInfo);
        genUanimalID(animalInfo);
        genAnimalName(animalInfo);

        //generate file in zoo population
        generateFinalReport(animalInfo, Habitat);
    }

    static String[][] getAnimalsInfo()
    //creates a 2d array with rows for animals and columns for attribute
    {
        //open the file arrivingAnimals.txt
        int size = 0;// calculate how many animals in the file
        try
        {
            File file = new File("arrivingAnimals .txt");
            Scanner sc = new Scanner(file);//file to be scanned
            while (sc.hasNextLine()) {//counts till there is another line in file and adds it to size
                sc.nextLine();//gets the next line
                size++;//increase in size
            }
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String[][] animalInfo = new String[size][11];
        //A 2D string with rows that are equal to the total number of animals which are saved as size
        // and columns are attributes of each animal to be saved

        //the attributes will be saved as following in columns:
        //0=id, 1.name, 2.birthday, 3.age, 4.sex, 5.specie, 6.season, 7.colour, 8.weight, 9.Park, 10.Country

        //parse through the whole file now and separate the information
        try
        {
            File file = new File("arrivingAnimals .txt");
            Scanner sc = new Scanner(file);     //file to be scanned
            int indexAnimal = 0;
            int traitIndex = 3;//we start column index from 3 because 0 is for ID, 1 is for name and 2 is for birthday
            while (sc.hasNextLine()) {//iterate over the file till we reach the end
                String input = sc.nextLine();//get the line
                //now we have to parse this line in order to get attributes from it
                //we do it using "split"
                animalInfo[indexAnimal][traitIndex] = input.split(" ", 2)[0];//store age
                traitIndex++;
                animalInfo[indexAnimal][traitIndex] = input.split(" ")[3];//store sex
                traitIndex++;
                animalInfo[indexAnimal][traitIndex] = input.split(",")[0].split(" ")[4];//store specie
                traitIndex++;
                animalInfo[indexAnimal][traitIndex] = input.split(", ")[1].split(" ")[2];//store season
                traitIndex++;
                animalInfo[indexAnimal][traitIndex] = input.split(", ")[2].split(" ")[0];//store colour
                traitIndex++;
                animalInfo[indexAnimal][traitIndex] = input.split(", ")[3].split(" ")[0];//store weight
                traitIndex++;
                animalInfo[indexAnimal][traitIndex] = input.split(", ")[4].split(" ")[1];//store Zoo name
                traitIndex++;
                animalInfo[indexAnimal][traitIndex] = input.split(", ")[5];//store country name
                traitIndex = 3;//reset the trait index to 3 so we can start placing attributes for next animal
                indexAnimal++;//move to next animal in animalInfo
            }
            sc.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return animalInfo;
    }

    static void genBirthDay(String[][] animalInfo)
    //methods that generates birthday based on age and season
    {
        int currentYear=2022;
        int birthYear = 0;
        String birthMonth = "";
        //storing the same day the program is made as a default day
        LocalDate currentDate=java.time.LocalDate.now();
        //gets the current date with now() method
        int birthDay=currentDate.getDayOfMonth();
        //gets the day of birthday date

        for(int i = 0;i < animalInfo.length;i++)
            //iterate over all animals in animalInfo
        {
            String yearInfo = animalInfo[i][3];
            //get the age attribute from animalInfo which is at index 3
            birthYear=currentYear-Integer.parseInt(yearInfo);
            //calculate year of birth

            //calculate birth Month with switch statement
            switch (animalInfo[i][6]){
                //animalInfo[i][6] gives the season attribute of animal and
                // assigned the months depending on the given season
                case "spring"://if the season was spring
                    birthMonth = "March";//set birth month march because spring starts from march
                    break;
                case "summer"://if the season was summer
                    birthMonth = "June";//set birth month June because summer starts from june
                    break;
                case "fall"://if the season was fall
                    birthMonth = "September";//set birth month September because fall starts from September
                    break;
                case "winter"://if the season was winter
                    birthMonth = "December";//set birth month December because winter starts from December
                    break;
                case "unknown"://if the season was unknown
                    birthMonth = String.valueOf(currentDate.getMonth());//we set it as the current month
                default:
                    birthMonth = String.valueOf(currentDate.getMonth());//same as in the case of unknown
            }
            animalInfo[i][2] = String.valueOf(birthDay)+"-"+birthMonth+"-"+birthYear;//concatenate the day, month and year calculated in one string
            //and store it in attribute index 2 of animalInfo which represents the birthday of animal
            //do this for all animals
        }
    }

    static void genUanimalID(String [][] animalInfo)
    //methods that assigns ID
    {
        for (int i = 0;i < animalInfo.length;i++)
        {
            animalInfo[i][0] = String.valueOf(i);
            //gives id equal to the index of row an animal exists in with valueOf() method
        }
    }

    static void genAnimalName(String [][] animalInfo)//method that use linked list to store the names
    {
        //read the whole name file and make 4 arrays of names and store names from file in them
        List<String> HyenaNames = new ArrayList<>();//linked list use to store hyena names
        List<String> LionNames = new ArrayList<>();//linked list use to store lion names
        List<String> BearNames = new ArrayList<>();//linked list use to store bear names
        List<String> TigerNames = new ArrayList<>();//linked list use to store tiger names
        try
        {
            File file = new File("animalNames .txt");
            Scanner sc = new Scanner(file);     //file to be scanned

            if (sc.hasNextLine()) {
                //add hyena names
                sc.nextLine();
                sc.nextLine();//skip two lines
                String[] names = sc.nextLine().split(", ");//parse the names of hyenas
                for(int i = 0;i < names.length;i++)
                {
                    HyenaNames.add(names[i]);//store each name in HyenaNames List
                }

                //add lion name
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();//skip three lines
                names = sc.nextLine().split(", ");//parse the names of lions
                for(int i = 0;i < names.length;i++)
                {
                    LionNames.add(names[i]);//store each name in LionNames List
                }

                //add Bear names
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();//skip two lines
                names = sc.nextLine().split(", ");//parse the names of Bears
                for(int i = 0;i < names.length;i++)
                {
                    BearNames.add(names[i]);//store each name in BearNames List
                }
                //add Tiger names
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();//skip two lines
                names=sc.nextLine().split(", ");//parse the names of Tigers
                for(int i = 0;i < names.length;i++)
                {
                    TigerNames.add(names[i]);//store each name in TigerNames List
                }

            }
            sc.close();//close the file
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        int indexHyena = 0, indexLion = 0, indexBear = 0, indexTiger = 0;
        //these indexes keep track of the names which have been allotted and which is available

        for(int i = 0;i < animalInfo.length;i++)
        {
            switch(animalInfo[i][5])
            //switch statement gets the specie name and assigns the name from the above names
            // depending on the specie to which the animal belongs to
            {
                case "hyena":
                    animalInfo[i][1] = HyenaNames.get(indexHyena);
                    //if the animal was hyena than gives the name at indexHyena to the current animal
                    // and store the name at animalInfo index 1 which was the attribute to store name of animal
                    indexHyena++;//increases indexHyena so if another hyena comes the next name will be given to it
                    break;
                case "lion":
                    animalInfo[i][1] = LionNames.get(indexLion);//if the animal was lion than gives the name at indexLion to the current animal
                    // and store at column index 1
                    indexLion++;//increases indexLion so if another lion comes the next name will be given to it
                    break;
                case "tiger":
                    animalInfo[i][1] = TigerNames.get(indexTiger);//if the animal was tiger than gives the name at indexLion to the current animal
                    // and store at column index 1
                    indexTiger++;//increases indexTiger so if another tiger comes the next name will be given to it
                    break;
                case "bear":
                    animalInfo[i][1] = BearNames.get(indexBear);//if the animal was bear than gives the name at indexLion
                    // to the current animal and store at column index 1
                    indexBear++;//increases indexBear so if another bear comes the next name will be given to it
                    break;
                default:
                    animalInfo[i][1] = "none";
            }
        }

    }
    static String[][] genZooHabitats(String[][] animalInfo)
            //2d array for the habitats
    {
        String [][] Habitat = new String[4][4];
        //each row is a specie and the columns are individual animals of that specie
        //ROW: 0.Hyena Habitat 1.Lion Habitat 2. Tiger Habitat 3.Bear Habitat
        //we store the id of the animal in habitats
        //i = index, z = row and j is colum
        for(int i = 0, z = 0;z < 4;z++)//takes one habitat row for each specie
        {
            for (int j = 0;j < 4;j++)//assigns 4 animals to each column of that row
            {
                Habitat[z][j] = animalInfo[i][0];//places the id of the animal belonging to same specie in the current row
                i++;//next animal
            }

        }
        return Habitat;//returns a 2d array 4x4 size of habitat
    }

    static void generateFinalReport(String[][] animalInfo, String [][] Habitats)
            //methods to output into zooPopulation file
    {
        try
        {
            FileWriter file=new FileWriter("zooPopulation.txt");
            for(int i = 0;i < 4;i++)//iterates over all 4 habitat
            {
                file.write("Habitat "+String.valueOf(i)+":"+"\n");
                file.write("Specie "+animalInfo[Integer.parseInt(Habitats[i][0])][5]+"\n");
                for(int j = 0;j < 4;j++)
                    //iterates over all 4 animals in one specific habitat one by one
                {
                    int index=Integer.parseInt(Habitats[i][j]);
                    //we have the index of row of animal from animal info
                    //0.id 1.name 2.birthday 3.age 4.sex 5.specie 6.season 7.colour 8.weight 9.Park 10.Country
                    String line=("ID: " +animalInfo[index][0]+", Name: "+animalInfo[index][1]+
                            ", Birthday: "+animalInfo[index][2]+", Age: "+animalInfo[index][3]+
                            ", Sex: "+animalInfo[index][4]+", Specie: "+animalInfo[index][5]+
                            ", colour: "+animalInfo[index][7]+", Weight: "+animalInfo[index][8]+
                            ", Park: "+animalInfo[index][9]+", Park"+
                            ", from Country: "+animalInfo[index][10]);
                    file.write(line +"\n");
                }
            }
            file.close();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }


}
