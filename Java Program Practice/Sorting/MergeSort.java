package Sorting;
import java.util.*;
public class MergeSort {
    public static void main(String [] args)
    {
        int []arr={5,3,7,6,2};
        System.err.println("Before: "+Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.err.println("After: "+Arrays.toString(arr));

    }
    public static void mergeSort(int [] arr, int low , int high){
        if(low<high)
        {
            int mid=low+(high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int[] arr, int left, int mid , int right)
    {
        int leftlen=mid-left+1;
        int rightlen= right-mid;
        int [] larr=new int[leftlen];
        int [] rarr= new int[rightlen];

        for(int i=0;i<leftlen;i++)
        {
            larr[i]=arr[left+i];
        }
        
        for(int i=0;i<rightlen;i++)
        {
            rarr[i]=arr[mid+i+1];
        }
        int i=0, j=0,k=left;
        while(i<leftlen && j<rightlen)
        {
            if(larr[i]<=rarr[j])
            {
                arr[k++]=larr[i++];
            }
            else{
                arr[k++]=rarr[j++];

            }
        }
        while(i<leftlen)
        {
                arr[k++]=larr[i++];

        }
         while(j<rightlen)
        {
                arr[k++]=rarr[j++];

        }
    }
}
