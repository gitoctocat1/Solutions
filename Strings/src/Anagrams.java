import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Anagrams {
	

    //Complexity O(n) ; copy into another array and sort the values;loop through sorted array and sorted values serve as keys to     the hashmap
    public List<String> anagrams(String[] strs) {
        
       List<String> anagrams = new ArrayList<String>();
        
        if(strs == null || strs.length == 0){
            return anagrams;
        }
        
        //copy into a temp array
        String[] temp = Arrays.copyOf(strs,strs.length);
        
        //sort words in the temp array
        for(int i=0; i< temp.length ;i ++){
            if(!temp[i].isEmpty()){
                
              char[] arr = temp[i].toCharArray();
              Arrays.sort(arr);
              temp[i] = new String(arr);
            }  
        }
        
        //loop through sorted array and put in hashmap
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0; i < temp.length ; i++){
            
           
            //if key already exists, add to the list
            if(map.containsKey(temp[i])){
               map.get(temp[i]).add(strs[i]);
            } else {
            
               //create new list and add
                List<String> str = new ArrayList<String>(); 
                str.add(strs[i]);
                map.put (temp[i], str);
            }
            
        }
        
        
        for(List<String> list : map.values()){
            //if more than one anagram, add to the result
           
            if ( list.size() > 1 ){
			  anagrams.addAll(list);
            }
		}
		
		return anagrams;
	}
        

}
