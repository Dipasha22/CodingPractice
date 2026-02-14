
import java.util.*;

public class WordExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string:");
        String str = sc.nextLine(); // Use nextLine() for full line with spaces

        frequencyElement(str);
        System.out.println(distinctElemt(str));
        System.out.println(uniqueElement(str));
        System.out.println(duplicateElemt(str));
        maxMinRepeating(str);
    }

    public static void frequencyElement(String str) {
        System.out.println("***Frequency count***");
        String[] arr = str.split(" "); // Split by one or more whitespace
        boolean[] b = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    cnt++;
                    b[j] = true;
                }
            }
            System.out.println(arr[i] + ": " + cnt);
        }
    }

    public static String distinctElemt(String str) {
        System.out.println("\n***Distinct Element");
        String[] arr = str.split(" ");
        String dis = "";
        boolean[] b = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    cnt++;
                    b[j] = true;
                }
            }
            dis += arr[i] + " ";
        }
        return dis;
    }

    public static String uniqueElement(String str) {
        System.out.println("\n***Unique element*** ");
        String[] arr = str.split(" ");
        boolean[] b = new boolean[arr.length];
        String uniq = "";
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    cnt++;
                    b[j] = true;
                }
            }
            if (cnt == 1)
                uniq += arr[i] + " ";
        }
        return uniq;
    }

    public static String duplicateElemt(String str) {
        System.out.println("\n ***Duplicate element*** ");
        String[] arr = str.split(" ");
        boolean[] b = new boolean[arr.length];
        String dup = "";
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    cnt++;
                    b[j] = true;
                }
            }
            if (cnt > 1)
                dup += arr[i] + " ";
        }
        return dup;
    }

    public static void maxMinRepeating(String str) {
        System.out.println("\n ***max min*** ");
        String[] arr = str.split(" ");
        boolean[] b = new boolean[arr.length];
        int max1 = 0, max2 = 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        String maxChar1 = "", maxChar2 = "";
        String minChar1 = "", minChar2 = "";
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    cnt++;
                    b[j] = true;
                }
            }
            // Maximum repeating
            if (cnt > max1) {
                max2 = max1;
                maxChar2 = maxChar1;
                max1 = cnt;
                maxChar1 = arr[i];
            } else if (cnt > max2 && cnt != max1) {
                max2 = cnt;
                maxChar2 = arr[i];
            }
            // Minimum repeating
            if (cnt < min1) {
                min2 = min1;
                minChar2 = minChar1;
                min1 = cnt;
                minChar1 = arr[i];
            } else if (cnt < min2 && cnt != min1) {
                min2 = cnt;
                minChar2 = arr[i];
            }
        }
        System.out.println("\n1st Max Repeating Word: " + maxChar1 + " (Count: " + max1 + ")");
        System.out.println("2nd Max Repeating Word: " + maxChar2 + " (Count: " + max2 + ")");
        System.out.println("1st Min Repeating Word: " + minChar1 + " (Count: " + min1 + ")");
        System.out.println("2nd Min Repeating Word: " + minChar2 + " (Count: " + min2 + ")");
    }
}
//Output
// enter a string:
// hello i love java programming java is easy java is object oriented programmning
// ***Frequency count***
// hello: 1
// i: 1
// love: 1
// java: 3
// programming: 1
// is: 2
// easy: 1
// object: 1
// oriented: 1
// programmning: 1

// ***Distinct Element
// hello i love java programming is easy object oriented programmning

// ***Unique element***
// hello i love programming easy object oriented programmning       

//  ***Duplicate element***
// java is

//  ***max min***

// 1st Max Repeating Word: java (Count: 3)
// 2nd Max Repeating Word: is (Count: 2)
// 1st Min Repeating Word: hello (Count: 1)
// 2nd Min Repeating Word: is (Count: 2)