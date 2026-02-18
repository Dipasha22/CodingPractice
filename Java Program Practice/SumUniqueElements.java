import java.util.*;

public class SumUniqueElements {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,11,33,77,99,11,22,44,66,77};
        boolean[] visited = new boolean[arr.length];
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            
            int cnt = 1;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    cnt++;
                    visited[j] = true;
                }
            }
            visited[i] = true;
            
            if(cnt == 1) {
                sum += arr[i];
            }
        }
        
        System.out.println("Sum of unique elements: " + sum);
    }
}
