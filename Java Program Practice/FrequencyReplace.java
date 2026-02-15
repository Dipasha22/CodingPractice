 import java.util.*;

public class FrequencyReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string:");
        String str = sc.nextLine();
    
        String[] arr = str.split(" ");
        int n = arr.length;
        
        // First pass: Replace each word with its frequency
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            int freq = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i].equals(arr[j])) {
                    freq++;
                    visited[j] = true;
                }
            }
            // Replace all occurrences with frequency
            for (int j = i; j < n; j++) {
                if (!visited[j] && arr[i].equals(arr[j])) {
                    arr[j] = String.valueOf(freq);
                    visited[j] = true;
                }
            }
            visited[i] = true;
        }
        
        // Bubble sort: now array contains frequencies, sort descending
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int freq1 = Integer.parseInt(arr[j]);
                int freq2 = Integer.parseInt(arr[j + 1]);
                if (freq1 < freq2) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        // Print sorted frequencies
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Output:
// enter a string:
// hiii i am java programmer
// 1 1 1 1 1 

