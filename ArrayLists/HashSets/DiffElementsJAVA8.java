
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DiffElementsJAVA8 {
    public static <T> Set<T> findDiffElementsJAVA8(Set<T> set1, Set<T> set2){
        return set1.stream().filter(element->!set2.contains(element)).collect(Collectors.toSet());//[exams] [time] // [1,5] [0,6]
    }

    public static void main(String[] args) {
        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();

        set1.add("family");
        set1.add("jobs");
        set1.add("exams");

        set2.add("jobs");
        set2.add("time");
        set2.add("family");

        Set<String> diff1=findDiffElementsJAVA8(set1, set2);
        Set<String> diff2=findDiffElementsJAVA8(set2, set1);
        
        System.out.println();
        System.out.println("Diff b/w set1 & set2 : " + diff1);
        System.out.println("Diff b/w set2 & set1 : " + diff2);

        Set<Integer> intset1=new HashSet<>();
        Set<Integer> intset2=new HashSet<>();

        intset1.add(1);
        intset1.add(45);
        intset1.add(5);

        intset2.add(45);
        intset2.add(0);
        intset2.add(6);

        Set<Integer> intdiff1=findDiffElementsJAVA8(intset1, intset2);
        Set<Integer> intdiff2=findDiffElementsJAVA8(intset2, intset1);

        System.out.println();
        System.out.println("Diff b/w intset1 & intset2 : " + intdiff1);
        System.out.println("Diff b/w intset2 & intset1 : " + intdiff2);
    }
}
