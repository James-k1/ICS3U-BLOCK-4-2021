package week5;

public class forloops {
    public static void main(String[] args) {
        String str = "testthingy";
        String back = "";
        for (int i = 0; i < str.length();i++){
            back = str.substring(i,i+1) + back;
        }
        System.out.println(back);

    }
    
}
