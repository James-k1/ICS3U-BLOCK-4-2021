package week2;

import javax.swing.text.Style;



public class hw1 {
    public static void main(String[] args) {


        /** question 1
        double num = 7.2;
        double numSquared = num*num;
        System.out.println(num + " x" + " " + num + " = " + numSquared);
        */



       //question 2
       /** 
       int overall = 70;
       int score = 40;
       double percentage;
       percentage = ((double) score/overall)*100;
       System.out.println("Score: " + percentage + "%");
       */

    /** question 3
       int num = 12345;
       int num4 = (num/1000)%10;
       int num2 = (num/10)%10;
       System.out.println(num2*num4);
       */

    /**    
    int initVel = 83; //m/s
    int acceleration = 36; //m/s^2
    int time = 2;
    int finalVel = (initVel+acceleration*time);
    System.out.println("final velocity: "+ finalVel);
    */
    /** question 5
    int radius = 6;
    double area = Math.PI*(radius^2);
    System.out.println("Area: "+area);
    */
    
    /** question 6
    int radius = 6;
    double volume = (4/3*Math.PI*(radius^3));
    System.out.println(volume);
    */

    /** question 7
    int a = 4;
    int b = 12;
    int c = 0;
    int x = 8;
    int y = (a*(x*x))+(b*b)+c;
    System.out.println("Y = " + y);
    */

    /** question 8    
    int x1 = 5;
    int x2 = 6;
    int y1 = 2;
    int y2 = 4;
    double slope = ((double)(y1-y2)/(x1-x2));
    System.out.println("the slope is: " +slope);
    */

    /**question 9
    int pennies = 3;
    int nickls = 4;
    int dimes = 5;
    int quarters = 6;
    int loonies = 7;
    int toonies = 8;
    double total = (0.01*pennies)+(0.05*nickls)+(0.1*dimes)+(0.25*quarters)+(loonies)+(2*toonies);
    System.out.println(total);
    */

   int a = 4;
   int b = 12;
   int c = 0;
   double root1 = ((b*-1)+Math.sqrt((b*b)-4*a*c))/(2*a);
   double root2 = ((b*-1)-Math.sqrt((b*b)-4*a*c))/(2*a);

   System.out.println(root1);  

   System.out.println(root2);      
   }
    
    
}
