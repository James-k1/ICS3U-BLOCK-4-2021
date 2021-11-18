package week10;

public class iHaveNoIdea {
    public static void main(String[] args) {
      int[] arr = {9, 9, 0, 9, 0, 9};
        int[] idc = zeroFront(arr);
        
    }
    public static int[] zeroFront(int[] nums) {
      int[] open = new int[nums.length];
      int numOpen = 0;
      int used = 0;
      for(int i = 0;i<nums.length;i++){
        if (nums[i]!=0){
          
          open[numOpen+used]=i;
          numOpen++;
          
        }
        if (numOpen!=0&&nums[i]==0){
          int temp = nums[open[0+used]];
          nums[open[0+used]]=0;
          nums[i]=temp;
          used++;
          numOpen--;
          i--;
          
        }
        
      }
      return nums;
    }
    
      
    
}
