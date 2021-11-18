package week11;
import java.util.Arrays;


public class SerchingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {80,95,10,60,35,10,25};
        int index = linearSearch(arr,35);
        index = linearSearch(arr,36);
        Arrays.sort(arr);

        index = binarSearch(arr,35);

        int[] nums = new int[1000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random()*1000);
        }
        Arrays.sort(nums);
        binarSearch(nums, -1);


        
    }

    private static int binarSearch(int[] arr, int findMe) {
        int lower = 0;
        int upper = arr.length-1;
        int mid;

        int numComparasons = 0;
        while(upper>=lower){
            mid = (upper+lower)/2;
            if (arr[mid]==findMe){
                return mid;
            }else if(arr[mid]>findMe){
                upper = mid-1;
            }
            else{
                lower= mid;
            }
            numComparasons++;

        }
        return -1;
    }

    private static int linearSearch(int[] arr, int element) {
        for (int i = 0; i <arr.length; i++){
            if (arr[i]==element){
                return i;
            }
        }
        return -1;

            
        }
    }
    

