package week11;

public class SortingAlgorithems{

    public static void main(String[] args) {
        
        int[] arr = {45,34,75,12,76,34};
        selectionSort(arr);
        insertionSort(arr);
        
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // sort the nex element
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && temp<arr[j-1] ; j--) { // shifting is done
                arr[j]=arr[j-1];
                
            }
            arr[j]=temp;

            
        }
    }






    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) { // sort the next element
            int smallestIndex = i;
            for (int j = i+1; j < arr.length; j++) { // where is the smallest 
                if (arr[j]<arr[smallestIndex]){
                    smallestIndex = j;
                }
                
            }
            int temp = arr[i];
            arr[i]= arr[smallestIndex];
            arr[smallestIndex]=temp;
            
        }
    }
}