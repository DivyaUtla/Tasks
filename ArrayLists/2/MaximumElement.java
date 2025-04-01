//Ask : Find the maximum element from an ArrayList of Integers 

import java.util.ArrayList;
import java.util.Scanner;

class MaxElement{
    public static int FindMaxElement(ArrayList<Integer> arr){
        //Edge case
        if(arr.isEmpty()){
            System.out.println("Array is empty");
        }

        int max=arr.get(0);
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)>max){
                max=arr.get(i);
            }
        }
        return max;
    }
}

public class MaximumElement{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n=sc.nextInt();
        if (n <= 0) { // when size of array is zero or negative it will print array is emply and close
            System.out.println("Array is empty");
            sc.close();
            return;
        }
        ArrayList<Integer> arr= new ArrayList<>(n);
        System.out.println("Enter the elements of the array : ");
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        int result=MaxElement.FindMaxElement(arr);
        System.out.println("Maximum Element in the given ArrayList is : " + result);
    }
}