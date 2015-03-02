import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PhoneNumberLetterCombinations {
	
	public static void main(String[] args) {
		
		String digits = "650";
		PhoneNumberLetterCombinations pc = new PhoneNumberLetterCombinations();
		List<String> com = pc.letterCombinations(digits);
	}

	
	public List<String> letterCombinations(String digits) {
	      
	      
	      if (digits==null || digits.isEmpty()){
	          return new ArrayList<String>();
	      }
	     
	        String[] letters = {" ","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        LinkedList<String> list = new LinkedList<String>();
	         list.add("");
	        for (int i = 0; i < digits.length(); i++) {
	        	int num;
	        	if(digits.charAt(i) =='0'){
	        		num = 0;
	        	} else {
	               num = digits.charAt(i) - '1';
	        	}
	            int size = list.size();
	            for (int k = 0; k < size; k++) {
	                String tmp = list.pop();
	                for (int j = 0; j < letters[num].length(); j++)
	                    list.add(tmp + letters[num].charAt(j));
	            }
	        }
	        List<String> rec = new LinkedList<String>();
	        rec.addAll(list);
	        return rec;

	        
	    }
	
}
