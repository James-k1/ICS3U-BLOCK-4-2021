package week11;

public class forEachExamples {
    public static void main(String[] args) {
        int[] arr = {80,95,10,60,35,10,25};
        for (int el : arr) {
            //System.out.println(el);

            
        }
        String[] names = {"brad","chad","Ave","kayhan","MathMan","TrianglesSuck"};
        int numVowels = 0;
        String vowels = "AEIOUaeiou";
        for (String name: names) {
            for (int i = 0; i < name.length(); i++) {
                String letter = name.substring(i, i++);
                if (vowels.indexOf(letter)!=-1){
                    numVowels++;
                }
                
            }
            
        }
        System.out.println(numVowels);
    }
    
}
