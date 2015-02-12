import java.util.LinkedList;
import java.util.Set;


public class WordLadder {
	
	// Complexity O(n)
	
	 /**Given:
		start = "hit"
		end = "cog"
		dict = ["hot","dot","dog","lot","log"]
		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
		return its length 5.
	*/	
	
	 public int ladderLength(String start, String end, Set<String> dict) {
	        
	     if (dict.size() == 0)  
	            return 0; 
	 
	        LinkedList<String> wordQueue = new LinkedList<String>();
	        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
	 
	        //push the start word to stack
	        wordQueue.add(start);
	        //start with distance of 1
	        distanceQueue.add(1);
	 
	 
	        while(!wordQueue.isEmpty()){
	        	//pop from stack
	            String currWord = wordQueue.pop();
	            Integer currDistance = distanceQueue.pop();
	 
	            //check if it is equal to the end word; if yes return
	            if(currWord.equals(end)){
	                return currDistance;
	            }
	 
	            //replace each character in the string, and check if it forms a new string; if yes, push onto stack
	            //and increment distance by 1; remove the currently formed word from the dictionary
	            for(int i=0; i<currWord.length(); i++){
	                char[] currCharArr = currWord.toCharArray();
	                for(char c='a'; c<='z'; c++){
	                    currCharArr[i] = c;
	 
	                    String newWord = new String(currCharArr);
	                    if(dict.contains(newWord)){
	                        wordQueue.add(newWord);
	                        distanceQueue.add(currDistance+1);
	                        dict.remove(newWord);
	                    }
	                }
	            }
	        }
	 
	        return 0;
	    
	    }

}
