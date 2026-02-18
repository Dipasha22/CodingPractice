import java.util.*;

public class CountDuplicatePairs {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,11,33,77,99,11,22,44,66,77};
        int count = 0;
        
        // Count all unique pairs of duplicate elements
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }
        }
        
        System.out.println("Total duplicate pairs: " + count);
    }
}

//Total duplicate pairs: 7