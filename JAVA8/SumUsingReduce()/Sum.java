import java.util.ArrayList;
import java.util.Arrays;
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

//Max or Min Integer
    public static int MaxOrMin(List<Integer> list, boolean flag){
        int max= list.stream().reduce(Integer::max).orElseThrow();
        int min= list.stream().reduce(Integer::min).orElseThrow();
        if(!flag){
            return min;
        }else{
            return max;
        }
    }    
        

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4);

        List<String> words=new ArrayList<>();
        words.add("java8"); words.add("Stream()"); words.add("reduce()");

        System.out.println("Sum : " + SumOfIntegers(list));
        System.out.println("Product : " + ProductOfIntegers(list));
        System.out.println("Concatenation : " + Concatenation(words));

        boolean flag=false;
        System.out.println((flag?"Max":"Min") + " Integer is : " + MaxOrMin(list, flag));

    }
}
