
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Scanner;

// ASK : Write a program to remove duplicates from an ArrayList with java 8
//In java 8  
// distinct - to remove dups  
//.collect(Collectors.toList()) -  to store the result
//stream() - allowing efficient data transformations without modifying the original data
//Stream operations like .map(), .filter(), and .forEach()
//List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println); 

class Duplicates{
    public static ArrayList<Integer> removeDups(ArrayList<Integer> arr){
        ArrayList<Integer>  resultArray= (ArrayList<Integer>) arr.stream()
                                                                    .distinct() // to remove dups
                                                                        .collect(Collectors.toList()); // to store in new list

    return resultArray;
    }
}

public class RemoveDupsJava8 {
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
