import java.util.HashMap;
import java.util.Stack;


public class ValidParanthesis {
	
	
	  /**
	   * Complexity O(n)
	   * @param s
	   * @return
	   */
	   public boolean isValid(String s) {
	        
	        Stack<String> stack = new Stack<String>();
	        
	        HashMap<Character, Character> map = new HashMap<Character,Character>();
	        map.put(')', '(');
	        map.put('}', '{');
	        map.put(']', '[');
	    
	        if(s==null || s.isEmpty()){
	            return false;
	        }
	        
	        if(s.length() == 1){
	            return false;
	        }
	        
	        char[] arr = s.toCharArray();
	    
	        for (int i=0; i< arr.length ; i++){
	            
	            if(arr[i] == '(' || arr[i] =='{' || arr[i]=='['){
	                stack.push(String.valueOf(arr[i]));
	            } 
	            else if (arr[i] ==')' || arr[i] == '}' || arr[i] ==']'){
	                  if(!stack.isEmpty()){
	                    
	                    if(stack.peek().charAt(0) == map.get(arr[i])){
	                        stack.pop();
	                    } else return false;
	               } else
	                   return false;
	            }
	        }
	        
	        if(stack.isEmpty()){
	            return true;
	        }
	        
	        return false;
	    }

}
