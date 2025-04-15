import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
        List<String> list=Arrays.asList("A","A","B","C","C","H");

//remove Dups {A,B,C,H}
        //List<String> allDups=list.stream().distinct().collect(Collectors.toList());
        //System.out.println(allDups);

        Set<String> allDups=list.stream().distinct().collect(Collectors.toSet());
        System.out.println("All Dups : " +allDups);

        //get the count of each
        Map<String,Long> allDupsFreq=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Frequency of each : "+ allDupsFreq);
        System.out.println();

//keep only dups {A,C}
        Set<String> keepDups=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                .entrySet().stream().filter(e->e.getValue()>1)
                                .map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println("Keep only Dups : "+keepDups);

        //List<String> keepDups=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        //                    .entrySet().stream().filter(e->e.getValue()>1)
        //                    .map(Map.Entry::getKey).collect(Collectors.toList());
        //System.out.println("Keep only Dups : "+keepDups);

        Map<String,Long> keepDupsFreq=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                      .entrySet().stream().filter(e->e.getValue()>1)
                                      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Frequency of each : "+ keepDupsFreq);  
        System.out.println();     

//keep unique {B,H}
        Set<String> unique=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                            .entrySet().stream().filter(e->e.getValue()==1)
                            .map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println("Keep only Unique : "+unique);

        //List<String> unique=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        //                    .entrySet().stream().filter(e->e.getValue()==1)
        //                    .map(Map.Entry::getKey).collect(Collectors.toList());
        //System.out.println("Keep only Unique : "+unique);

        Map<String,Long> uniqueFreq=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue()==1)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Frequency of each : "+ uniqueFreq);  
        System.out.println(); 
    }
}
