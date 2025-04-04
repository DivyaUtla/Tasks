import java.util.ArrayList;
import java.util.HashSet;

//for HashSets - retainAll() and removeAll()

public class CommonElements {
    //I have used generic method with type T can be String, Integer,...
    public static <T> HashSet<T> findCommonElements(HashSet<T> set1,HashSet<T> set2){
        HashSet<T> resultSet=new HashSet<>(set1);
        resultSet.retainAll(set2); //it will check the elements of set1 present in set2
    return resultSet;
    }

    public static void main(String[] args) {
        HashSet<String> set1=new HashSet<>();
        HashSet<String> set2=new HashSet<>();

        set1.add("family");
        set1.add("jobs");
        set1.add("exams");

        set2.add("jobs");
        set2.add("time");
        set2.add("family");

        HashSet<Integer> intset1=new HashSet<>();
        HashSet<Integer> intset2=new HashSet<>();

        intset1.add(1);
        intset1.add(45);
        intset1.add(5);

        intset2.add(45);
        intset2.add(0);
        intset2.add(6);


        System.out.println(findCommonElements(set1, set2));
        System.out.println(findCommonElements(intset1, intset2));

    }
}
