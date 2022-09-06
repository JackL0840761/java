import java.util.Scanner; //a class that is use for obtaining input for primitive type such as int, double etc...
//8-16-22
//add and multiply two number and find the largest two int
public class AddTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // making a new object of Scanner class and store in Variable input
        System.out.println("Enter the first Numbers");// ask for an input from user
        int num1 = scan.nextInt();// scans the next token of input data as "int"
        System.out.println("Enter second Numbers");
        int num2 = scan.nextInt();
        int add = num1+num2;// adding both numbers up
        int multiply = num1*num2; // multiplying both numbers up
        System.out.println("Output of addition is "+add); //display the output for both addition and multiply
        System.out.println("Output of multiply is "+multiply);
        if( add > multiply )// if the output for add is bigger than multiply, display add as largest, else multiply
            System.out.println(add+" is the largest number");
        else
            System.out.println(multiply+" is the largest number");


    }
}
