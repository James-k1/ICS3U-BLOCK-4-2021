package week9;

public class shapeDiver {
    public static void main(String[] args) {
        rectangle b1 = new box(4,4,5);
        b1.getArea();

        rectangle r1 = new rectangle(5,3);
        rectangle r2 = new rectangle(6);

        if (r1.isSquare()){
            System.out.println("r1 is a square");
        }else{
            System.out.println("r1 is not a square");;
        }
        
        if (r2.isSquare()){
            System.out.println("r2 is a square");
        }else{
            System.out.println("r2 is not a square");;
        }
        if (r1.equals(r2)){
            System.out.println("they are equal");
        } else{
            System.out.println("they are not equal");
        }

        System.out.println("r1 area " + r1.getArea());
        System.out.println("r1 perimiter " + r1.getPerimeter());
        System.out.println("r2 area " + r2.getArea());
        System.out.println("r2 perimiter " + r2.getPerimeter());

        System.out.println(r1.toString());
        System.out.println(r2.toString());

    }
    
}
