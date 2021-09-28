package week3;

public class HomeWork {
    
    public static void main(String[] args) {
        // (int)(Math.random()*numpossiblities)+startpoint;
        System.out.println(exampleSix("this is a test", "is a te"));
    }

    public static void exampleOne() {

        int randomNum =  (int)(Math.random()*100)+1;
 
        
 
        System.out.println(randomNum);
 
     } 

     public static void exampleTwo() {

        int randomNum = (int)(Math.random()*50)-50;

        System.out.println(randomNum);

     }

     public static void exampleThree() {

        int randomNum = (int)(Math.random()*6)+1;

        System.out.println(randomNum);

     }

     public static int exampleFour(int num1, int num2) {
         
        int randomNum = (int)(Math.random()*(num2-num1+1))+num1; // the plus 1 makes it inclusive

        return randomNum;


     }


     public static String exampleFive(String str){

int temp = str.indexOf("e");


String temp2 = str.substring(0, temp)+str.substring(temp+1);

return temp2;

     }

     public static String exampleSix(String str1, String str2){


        int index = str1.indexOf(str2);

        return str1.substring(0,index)+str1.substring(index+str2.length());

        
     }

     public static int exampleSeven(String str1, String str2) {
         
        int finalVal = str1.length()+str2.length();

        return finalVal;

     }


     public static double exampleEight(double x1, double x2, double y1, double y2) {
         
        double finalVal = (y2-y1)/(x2-x1);

        return finalVal;
     }

     public static double exampleNine(double r, double h) {
         

        double finalVal = Math.PI*r*r*h;

        return finalVal;
     }


     public static String exampleTen(String str){

        int val = (int)(Math.random()*str.length()+1);


        String temp = str.substring(0,val)+str.substring(val+1);

        return temp;



     }









}
