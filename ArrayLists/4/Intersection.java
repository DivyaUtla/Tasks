//ASK : Find the intersection of two ArrayLists

import java.util.ArrayList;
import java.util.Scanner;

class ArrayIntersection{
    public static ArrayList<Integer> findIntersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2){

        if(arr1.isEmpty() || arr2.isEmpty()){
            System.out.println("Array is Empty");
        }

        ArrayList<Integer> resultArray = new ArrayList<>();

        //for(int i=0;i<arr1.size();i++){
        //    for(int j=0;j<arr2.size();j++){
        //        if(arr1.get(i) == arr2.get(j)){
        //            resultArray.add(arr1.get(i));
        //        }
        //    }
        //}

//similar to dups bcz intersection of 2 arrays include only the common elements i.e., dups
for(int i=0;i<arr2.size();i++){ //loop go thorugh arr2 and it will check if the elements in arr2 are available in arr1 and added to result array
    if(arr1.contains(arr2.get(i))){
        resultArray.add(arr2.get(i));
    }
}
    return resultArray;
    }
}

public class Intersection{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the Size of first Array : ");
        int n1=sc.nextInt();

        System.out.println("Enter the Size of Second Array : ");
        int n2=sc.nextInt();

        if (n1 <= 0 || n2<=0) { // when size of array is zero or negative it will print array is emply and close
            System.out.println("Array is empty");
            sc.close();
            return;
        }

        ArrayList<Integer> arr1=new ArrayList<>(n1);
        System.out.println("Enter the elements of the first array : ");
        for(int i=0;i<n1;i++){
            arr1.add(sc.nextInt());
        }

        ArrayList<Integer> arr2=new ArrayList<>(n2);
        System.out.println("Enter the elements of the Second array : ");
        for(int i=0;i<n2;i++){
            arr2.add(sc.nextInt());
        }

        ArrayList<Integer> resultArray=ArrayIntersection.findIntersection(arr1, arr2);

        System.out.println("Final Array after removing Duplicates : ");
        System.out.println(resultArray);
    }
}