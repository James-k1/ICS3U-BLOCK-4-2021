package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // exampleOne(in);
        // exampleTwo(in);
        System.out.println(covertToSeconds("5:5.6"));
        System.out.println(covertToSeconds("30.6"));
        System.out.println(covertToSeconds("500:30.6"));
        System.out.println(convertToTime(305.6));
        System.out.println(convertToTime(30.6));
        System.out.println(convertToTime(30030.6));
        
        
        



        in.close();
    }
    private static double covertToSeconds(String time) {
        if (time.indexOf(":")==-1){
            return Double.parseDouble(time);
        }
        
        double minutes = Double.parseDouble(time.substring(0,time.indexOf(":")));
        return (minutes*60)+Double.parseDouble(time.substring(time.indexOf(":")+1));
    }
    private static String convertToTime(double seconds) {
        return String.format("%d:%06.3f", ((int) seconds/60), Math.round(seconds%60 * 100.0) / 100.0);
    }

    private static void exampleTwo(Scanner in) {
        System.out.print("enter a number> ");
        //double num = in.nextDouble();

        double num = 0;
        boolean validInput = false;

        while(!validInput){
        try {
            num = Double.parseDouble(in.nextLine());
            validInput = true;
        } catch (Exception e) {
            System.out.print("OMG U ARE SO DUMB I SAID TO ENTER A NUMBER: ");

        }
    }
        
        
        double result = Math.pow(num,2);
        System.out.println(result);

    }

    private static void exampleOne(Scanner in) {
        
        System.out.print("Enter name> ");
        String name = in.nextLine();
        System.out.println("Hello " + name);
        

        
        

    }
    
}

