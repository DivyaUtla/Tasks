import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FreqOfEachItem {
    public static <T> HashMap<T,Integer> FrequencyOfEachItem(List<T>items){
      HashMap<T,Integer> map=new HashMap<>();
      for(T item : items){
        if(map.containsKey(item)){
            map.put(item, map.get(item)+1);
        }else{
            map.put(item, 1);
        }
      }
      return map;
    }

    public static void main(String[] args) {
        List<String> items=List.of("Pens", "books", "Candle", "Pens", "books","paper");
        System.out.println(FrequencyOfEachItem(items));
    }
}
