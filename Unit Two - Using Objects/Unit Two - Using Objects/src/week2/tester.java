package week2;

public class tester {
    public static void main(String[] args) {
        Student test = new Student("test","1234",9);
        String name = test.getName();
        double temp = Math.random()*(name.length());
        int charactor = (int)temp;
        String partOne = name.substring(0, charactor);
        String partTwo = name.substring(charactor+1,(name.length()));
        System.out.println(partOne+partTwo);




    }
    
}
