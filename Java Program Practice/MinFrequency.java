 import java.util.*;

class MinFrequency {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 8, 5, 6, 8, 9, 4, 10};
        boolean[] b = new boolean[a.length];
        System.out.println(Arrays.toString(a));
        
        int min = Integer.MAX_VALUE;  // Start high for min
        int min2 = Integer.MAX_VALUE;
        int eleMin = 0;
        int elemin2 = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (b[i]) continue;
            int cnt = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    cnt++;
                    b[j] = true;
                }
            }
            
            // Update minimum
            if (cnt < min) {
                min2 = min;        
                elemin2 = eleMin;  
                min = cnt;
                eleMin = a[i];
            } 
            // Update second minimum (only if different frequency and not current min)
            else if (cnt < min2 && cnt > min) {
                min2 = cnt;
                elemin2 = a[i];
            }
        }
        
        System.out.println("Min ele: " + eleMin);
        System.out.println("Min freq: " + min);
        System.out.println("Second min ele: " + elemin2);
        System.out.println("Second min freq: " + min2);
    }
}

