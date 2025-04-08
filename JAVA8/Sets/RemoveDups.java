
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDups {
    
// Method removes all duplicates and returns only unique elements
    public static <T> Set<T> findallDups(List<T> list){
        //HashSet<T> resultSet=new Hashset<>(list); return resultSet; 
        return new HashSet<>(list); // HashSet automatically removes duplicates from the list
    }

//this method keeps only the elements that appear more than once in the list
    public static <T> Set<T> KeepDups(List<T> list){
        Set<T> resultSet=new HashSet<>();  // Set to store duplicate elements
        Set<T> dupsSet=new HashSet<>(); // Set to store all elements we've seen
        for(T num:list){
            if(!dupsSet.add(num)){ // checks If the element already exists in dupsSet or not. {1,2,3,4}
                resultSet.add(num);  // Adding the duplicate element to resultSet.{1,2}
            }
        }
        return resultSet;
    }

//this method keeps only the elements that appear exactly once in the list
    public static <T> Set<T> keepUnique(List<T> list){
        Set<T> resultSet=new HashSet<>(); // Set to store elements that appear only once . since set only keeps unique elemts
        Set<T> dupsSet=new HashSet<>();  // Set to store elements that appear more than once
        for(T num:list){
            if(!resultSet.add(num)){ // If the element is already in the resultSet, it's a duplicate{1,2,3,4}
                dupsSet.add(num);//{1,2}
            }
        }
        resultSet.removeAll(dupsSet); // Remove all duplicates from resultSet, leaving only unique elements {3,4}
    return resultSet;
    }

    //public static <T> Set<T> keepElements(List<T> list, boolean keepDuplicates){
    //    Set<T> resultSet=new HashSet<>();
    //    Set<T> dupsSet=new HashSet<>();
    //    for(T num:list){
    //        if(!dupsSet.add(num)){   // If the element is already in dupsSet, add() returns false, indicating a duplicate.{1,2,3,4}
    //            resultSet.add(num); // If the element is a duplicate, added it to resultSet{1,2}
    //        }
    //    }
//
    //    if(!keepDuplicates){ //If the keepDuplicates is false
    //        Set<T> allElementsSet=new HashSet<>(list); // Createed a new set that contains all elements from the original list.{1,1,2,3,2,4}
    //        allElementsSet.removeAll(resultSet);  // Removing all elements from allElementsSet that are found in resultSet.{3,4}
    //        return allElementsSet;
    //    }
    //    return resultSet;{1,2}
    //}


    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println("Original List : "+list);
        System.out.println("First Case (remove all duplicates): " + findallDups(list));//{1,2,3,4}
        System.out.println("Second Case (keep duplicates): " + KeepDups(list));//{1,2}
        System.out.println("Third Case (keep only unique elements): " + keepUnique(list));//{3,4}
    }
}
