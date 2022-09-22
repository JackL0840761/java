import static java.lang.System.out;
import java.util.Scanner;

public class warmup0922
{

    static void numberArray()
    {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[20];
        int largest = numbers[0];
        int smallest = numbers[0];
        String userinput ="";
        for(int i=0; i<numbers.length; i++){
            out.println("input the number "+i+" number");
            numbers[i] = sc.nextInt();
            //try{ num1=num2 +Intege.parseInt(userinputValues[i]);
            //catch(Exception e{out.println("enter number");
            out.println(("number "+i+" is "+numbers[i]));
            if(numbers[i]>largest)
            {
                largest = numbers[i];
                if(numbers[i]<largest){
                    numbers[i] = smallest;
                }
            }

        }
        out.println("the largest number is "+largest+" and the smallest is "+smallest);

    }

    public static void main(String[] args){
        numberArray();
    }

    }


