import java.util.*;

public class UniqueReverse {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,11,33,77,99,11,22,44,66,77};
        boolean[] visited = new boolean[arr.length];
        
        // Collect unique elements in reverse order
        System.out.print("Unique elements in reverse order: ");
        for(int i = arr.length-1; i >= 0; i--) {
            if(visited[i]) continue;
            
            int cnt = 1;
            for(int j = i-1; j >= 0; j--) {
                if(arr[i] == arr[j]) {
                    cnt++;
                    visited[j] = true;
                }
            }
            visited[i] = true;
            
            if(cnt == 1) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
