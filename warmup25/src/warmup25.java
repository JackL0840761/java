
/*
aug 25 warm up
 */
public class warmup25 {
    public static void main(String[] args)
    {


        for (int out1 = 0; out1 <= 5; out1++)
        {
            System.out.println("number out is " + out1);
        }
        System.out.println("");
            for (int inner1 = 2; inner1 <= 5; inner1++)
            {
                System.out.println("number in is " + inner1);
            }
            System.out.println("end of for");
            System.out.println("");

            int inner2=0;
            int out2=0;

            while (out2<10){
                out2 ++;
                while(inner2<10)
                    inner2 ++;

                System.out.println("out2 is "+out2+" and inner2 is "+inner2);
            }
            System.out.println("end of while");



    }
}
