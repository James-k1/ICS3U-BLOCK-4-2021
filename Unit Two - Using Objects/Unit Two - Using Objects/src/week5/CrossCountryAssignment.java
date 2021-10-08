package week5;

import java.util.Scanner;

public class CrossCountryAssignment {
    /**
     * 
     * @param args
     * makes all the calls
     * @return void
     */
    public static void main(String[] args) {
        //declares the Scanner to get user input
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();

    }
    /**
     * 
     * @param in
     * @return void
     */
    private static void processRunner(Scanner in) {
        //init variables 
        String firstName, lastName;
        String MileOne,mileTwo,finish;
        String splitTwo,splitThree;
 
        //prompts user for name, mile one, mile two and, mile three
        System.out.print("Enter your first name: ");
        firstName = in.nextLine();
        System.out.print("Enter your last name: ");
        lastName = in.nextLine();
        System.out.print("Enter the time (minutes:seconds.millisecons format) for mileOne: ");
        MileOne = in.nextLine();
        System.out.print("Enter the time (minutes:seconds.millisecons format) for mileTwo: ");
        mileTwo = in.nextLine();
        System.out.print("Enter the time (minutes:seconds.millisecons format) for mileThree: ");
        finish = in.nextLine();

        //calculates the splits (splits two and three)
        splitTwo = subtractTimes(mileTwo,MileOne);
        splitThree = subtractTimes(finish,mileTwo);

        //displays summery
        System.out.println("Name: " + firstName + " " +lastName);
        System.out.println("MileOne: " + convertToTime(covertToSeconds(MileOne)));
        System.out.println("SplitTwo: " + splitTwo);
        System.out.println("SplitThree: " + splitThree);
        System.out.println("Finish Time: " + convertToTime(covertToSeconds(finish)));
    }
    /**
     * 
     * @param endTime
     * @param startTime
     * @return the endTime subtracted from the startTime
     */
    private static String subtractTimes(String endTime, String startTime) {
        //coverts the times from min:sec.millisec to sec
        double endTimeInSeconds = covertToSeconds(endTime);
        double startTimeInSeconds = covertToSeconds(startTime);

        //gets the split in seconds
        double diffInSeconds = endTimeInSeconds-startTimeInSeconds;

        //returns split in min:sec.millisec format
        return convertToTime(diffInSeconds);  
    }
    /**
     * @param seconds
     * @return format min.sec.millisec
     */
    private static String convertToTime(double seconds) { 
        //gets the minutes my dividing seconds/60 and casting it to an int
        // gets the seconds by modding the variable seconds by 60
        return String.format("%d:%06.3f", ((int) seconds/60), seconds%60);
        

    }
    /**
     * 
     * @param time
     * @return from min:sec.millisec format to seconds
     */
    private static double covertToSeconds(String time) {
        //if there are no minutes return the current value (which will already be in seconds)
        if (time.indexOf(":")==-1){
            return Double.parseDouble(time);
        }
        //gets the minutes by getting the characters before the ":"
        double minutes = Double.parseDouble(time.substring(0,time.indexOf(":")));
        //gets the seconds by getting the characters after the ":"
        return (minutes*60)+Double.parseDouble(time.substring(time.indexOf(":")+1));
    }
    
}