import java.util.HashSet;

public class DiffElements {
    public static <T> HashSet<T> findDiffElements(HashSet<T> set1,HashSet<T> set2){
        HashSet<T> resultSet=new HashSet<>(set1);
        resultSet.removeAll(set2);//removes all elements in set2 from resultset i.e., set1
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

        HashSet<String> diff1=findDiffElements(set1, set2);
        HashSet<String> diff2=findDiffElements(set2, set1);
        
        System.out.println();
        System.out.println("Diff b/w set1 & set2 : " + diff1);
        System.out.println("Diff b/w set2 & set1 : " + diff2);

        HashSet<Integer> intset1=new HashSet<>();
        HashSet<Integer> intset2=new HashSet<>();

        intset1.add(1);
        intset1.add(45);
        intset1.add(5);

        intset2.add(45);
        intset2.add(0);
        intset2.add(6);

        HashSet<Integer> intdiff1=findDiffElements(intset1, intset2);
        HashSet<Integer> intdiff2=findDiffElements(intset2, intset1);

        System.out.println();
        System.out.println("Diff b/w intset1 & intset2 : " + intdiff1);
        System.out.println("Diff b/w intset2 & intset1 : " + intdiff2);
    }
}
