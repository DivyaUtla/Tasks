import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FreqofEachCharJAVA8 {
    public static Map<Character,Long> findFreqofEachCharJAVA8(String text){
        text=text.replaceAll("\\s+", "");
        return text.chars().mapToObj(e->(char) e).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public static void main(String[] args) {
        String text="hello world";
        System.out.println(findFreqofEachCharJAVA8(text));
    }
}
