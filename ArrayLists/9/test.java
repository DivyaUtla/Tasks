import java.util.ArrayList;

class Dups{
    public static ArrayList<Integer> findDups(ArrayList<Integer> arr){
        ArrayList<Integer> resultArray=new ArrayList<>(); 
        ArrayList<Integer> dupsArray=new ArrayList<>();// used to store dups
        
        for(int i=0;i<arr.size();i++){
            int dupsCount=0;
            for(int j=0;j<arr.size();j++){
                if(arr.get(i)==arr.get(j)){
                    dupsCount++;
                }
            }

            if(dupsCount>1 && !dupsArray.contains(arr.get(i))){ //addings dupscount>1 elements to dups Array
                dupsArray.add(arr.get(i));
            }

            if(!dupsArray.contains(arr.get(i))){ // adding to result array the elements which are not there in dups
                resultArray.add(arr.get(i));
            }
        }
    return resultArray;
    }

    //int n=arr.size();
    //    for (int i = 0; i < n; i++) {
    //        if(!resultArray.contains(arr.get(i))){ // it will check and add to resarrray if the result array doesnt have have elements more than 1
    //            resultArray.add(arr.get(i));
    //        }
    //    }
}


public class test{
    public static void main(String[] args){
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        ArrayList<Integer> res=Dups.findDups(arr);
        System.out.println(res);
    }
}
