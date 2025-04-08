
import java.util.HashMap;
import java.util.List;


public class FreqOfEachItemJava8 {
    public static <T> HashMap<T,Long> FrequencyOfEachItemJava8(List<T> items){
       // return items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       HashMap<T,Long> map=new HashMap<>();
       items.stream().forEach(item->map.put(item, map.getOrDefault(item, 0L)+1));
       return map;
    }

    public static void main(String[] args) {
        List<String> items1=List.of("Pens", "books", "Candle", "Pens", "books","paper");
        List<Integer> items2=List.of(1,2,3,3,4,2,2,5,1);

        System.out.println(FrequencyOfEachItemJava8(items1));
        System.out.println();
        System.out.println(FrequencyOfEachItemJava8(items2));
    }
   
}
