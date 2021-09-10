package week1;

/**
 * integer vs double math
 */

public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87; //declared three interger variable and assigned them values
        double average = (markOne+markTwo+markThree)/3.0; // 242/3=80 242/3.0=80.666666666667
        System.out.println("the average is " + average);

        // average = (markOne+markTwo+markThree)/3; // 242/3=80 242/3.0=80.666666666667
        // System.out.println("the average is " + average);
        System.out.println(4/5); // this is 0
        System.out.println(4.0/5); // 0.8
        System.out.println(5/4); //1
        System.out.println(5/4.0); //1.25

        // Modulus operator %
        System.out.println(13/3); // = 4
        System.out.println(13%3); // 13 mod three = 1
        
    }
    
}
