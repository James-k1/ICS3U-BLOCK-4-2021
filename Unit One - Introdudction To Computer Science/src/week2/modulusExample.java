package week2;

public class modulusExample {
    public static void main(String[] args) {
        int num = 5002;

        int num1 = num/1000;
        int num2 = (num/100)%10;
        int num3 = (num/10)%10;
        int num4 = num%10;

        // num2 = num/100 %10; 

        // num3 = num%100/10;
        System.out.println(num1+num2+num3+num4);






    }
    
}
