//ASK : Remove all duplicate elements from an ArrayList

import java.util.ArrayList;
import java.util.Scanner;

class Duplicates{ 

public static ArrayList<Integer> removeDups(ArrayList<Integer> arr){
    //edge case
    if(arr.isEmpty()){
        System.out.println("Array is empty");
    }

    ArrayList<Integer> resultArray=new ArrayList<>();//created empty list to store the elements  after removing dups

    for(int i=0;i<arr.size();i++){
        if(!resultArray.contains(arr.get(i))){//it will check the elements presnt already in result array 
            resultArray.add(arr.get(i)); // im adding unique elements to result array
        }
    }
return resultArray;
}

}

public class RemoveDups{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the Size of Array : ");
        int n=sc.nextInt();

        if (n <= 0) { // when size of array is zero or negative it will print array is emply and close
            System.out.println("Array is empty");
            sc.close();
            return;
        }

        ArrayList<Integer> arr=new ArrayList<>(n);
        System.out.println("Enter the elements of the array : ");
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }

        ArrayList<Integer> resultArray=Duplicates.removeDups(arr);

        System.out.println("Final Array after removing Duplicates : ");
        System.out.println(resultArray);
    }
}