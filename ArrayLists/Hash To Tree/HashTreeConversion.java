import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//tree map is always sorts by its keys
public class HashTreeConversion {
    public static TreeMap<String,Integer> HashMapToTreeMap(HashMap<String,Integer> list){
        TreeMap<String,Integer> newList=new TreeMap<>(list);
        for(Map.Entry<String,Integer> entry:newList.entrySet()){
            System.out.println(entry.getKey()+"- "+entry.getValue());
        }
    return newList;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("divya", 99);
        map.put("shanaya", 85);
        map.put("jithin", 67);
        map.put("naren", 45);
        System.out.println(HashMapToTreeMap(map));

    }
}
