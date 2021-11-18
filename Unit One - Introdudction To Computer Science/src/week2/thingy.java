package week2;

public class thingy {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1};
        String[] idc = fizzBuzz(1, 6);
        
        
    }
    
    public static String[] fizzBuzz(int start, int end) {
      String[] arr = new String[end-start];
      for (int i = 0; i<(end-start); i++){
        if (i+start%3==0&&i+start%5==0){
        arr[i] = "FizzBuzz";
        }else if (i+start%3==0){
          arr[i] = "Fizz";
          
        }
        else if (i+start%5==0){
          arr[i] = "Buzz";
        }
        else{
          arr[i]=String.valueOf(i+start);
        }
      }
      return arr;
    }
  }




