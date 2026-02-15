import java.util.*;

public class Sortbyfreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string:");
        String str = sc.nextLine();
     
        String[] arr = str.split(" ");
        int n = arr.length;
        
        // Bubble sort: compare adjacent pairs by their frequencies
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int freq1 = getFrequency(arr, j);
                int freq2 = getFrequency(arr, j + 1);
                if (freq1 < freq2) {
                    // Swap if freq1 < freq2 (descending order)
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "(" + getFrequency(arr, i) + ") ");
        }
        System.out.println();
    }
    
    // Helper: count frequency of word at index i in arr
    private static int getFrequency(String[] arr, int i) {
        int cnt = 1;
        for (int k = i + 1; k < arr.length; k++) {
            if (arr[i].equals(arr[k])) {
                cnt++;
            }
        }
        return cnt;
    }
  
}
// Output:
// enter a string:
// hellllooo i am java java java heill hii
// java(3) java(2) hellllooo(1) i(1) am(1) java(1) heill(1) hii(1) 