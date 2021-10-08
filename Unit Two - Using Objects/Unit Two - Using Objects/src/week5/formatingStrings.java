package week5;

public class formatingStrings {
    public static void main(String[] args) {
        // 5:07.345

        int min = 5;
        double seconds=7.5;
        System.out.println(min + ":" + seconds);

        System.out.printf("%d:%06.3f", min, seconds);

    }
    
}
