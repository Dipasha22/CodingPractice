import java.util.*;

class Maxfrequency {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 8, 5, 6, 8, 9, 4, 10};
        boolean[] b = new boolean[a.length];
        System.out.println(Arrays.toString(a));
        
        int max = 0;  // Start from 0 since count >=1
        int max2 = 0;
        int eleMax = 0;
        int elemax2 = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (b[i]) continue;
            int cnt = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    cnt++;
                    b[j] = true;
                }
            }
            
            // Update maximum
            if (cnt > max) {
                max2 = max;        
                elemax2 = eleMax;  
                max = cnt;
                eleMax = a[i];
            } 
            else if (cnt > max2 && cnt < max) {
                max2 = cnt;
                elemax2 = a[i];
            }
        }
        
        System.out.println("Max ele: " + eleMax);
        System.out.println("Max freq: " + max);
        System.out.println("Second max ele: " + elemax2);
        System.out.println("Second max freq: " + max2);
    }
}

