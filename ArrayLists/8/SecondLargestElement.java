import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Largest{
    public static int LargestElement(List<Integer> list){
        List<Integer> newList=new ArrayList<>(list);// created newList to store the elements from list
        Collections.reverse(newList);
       // Collections.sort(newList, Collections.reverseOrder()); // i want the elemnts to be sorted in descending order so used Collections.reverseOrder()
    return newList.get(1); //since i need the second largest elements so im returning index 1
    }
}

public class SecondLargestElement{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size of list : ");
        int n=sc.nextInt();

        List<Integer> list=new ArrayList<>();
        System.out.println("Enter Elements of the List : ");
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        int result=Largest.LargestElement(list);
        System.out.println("The second Largest Element in the given List : " + result);


        //List<Integer> list=List.of(1,33,14,118,4);
        //int result=Largest.LargestElement(list);
        //System.out.println(result);
    }
}