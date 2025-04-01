//ASK : Find the kth smallest element in an ArrayList

import java.util.Arrays;
import java.util.Scanner;

class FindSmallest{
    public static int FindKthSmallest(int[] arr, int k){
        //Adding Edge case
        if(k<1 || k>arr.length){
            throw new IllegalArgumentException("K value is not valid");
        }

        Arrays.sort(arr);
        return arr[k-1];
        
        //im sorting arrays in ascending order

        // since array starts with 0 nexts i want to find Kth smallest element so used K-1 
        //Example: int[] arr ={23,3,89,7,56,99,1}; and want to find K=4 smasllest element
        //arr={1,3,7,23,56,89,99} so 4th smallest element is 23 so arr[3]=23
        //if K=1 then arr[0]=1
        //if K=2 then arr[1]=3
        //if K=3 then arr[2]=7
        //if K=4 then arr[3]=23
        //if K=5 then arr[4]=56
        //if K=6 then arr[5]=89
        //if K=7 then arr[6]=99

    }
}

public class KthElement{
    public static void main(String[] args){
       // int[] arr ={23,3,89,7,56,99,1};
       //FindSmallest.FindKthSmallest(arr, 4);

       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the size of the array : ");
       int n=sc.nextInt();
       int[] arr=new int[n];
       System.out.println("Enter the elements of the array : ");
       for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
       }
       System.out.println("Enter K value : ");
       int k=sc.nextInt();
       int result=FindSmallest.FindKthSmallest(arr, k);
       System.out.println("The Smallest " + k + " Element is : " +result);
    }
}
