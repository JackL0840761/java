import java.util.Scanner;
/*
aug 23 warm up for nesting a decision control
 */

public class warmup23
{
    public static void main(String[] args)
    {
    int max =0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("please input a numbers");
        int num1 = scanner.nextInt();
        System.out.println("display number 1: " + num1);

        System.out.println("please input a numbers");
        int num2 = scanner.nextInt();
        System.out.println("display number 2: " + num2);

        System.out.println("please input a numbers");
        int num3 = scanner.nextInt();
        System.out.println("display number 3: " + num3);
//multiple line of codes for inputs
        int num4 = num1 + num2;
        System.out.println("\ndisplay number for addition " + num4);
        int num5 = num2 * num3;
        System.out.println("display number for multiple" + num5);
//addition and multiple between two input
        int mNim = (num2 < num3) ? num1 : num3;
        System.out.println("\nthe smallest is "+mNim);
        int mMax = (num1 > num3) ? num2 : num3;
        System.out.println("largest is "+mMax);
// a java ternary operator to get smallest and largest
        if (num1 > num5)
        {
            System.out.println("\nnumber 1: "+num1+" is larger than " + num5);
           if (num2 > num5)
            System.out.println("\nnumber 2: "+num2+" is larger than " + num5);
        } else
        {
        if(num3 > num5)
            max= num3;
        else if(num5 > num4)
            max=num5;
            System.out.println("\nthe largest number is  " + max);
        }
    // this if statement is currently nested
        for (int n = 0; n < num4; n++)
        {
            System.out.println("number 4 is " + num4 + " and the value for n is " + n);
        }
        while(num4 < num5){
            System.out.println("number 4 currently is "+num4);
            num4++;
        }
        //while statement
    }
}
