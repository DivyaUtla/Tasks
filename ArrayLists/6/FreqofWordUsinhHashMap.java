// ASK : Find the frequency of each word in a given String using a HashMap.

import java.util.HashMap;
import java.util.Scanner;

class Frequency{
    public static String freqOfWords(String word){//ex: word="hello word hello"
       String[] words = word.split(" "); // I'm splitting the input word into words using space. words=["hello","world","hello"]

       HashMap<String, Integer> map = new HashMap<>();//created map to store the count/frequency of wrds

       for(String w:words){
        if(map.containsKey(w)){
            map.put(w,map.get(w)+1); // since if already wrd is found in map im incrrementing value by 1. [hello,2]
        }else{
            map.put(w,1); // if not found im adding the count to 1. [world,1]
        }
       }

       StringBuilder mapAsString = new StringBuilder();//created this to covert map data to readable format
       for(String w:map.keySet()){ //to get unique wrds used keyset()
        mapAsString.append(w).append(":").append(map.get(w)).append("\n");//here i/m appending each wrd and its frequwency
       }

    return mapAsString.toString();
    }
}

public class FreqofWordUsinhHashMap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter word : ");
       String word=sc.nextLine();
       String result=Frequency.freqOfWords(word);
       System.out.println(result);
        
        //String word = "This is a test. This is only a test";
        //System.out.println(Frequency.freqOfWords(word));
    }
}
