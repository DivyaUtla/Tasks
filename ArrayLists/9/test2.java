
    //int n=arr.size();
    //    for (int i = 0; i < n; i++) {
    //        if(!resultArray.contains(arr.get(i))){ // it will check and add to resarrray if the result array doesnt have have elements more than 1
    //            resultArray.add(arr.get(i));
    //        }
    //    } //{1,2,3,4}



    // java 8 - ArrayList<Integer> resultArray=(ArrayList<Integer>) arr.stream().distinct().collect(Collectors.toList());
    //return resultArray;//{1,2,3,4}
	
	
	 //java8 - ArrayList<Integer> resultArray=new ArrayList<>();
        //Map<Integer,Long> freqOfEachElement=arr.stream().collect(Collectors.groupingBy(element->element, Collectors.counting()));//can use any variable (element)
        
        //for(int num:arr){
        //    if(freqOfEachElement.get(num)==1){
        //        resultArray.add(num);
        //    }
        //}
        //return resultArray;


        //return arr.stream().filter(element->freqOfEachElement.get(element)==1).collect(Collectors.toCollection(ArrayList::new));
        //toCollection(ArrayList::new) - return as new arraylist

		
		// arr.stream().filter(element -> freqOfEachElement.get(element) == 1).forEach(resultArray::add);  //adds element by element
        //return resultArray;