package Sorting;

import java.util.Arrays;

public class SelectionSortIterative {
    public static void main(String[] args) {
        int[] arr = {9,5,3,2,6,1,4};
        System.out.println("Before: " + Arrays.toString(arr));
        selectionSort(arr, arr.length);
        System.out.println("After: " + Arrays.toString(arr));
    }
    
    public static void selectionSort(int[] arr, int n) {
        for(int i = 0; i < n-1; i++) {      // ✅ Fixed: i < n-1
            int min = i;                    // ✅ Initialize min = i
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[min]) {     // ✅ Fixed: Compare values
                    min = j;
                }
            }
            // ✅ Swap inside outer loop
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
