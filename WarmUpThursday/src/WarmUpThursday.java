import java.util.Scanner;
//8/18 get two number add and sum and echo back?
public class WarmUpThursday {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);//add in scanner object for inputs

        System.out.println("Please enter two numbers.");//ask for input
        float num1 = scan.nextFloat();//get both of the inputs, floating point number is fine with double
        float num2 = scan.nextFloat();

        float add = num1+num2;//adding them normally

        System.out.println("You entered "+num1+" and "+num2+" The value for adding them both is "+add);

        System.out.println("The sum of the number is "+Float.sum((int)num1, (int)num2));// using line for sum
    }

}
