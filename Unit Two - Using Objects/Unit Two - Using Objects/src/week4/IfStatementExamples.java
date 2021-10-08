package week4;

public class IfStatementExamples {
    public static void main(String[] args) {
        //exampleOne();
        exampleThree();
        String letterGrade=getLetterGrade(78);
        

        
    }

    private static void exampleThree() {
        

    }

    private static String getLetterGrade(int mark) {
        if (mark>=90){
            return "A+";
        }
        else if (mark>=80){
            return "A";
        }
        else if (mark>=70){
            return "B";
        }
        else if (mark>=60){
            return "C";
        }
        else if (mark>=50){
            return "D";
        }
        else {
            return "F";
        }
        
    }



    private static void exampleOne() {
        int x = 8;

        if (x%2==0){
            System.out.println("x is even");
        }else{
            System.out.println("x is odd");
        }

    }
    
}
