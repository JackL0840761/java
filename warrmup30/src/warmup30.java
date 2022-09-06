import java.util.Scanner;
import static java.lang.System.out;

public class warmup30 {


    static void nameMethod(String firstname, String lastname, int age){
       /*
        Scanner sc = new Scanner(System.in);
        System.out.println("what is your name");
        username = sc.nextLine();
        System.out.println("Hello "+username);
        */
    }

    //replace numTwo to num2 and replace to static int instead of static void
    static int addTwoNumbers(int num1, int num2){
        int result = 0;
        result = num1 + num2;
        return result;
    }
    //defined value for both numbers and make it display the result
    public static void main(String[] args){
        int num1 = 5;
        int num2 = 3;
        System.out.println("result is "+addTwoNumbers(num1,num2));

        Scanner sc = new Scanner(System.in);
        System.out.println("what is your name");
        String username = sc.nextLine();
        System.out.println("Hello "+username+", how old are you");
        int age =sc.nextInt();

    }
}
