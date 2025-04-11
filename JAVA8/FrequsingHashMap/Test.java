import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
           List<String> items1=List.of("Pens", "books", "Candle", "Pens", "books","paper","books");

    //Frequency of each item

           Map<String,Long> map=items1.stream().collect(Collectors.groupingBy(item->item,Collectors.counting()));
           System.out.println("Frequency of each item : "+map);   
           System.out.println();

    //Sort by value (Frequency) - Asec & Dsec

        List<Map.Entry<String,Long>> sorted=map.entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toList());
        System.out.println("Sorted: "+sorted);

        List<Map.Entry<String,Long>> sortedReverse=map.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
        .collect(Collectors.toList());
        System.out.println("Reverse Sorted: "+sortedReverse);
        System.out.println();

    //Sort by Key
        List<Map.Entry<String,Long>> sortedKey=map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        System.out.println("Sorted by Key : "+sortedKey);
        System.out.println();

    //second largest value, if we want first just remove skip
           Long largest=map.values().stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse(null);
           System.out.println("second Largest item freq : "+largest);

    //second largest item
            List<String> largestItem=map.entrySet().stream().filter(entry->entry.getValue().equals(largest))
                                                     .map(Map.Entry::getKey).collect(Collectors.toList());
            System.out.println("Second Largest Item(s): "+largestItem);

    //Find the Most Frequent Value
            Long mostFreqValue = map.values().stream().max(Comparator.naturalOrder()).orElse(null);
            System.out.println("Most Frequent Value(s): " + mostFreqValue); 
    
    //Find the Most Frequent Item
            List<String> mostFrequentItems = map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(mostFreqValue)) //u can use to find mostfrequet 2nd item
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
     
            System.out.println("Most Frequent Item(s): " + mostFrequentItems);
            System.out.println();

    //Find item(s) with frequency > 1

            Map<String,Long> dups=map.entrySet().stream().filter(entry->entry.getValue()>1)
                                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            System.out.println("Items with frequency > 1: " +dups);
            System.out.println();

    //Count how many unique items exist
            long uniqueCount = map.size();
            System.out.println("Unique item count: " + uniqueCount);
            System.out.println();

    //Group items by frequency value 
            Map<Long, List<String>> groupedByFrequency = map.entrySet().stream()
            .collect(Collectors.groupingBy(
                Map.Entry::getValue,
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())
            ));
        System.out.println("Grouped by frequency: " + groupedByFrequency);
        System.out.println();
            
    }
}