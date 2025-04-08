//ASK : Implement a scorecard system using TreeMap where keys are student names and values are their scores. 
//The system should automatically sort by scores and also implement custom sort by name alphabets

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentScoreCard {
   TreeMap<Integer,List<String>> scoreCard=new TreeMap<>();//since The TreeMap will sort by the keys, so taken key as score and value as name.

   public void addStudent(String name,int score){
        scoreCard.computeIfAbsent(score, k->new ArrayList<>()).add(name);
        // checks like If the score doesn't exist in the TreeMap, create a new list and add the student's name.
        // checks like If the score exists, simply add the student's name to the existing list of names.
   }

   public void ScoreCardSystem(){
    for(Map.Entry<Integer,List<String>> entry: scoreCard.entrySet()){  //Loop through each entry (key-value pair) in the TreeMap.
        int score=entry.getKey(); //key is score
        List<String> students=entry.getValue(); //value is student name
        System.out.println("Score : "+score);
        Collections.sort(students);//sorted the list of student names
        for(String st:students){ // Loop through each student's name
            System.out.println("  - "+st);
        }
    }
   }

   public static void main(String[] args) {
       StudentScoreCard system=new StudentScoreCard(); // Created a new instance of the StudentScoreCard class.
       system.addStudent("Divya", 99);
       system.addStudent("shanaya", 85);
       system.addStudent("jithin", 67);
       system.addStudent("naren", 45);
       system.addStudent("Rupa", 99);

       system.ScoreCardSystem();
   }
    
}
