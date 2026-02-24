package Sorting;
import java.util.Arrays;
class SelectionSort
{
	public static void main(String[] args) {
		int [] arr={9,5,3,2,6,1,4};
		System.out.println("Before:; "+Arrays.toString(arr));
		selectionSort(0,arr,arr.length);
		System.out.println("After:; "+Arrays.toString(arr));


	}
	public static void selectionSort(int i, int [] arr, int n)
	{
		if(i>n-1) return;
		inneriteration(i,i+1,arr,i,n);
		selectionSort(++i,arr,n);
	}
	public static void inneriteration(int min,int j, int []arr, int i,int n)
	{
		if(j>n-1) return;
		if(arr[min]>=arr[j])
			min=j;
		int temp= arr[min];
		arr[min]=arr[i];
		arr[i]=temp;

		inneriteration(i,++j,arr,i,n);

		
	}
}