import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FreqofEachCharJAVA8 {
    public static Map<Character,Long> findFreqofEachCharJAVA8(String text){
        text=text.replaceAll("\\s+", "");
        return text.chars() // creates a stream of int (ASCII codes) //.stream() only works on: Collection types like List, Set, etc.
                        .mapToObj(element->(char) element) // convert to Character stream
                            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                            // Function.identity() - group by character , u can also use e->e
    }

    public static void main(String[] args) {
        String text="hello world";
        System.out.println(findFreqofEachCharJAVA8(text));
    }
}
