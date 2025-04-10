import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test3 {
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);

        Map<Integer,Long> map=list.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
        List<Integer> res=list.stream().filter(e->map.get(e)>=1).distinct().collect(Collectors.toList());
        System.out.println(res);
    }
}
