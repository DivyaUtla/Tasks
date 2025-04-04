import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.lang.model.element.Element;

public class CommonElementsJAVA8 {
    public static <T> Set<T> findCommonElementsJAVA8(Set<T> set1, Set<T> set2){
        return set1.stream().filter(set2::contains).collect(Collectors.toSet());
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

        System.out.println("Common Elements b/w set1 & set2 : " +findCommonElementsJAVA8(set1, set2));

        Set<Integer> intset1=new HashSet<>();
        Set<Integer> intset2=new HashSet<>();

        intset1.add(1);
        intset1.add(45);
        intset1.add(5);

        intset2.add(45);
        intset2.add(0);
        intset2.add(6);

        System.out.println("Common Elements b/w intset1 & intset2 : " +findCommonElementsJAVA8(intset1,intset2));
        System.out.println();
    }
}
