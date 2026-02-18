import java.util.*;

public class GreaterThanFrequency {
    public static void main(String[] args) {
        int[] arr = {3,2,3,3,1,1,2,3,4,5};
        boolean[] visited = new boolean[arr.length];
        int count = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            
            int freq = 1;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    freq++;
                    visited[j] = true;
                }
            }
            visited[i] = true;
            
            // Check if element value > its frequency
            if(arr[i] > freq) {
                count++;
                System.out.println(arr[i] + " > " + freq);
            }
        }
        
        System.out.println("Number of elements greater than their frequency: " + count);
    }
}
