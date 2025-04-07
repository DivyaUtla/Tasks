import java.util.ArrayList;
import java.util.List;
//reduce() is used to reduce a stream of elements into a single value — like sum, finding the product, concatenating strings, etc.

public class Sum {
//to find sum of integers
    public static int SumOfIntegers(List<Integer> list){
        return list.stream().reduce(0, (a,b)->a+b);
        //return list.stream().reduce(0, Integer::sum);
    }

//to find product 
    public static int ProductOfIntegers(List<Integer> list){
        return list.stream().reduce(1, (a,b)->a*b);
    }

//Concatenation
    public static String Concatenation(List<String> words){
        return words.stream().reduce("", (a,b)->a+b);
        //return words.stream().reduce("",String::concat);
    }
        

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4);

        List<String> words=new ArrayList<>();
        words.add("java8"); words.add("Stream()"); words.add("reduce()");

        System.out.println("Sum : " + SumOfIntegers(list));
        System.out.println("Product : " + ProductOfIntegers(list));
        System.out.println("Concatenation : " + Concatenation(words));
    }
}
