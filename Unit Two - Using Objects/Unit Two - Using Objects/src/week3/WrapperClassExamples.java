package week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(7);
        Double d = new Double(3.4);
    
        Integer num = 7;  //auto-boxing
        int x = new Integer(7); //auto-unboxing
    
        int z = num.intValue();
        z = num;
    
        double f = d;
        f = d.doubleValue();
        
    }

    
}
