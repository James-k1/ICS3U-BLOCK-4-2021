package week6;

public class NestedLoops {
    public static void main(String[] args) {
        for (int i = 1; i<=5; i++){
            for (int j=1; j<=10;j++){
                System.out.printf("%5d", i*j);
            }
            System.out.println();
        }
    }
    
}
