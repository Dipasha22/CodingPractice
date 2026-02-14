import java.util.*;


public class charProgram14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter a string:");
        String str = sc.next();

        frequencyElement(str);
        System.out.println(distinctElemt(str));
        System.out.println(uniqueElement(str));
        System.out.println(duplicateElemt(str));
        maxMinRepeating(str);

    }

    public static void frequencyElement(String str) {
        System.out.println("***Frequency count***");
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        boolean[] b = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;
                    b[j] = true;
                }
            }
            System.out.println(arr[i] + ": " + cnt);// freq

        }
    }

    public static String distinctElemt(String str) {
        System.out.println("\n***Distinct Element");
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        String dis = "";
        boolean[] b = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
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
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        boolean[] b = new boolean[arr.length];
        String uniq = "";

        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
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
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        boolean[] b = new boolean[arr.length];
        String dup = "";
        for (int i = 0; i < arr.length; i++) {
            if (b[i])
                continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
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
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        boolean[] b = new boolean[arr.length];

        int max1 = 0, max2 = 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        char maxChar1 = ' ', maxChar2 = ' ';
        char minChar1 = ' ', minChar2 = ' ';

        for (int i = 0; i < arr.length; i++) {

            if (b[i])
                continue;

            int cnt = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
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

        System.out.println("\n1st Max Repeating Character: " + maxChar1 + " (Count: " + max1 + ")");
        System.out.println("2nd Max Repeating Character: " + maxChar2 + " (Count: " + max2 + ")");
        System.out.println("1st Min Repeating Character: " + minChar1 + " (Count: " + min1 + ")");
        System.out.println("2nd Min Repeating Character: " + minChar2 + " (Count: " + min2 + ")");
    }

}
//Output
// enter a string:
// hellllooo
// ***Frequency count***
// h: 1
// e: 1
// l: 4
// o: 3

// ***Distinct Element
// h e l o 

// ***Unique element***
// h e

//  ***Duplicate element***
// l o

//  ***max min***

// 1st Max Repeating Character: l (Count: 4)
// 2nd Max Repeating Character: o (Count: 3)
// 1st Min Repeating Character: h (Count: 1)
// 2nd Min Repeating Character: o (Count: 3)