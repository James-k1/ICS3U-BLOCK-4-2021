package week3;

public class RandomNumExamples {
    public static void main(String[] args) {
        // for (int i = 0; i<100;i++){
        //     System.out.println((int)(Math.random()*10)+1);
        // }
        double r = Math.random();
        System.out.println(r);

        int lower = -5;
        int upper = 5;

        int rand = (int)(r*(upper-lower+1))+lower;

        String str = "Random Numbers";

        int index=(int)(Math.random()*str.length());
        str = str.substring(0, index) + "x" + str.substring(index+1);
        System.out.println(str);

       }
    
}
