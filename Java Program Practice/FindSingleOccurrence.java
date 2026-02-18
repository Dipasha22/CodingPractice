import java.util.*;

public class FindSingleOccurrence {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,11,33,77,99,11,22,44,66,77};
        boolean[] visited = new boolean[arr.length];
        int count1 = 0, count2 = 0;
        int element1 = -1, element2 = -1;
        
        // Find first element that appears once
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
                count1 = 1;
                element1 = arr[i];
                break;
            }
        }
        
        // Find second element that appears once (continue from where we left)
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
                count2 = 1;
                element2 = arr[i];
                break;
            }
        }
        
        System.out.println("Elements appearing once:");
        if(count1 == 1) System.out.println(element1);
        if(count2 == 1) System.out.println(element2);
    }
}
