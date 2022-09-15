import java.util.Scanner;
import static java.lang.System.out;
public class warmup0915
{
    static void zooArray()
    {
        Scanner sc = new Scanner(System.in);
        String animalName = "";
        String[][] myZooAnimal = new String[3][3];
        for (int i = 0; i < 3; i++)
        {
            out.println("input lion names for lion "+i);
            animalName =sc.nextLine();
            myZooAnimal[0][i] = animalName;
        }
        for(int i = 0;i < 3;i++){
            out.println("lion"+(i+1)+"is name "+myZooAnimal[0][i]);
        }
        for (int j = 0; j < 3; j++)
        {
            out.println("input tiger names for tiger "+j);
            animalName =sc.nextLine();
            myZooAnimal[0][j] = animalName;
        }
        for(int j = 0;j < 3;j++){
            out.println("tiger"+(j+1)+"is name "+myZooAnimal[0][j]);
        }
        for (int k = 0; k < 3; k++)
        {
            out.println("input bear names for bear "+k);
            animalName =sc.nextLine();
            myZooAnimal[0][k] = animalName;
        }
        for(int k = 0;k < 3;k++){
            out.println("bear"+(k+1)+"is name "+myZooAnimal[0][k]);
        }
    }
    static void methodUsingArray1(){


        String [] animals = {"lion","tiger","bear"};
                for(int i = 0; i<3; i++){
                    out.println("i = "+ i);
                    out.println("animal at "+ i +" is "+ animals[i]);
        }
                int length = 0;
                length = animals.length;
                out.println("length of the animals are "+length);
                for (int i = 0; i <length; i++){
                    out.println("animal "+ i +"is "+animals[i]);
                }
    }
    static void methodUsingArray2(){
        Scanner sc = new Scanner(System.in);
        String animal01,animal02;

        out.println("input animal01");
        animal01 =sc.nextLine();
        out.println("input animal02");
        animal02 =sc.nextLine();
        out.println("animal01 is " + animal01 +" and animal02 is "+ animal02);

        String[] myNewArray = {"oneAnimal here", "another here"};

        myNewArray[0] = animal01;
        myNewArray[1] = animal02;

        out.println("myNewArray[0] = " + myNewArray[0]);
        out.println("myNewArray[1] = " + myNewArray[1]);
    }
    public static void main(String[]args){
        methodUsingArray1();
        methodUsingArray2();
        zooArray();
    }
}
