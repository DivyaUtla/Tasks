import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

class FreqofEachWordusingJava8{
    public static String freqOfEachWord(String text){
        List<String> words=Arrays.asList(text.split("\\s+"));

        Map<String,Long> freqOfEachElement=words.stream().collect(Collectors.groupingBy(word->word,Collectors.counting()));
        //instead of word->word i can use function.identity() //When grouping items and want to group by the item itself.

        return freqOfEachElement.toString();
    }

    public static void main(String[] args) {
        String text="hello wrld hello java java world hello";
        System.out.println(freqOfEachWord(text));
    }
}

