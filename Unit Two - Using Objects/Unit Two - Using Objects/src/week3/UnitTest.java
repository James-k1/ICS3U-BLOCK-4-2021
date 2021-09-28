package week3;

public class UnitTest {
    public static void main(String[] args) {
        
        //System.out.println(threeCopies("hello",1));
        //System.out.println(threeCopies("computer",6));
        System.out.println( removeChars("Computer science", 3, 4));
        System.out.println(sqrtSum(9999));

        
    }
    public static String threeCopies(String str, int index){
        String val = str.substring(index,index+2);
        return val+val+val;

    }
    public static String removeChars(String str,int index,int n){
        String first = str.substring(0,index);
        String second = str.substring(n+index);
        return first+second;
    }
    public static double sqrtSum(int number){
        String str = Integer.toString(number);
        String a = str.substring(0,1);
        String b = str.substring(1,2);
        String c = str.substring(2,3);
        String d = str.substring(3);
        double total = Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c)+Integer.parseInt(d);
        return Math.sqrt(total);
        
    }

    
}
