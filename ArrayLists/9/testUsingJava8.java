
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Map;

public class testUsingJava8 {
    public static ArrayList<Integer> findUnique(ArrayList<Integer> arr){
        ArrayList<Integer> resultArray=new ArrayList<>();
        Map<Integer,Long> freqofeach= arr.stream().collect(Collectors.groupingBy(element->element,Collectors.counting()));

        for(int num:arr){
            if(freqofeach.get(num)==1){ //to print {1,2} if(freqofeach.get(num)>1 && !resultArray.contains(num))
                resultArray.add(num);
            }
        }
        return resultArray;//{3,4}

    //return arr.stream().filter(element->freqofeach.get(element)==1).collect(Collectors.toCollection(ArrayList::new)); //{3,4}
    //return arr.stream().filter(element->freqofeach.get(element)>1).collect(Collectors.toCollection(ArrayList::new)); //{1,2,2,1}
    //return freqofeach.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
    //.collect(Collectors.toCollection(ArrayList::new));{1,2}// need only unique keys so used entryset()

    //arr.stream().filter(element->freqofeach.get(element)==1).forEach(resultArray::add);return result array{3,4}
    //freqofeach.entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).forEach(resultArray::add);return resultArray{1,2}

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(4);

        System.out.println(findUnique(arr));
    }
}
