import java.util.Scanner;
import static java.lang.System.out;

public class warmup0913 {

    static void methodArray1(){
        String[] pets ={"cat","dog","bird"};
        int i =0;
        for(i=0; i<3; i++);
        {
                out.println("i is "+i);
                out.println("there is " + (pets.length) + " pets.");
        }
    }


    static void methodUsingArray1(){
        Scanner sc = new Scanner(System.in);
        out.println("input new pets1 ");
        String newpets1 = sc.nextLine();
        out.println("intput new pets2");
        String newpets2 = sc.nextLine();
        out.println("new pets are "+newpets1+" and "+newpets2);
    }

    public static void main(String[] args){

        int[]myInts=new int[5];
        myInts[0]= 00;
        myInts[1]= 10;
        myInts[2]= 20;
        myInts[3]= 30;
        myInts[4]= 40;

        methodArray1();
        methodUsingArray1();
        for(int i=0;i<5;i++){
            out.println("myInts["+i+"]="+myInts[i]);
        }
    }
}
