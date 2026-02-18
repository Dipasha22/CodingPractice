import java.util.*;

public class CheckDuplicatesK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array elements (space separated): ");
        String input = sc.nextLine();
        String[] strArr = input.split(" ");
        
        System.out.print("Enter k distance: ");
        int k = sc.nextInt();
        
        // Convert to int array
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        if (checkDuplicatesWithinK(arr, k)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    public static boolean checkDuplicatesWithinK(int[] arr, int k) {
        int n = arr.length;
        
        // Check each element against next k elements
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && (j - i) <= k; j++) {
                if (arr[i] == arr[j]) {
                    return true;  // Found duplicate within k distance
                }
            }
        }
        return false;
    }
}
