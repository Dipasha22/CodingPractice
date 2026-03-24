package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        
    
      int []arr={5,3,7,6,2};
        System.out.println("Before: "+Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("After: "+Arrays.toString(arr));
    }

}
