import static java.lang.System.out;
import java.util.Scanner;

public class warmup901{

    static int largestOfThree(int num1, int num2, int num3)
    {
        // declare a variable named largest
        int largest = 0;

        if (num1 > num2)
        {
            if (num1 > num3)
            {
                largest = num1;
            }
            else
            {
                largest = num3;
            }
        }
        else
        {
            if (num2 > num3)
            {
                largest = num2;
            }
            else
            {
                largest = num3;
            }
        }

        return largest;

    }
    static String dayOfTheWeek(int userNum) {
        String theDay = "";

        // create a switch statement
        switch (userNum) {
            case 1:
                theDay = "Monday";
                break;
            case 2:
                theDay = "Tuesday";
                break;
            case 3:
                theDay = "Wednesday";
                break;
            case 4:
                theDay = "Thursday";
                break;
            case 5:
                theDay = "Friday";
                break;
            case 6:
                theDay = "Saturday";
                break;
            case 7:
                theDay = "Sunday";
                break;
            default:
                theDay = " You need to enter 1-7!";
        }
        return theDay;
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // variable declaration section
        int userInputNumber = 0;

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        out.println("\n\nWelcome to Warmup01sep22!");

        // call the dayOfWeek method..

        out.println(" \n day of the week should be Wednesday (because i input a 3) = ");
        out.println(dayOfTheWeek(3));

        // Get user input!
        out.println(" \n Enter a number from 1 to 7 : ");
        userInputNumber = scanner.nextInt();

        // call dayOfTheWeek()
        out.println("\n the day of the week corresponding to " + userInputNumber);
        out.println("\n is " + dayOfTheWeek(userInputNumber));

        out.println("\n\n");

        // call the method largestOfThree
        // Get user input!

        out.println(" \n Enter the first number : ");
        num1 = scanner.nextInt();

        out.println(" \n Enter the second number : ");
        num2 = scanner.nextInt();

        out.println(" \n Enter the third number : ");
        num3 = scanner.nextInt();

        out.println("\n the largest of three is: " + largestOfThree(num1, num2, num3) + " wow! \n");



    }

}
