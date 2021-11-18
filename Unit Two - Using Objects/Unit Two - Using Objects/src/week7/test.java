package week7;

public class test {
    public static void main(String[] args) {
        System.out.println(backwards("Banana"));
        
    }
    public static String backwards(String str){
        String back = "";
        for (int i=0; i < str.length(); i++){
            back = str.substring(i,i+1) + back;
            
        }
        return back;
    }
    
}
