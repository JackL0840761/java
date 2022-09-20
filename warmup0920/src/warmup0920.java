import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class warmup0920 {

    //make a file in theory
    public static void main(String[] args){
        try {
            File file = new File("C:/javainstall/javafiles/0920/0920warmup.txt");
            if (file.createNewFile()) {
                out.println("File created is: " + file.getName());
            }
            else {
                out.println("File already exists! ");
            }
        } catch (IOException e) {
            out.println("Exception caught! ");
            e.printStackTrace();
        }
        //input the userinput 100 time, not sure how to get it in nextline tho
        try {
            FileWriter writer = new FileWriter("C:/javainstall/javafiles/0920/0920warmup.txt");
            Scanner sc =new Scanner(System.in);
            String txtLine =" ";
            out.println("\ninput what you want to copy in txt \n");
            txtLine = sc.nextLine();
            for(int i = 0; i < 100; i++)
            {
                writer.write(txtLine);
            }
            writer.close();
            out.println("File write complete.");
        } catch (IOException e ){
            out.println("File IO exception caught!");
            e.printStackTrace();
        }
        File file =new File("C:/javainstall/javafiles/0920/0920warmup.txt");
        if (file.exists()){
            out.println("file name is "+file.getName()+", its path is "+file.getAbsolutePath()+", can it be written "+file.canWrite()+", can it be read "+file.canRead()+", how long is the file "+file.length());
        }
        //read CSV
    try{
        String path ="C:/javainstall/javafiles/0920/state_crime.csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine())!=null){
            String[] values = line.split(",");
            out.println("State "+values[0]+", Burglary record "+values[5]);
        }
    }
    catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}