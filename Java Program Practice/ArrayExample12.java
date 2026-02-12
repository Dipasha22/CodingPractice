
// import  java.util.*;

// class InvalidIndexException extends RuntimeException
// {
// 	InvalidIndexException (String msg)
// 	{
// 		super(msg);
// 	}
// }
// class ArrayExample12
// {

// 	public static void main(String[] args) {
// 		int []a= {1,2,3,4,5,6};
// 		System.out.println(Arrays.toString(a));
// 		Scanner sc= new Scanner(System.in);

// 		System.out.println("Enter the index to delete: ");
// 		int indx=sc.nextInt();

// 		if(indx<0 || indx>a.length)
// 		{
// 			throw new InvalidIndexException("Index: "+indx+"is a invalid index");
// 		}

// 			int [] newArr=new int[a.length-1];
// 			for(int i=0,j=0;i<a.length;i++)
// 			{
// 				newArr[j++]=a[i];
// 			}
// 		System.out.println(Arrays.toString(newArr));

// 		}
// }
	
// import java.util.*;

// class ClockwiseRotation
// {
// 	public static void main(String[] args) {
// 		int [] arr={1,2,3,4,5,6,7};

// 		System.out.println(Arrays.toString(arr));
// 		System.out.println("Enter the no. of rotation");
// 		int roatation=new Scanner(System.in).nextInt();
// 		for(int j=1;j<=roatation;j++)
// 		{
// 			int temp=arr[arr.length-1];
// 			for(int i=arr.length-2;i>=0;i--)
// 			{
// 				arr[i+1]=arr[i];
// 			}
// 			arr[0]=temp;
// 		}
// 		System.out.println(Arrays.toString(arr));

// 	}
// }

// import java.util.*;

// class AntiClockwiseRotation
// {
// 	public static void main(String[] args) {
// 		int [] a={1,2,3,4,5,6,7};

// 		System.out.println(Arrays.toString(a));
// 		System.out.println("Enter the no. of rotation");
// 		int roatation=new Scanner(System.in).nextInt();
// 		for(int j=1;j<=roatation;j++)
// 		{
// 			int temp=a[0];
// 			for(int i=1;i<a.length;i++)
// 			{
// 				a[i+1]=a[i];
// 			}
// 			temp=a[a.length-1];
// 		}
// 		System.out.println(Arrays.toString(a));

// 	}
// }


// //MovesZeros (LeetCode)
// import java.util.*;

// class AntiClockwiseRotation
// {
// 	public static void main(String[] args) {
// 		int [] a={4,0,3,0,2,1,0,7};

// 		System.out.println(Arrays.toString(a));
// //i
// //j 
// //ele 	4	0	3	0	2 	1 	0 	7
// //indx 	0 	1 	2 	3 	4 	5	6 	7
// 		int i=0,j=0;
// 		while(i<a.length)
// 		{
// 			if(a[i]!=0)
// 			{
// 				a[j]=a[i];
// 				j++;
// 			}
// 			i++;
// 		}
// 		while(j<a.length)
// 		{
// 			a[j]=0;
// 			j++;
// 		}
// 		System.out.println(Arrays.toString(a));

// 	}
// }

// sort even and odd
//import java.util.*;

// class AntiClockwiseRotation
// {
// 	public static void main(String[] args)
// 	 {
// 		int []a={1,2,3,4,5,6,7,8};
// 			int temp;
// 			int j=a.length-1;
// 			int i=0;
			
// 			while(i<j)
// 			{
// 				if(a[i]%2!=0 )
// 				{
// 					i++;
// 				}
				

// 				else if(a[i]%2==0)
// 				{
// 					j--;
// 				}
// 				else{
// 					temp=a[i];
// 				a[i]=a[j];
// 				a[j]=temp;
// 				i++;
// 				j--;
// 				}
			
// 			}
// 				System.out.println(Arrays.toString(a));
			

// 		}

		
// 	}

// //reversing the array element {1 2 3 4 5 6 7}->>{7 6 5 4 3 2 1}
// import java.util.*;

// class AntiClockwiseRotation
// {
// 	public static void main(String[] args) {
// 		int [] a={1,2,3,4,5,6,7};
// 		int i=0,j=a.length-1;
// 		while(i<j)
// 		{
// 			int temp=a[i];
// 			a[i]=a[j];
// 			a[j]=temp;
// 			i++;
// 			j--;
// 		}
// 		System.out.println(Arrays.toString(a));
// 	}
// }


// //reversing even indexes
//  import java.util.*;

//  class AntiClockwiseRotation
// {
// 	public static void main(String[] args) {
// 		int [] a={1,2,3,4,5,6,7};
// 		int i=0;
// 		int j=a.length%2==0?a.length-2:a.length-1;
// 		while(i<j)
// 		{
// 			if(i%2==0 && j%2==0){
// 		int temp=a[i];
//  			a[i]=a[j];
// 		a[j]=temp;
// 			}
// 			i+=2;
// 			j-=2;
// 		}
// 		System.out.println(Arrays.toString(a));
// 	}
// }
// //reversing odd elements
//  import java.util.*;

//  class AntiClockwiseRotation
// {
// 	public static void main(String[] args) {
// 		int [] a={1,2,3,4,5,6,7,8};
// 		// Replace Step 1 with:
// int left = 0, right = a.length - 1;
// while (left < right) {
//     while (left < right && a[left] % 2 == 1) left++;
//     while (left < right && a[right] % 2 == 0) right--;
//     if (left < right) {
//         int temp = a[left];
//         a[left] = a[right];
//         a[right] = temp;
//         left++; right--;
//     }
// }
// // Now odds are at end (indices 4-7), reverse them:
// int oddLeft = left, oddRight = a.length - 1;
// while (oddLeft < oddRight) {
//     int temp = a[oddLeft];
//     a[oddLeft] = a[oddRight];
//     a[oddRight] = temp;
//     oddLeft++; oddRight--;
// }
//  		System.out.println(Arrays.toString(a));
	
// 	}
// }



// import java.util.*;

// class NegativeEnd {
//     public static void main(String[] args) {
//         int[] a = {4, -1, 3, -2, 0, -5, 7, -8};
//         System.out.println("Original: " + Arrays.toString(a));
        
      
     
  
//         int left = 0, right = a.length - 1;
        
//         while (left < right) {
//             // Skip positives on left, negatives on right
//             while (left < right && a[left] >= 0) left++;
//             while (left < right && a[right] < 0) right--;
            
//             // Swap negative-left with positive-right
//             if (left < right) {
//                 int temp = a[left];
//                 a[left] = a[right];
//                 a[right] = temp;
//                 left++;
//                 right--;
//             }
//         }
//            System.out.println("Negatives end: " + Arrays.toString(a));
//     }
// }

// import java.util.*;

// class GreaterThanKRight {
//     public static void main(String[] args) {
//         int[] a = {4, 2, 9,  7, 3, 8, 5};
//         int k = 3;
        
//         System.out.println("Original: " + Arrays.toString(a));
       

//         int left = 0, right = a.length - 1;
        
//         while (left <= right) {
//             while (left < right && a[left] <= k) left++;
//             while (left < right && a[right] > k) right--;
            
//             if (left <= right) {
//                 int temp = a[left];
//                 a[left] = a[right];
//                 a[right] = temp;
//                 left++;
//                 right--;
//             }
//         }
//         System.out.println("Result (k=5): " + Arrays.toString(a));

//     }
// }




// import java.util.*;

// class MissingElements {
//     public static void main(String[] args) {
//         int[] a = {1,2,4,6,7,8};
      
//         boolean[] present = new boolean[a.length+ 1];
//         for(int num : a) {
//             if(num >= 1 && num <= a.length)
//                 present[num] = true;
//         }
        
//         System.out.print("Missing: ");
//         for(int i = 1; i <= a.length; i++) {
//             if(!present[i]) {
//                 System.out.print(i + " ");
//             }
//         }
//     }
// }




// import java.util.*;

// class RotationCount {
//     public static void main(String[] args) {
//         int[] a = {15, 18, 2, 3, 6, 12};  // Rotated 2 times
//         System.out.println("Rotations: " + countRotations(a));
//     }
    
//     static int countRotations(int[] a) {
//         int low = 0, high = a.length - 1;
        
//         while (low <= high) {
//             int mid = low + (high - low) / 2;
            
//             // Check if mid is minimum (pivot)
//             if (mid > 0 && a[mid] < a[mid - 1]) {
//                 return mid;  // Rotated mid times
//             }
            
//             // Check if right side is sorted → pivot in left
//             if (a[low] <= a[mid]) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;  
//             }
//         }
//         return 0;  
//     }
// }


// import java.util.*;

// class FirstHalfRotate {
//     public static void main(String[] args) {
//         int[] a = {1,2,3,4,5,6,7,8};
//         System.out.println("Original: " + Arrays.toString(a));
        
     
  
//         int n = a.length;
//         int mid = n / 2;  // First half size
        
//         // Store first element of first half
//         int first = a[0];
        
//         // Shift first half left by 1
//         for (int i = 0; i < mid - 1; i++) {
//             a[i] = a[i + 1];
//         }
        
//         // Put first element at end of first half
//         a[mid - 1] = first;


//         System.out.println("First half rotated: " + Arrays.toString(a));

//     }
// }


import java.util.*;

class CheckSorted {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7};      
        int[] b = {1, 4, 3, 5, 7};      
        
        System.out.println("a sorted: " + isSorted(a));  // true
        System.out.println("b sorted: " + isSorted(b));  // false
    }
    
    static boolean isSorted(int[] a) {
        if (a.length <= 1) return true;
        
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
