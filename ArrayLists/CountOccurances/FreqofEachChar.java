import java.util.HashMap;
import java.util.Map;

public class FreqofEachChar {
    public static Map<Character,Integer> findFreqofEachChar(String text){
        text=text.replaceAll("\\s+", "");
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:text.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1 );
            }
        }
    return map;
    }

    public static void main(String[] args) {
        String text="hello world";
        Map<Character,Integer> map=findFreqofEachChar(text);

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+ " : " + entry.getValue());
        }
    }
}
