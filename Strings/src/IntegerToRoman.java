import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	
	/**
	 * Complexity O(n)
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {

		String[] romanNumber = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
				"V", "IV", "I" };
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		
		String result = "";
		
		
		for (int i = 0; i < 13; i++) {
			while (num >= value[i]) {
				result += romanNumber[i];
				num -= value[i];
			}
		}
		
		return result;
	}
	
	/**
	 * Complexity O(n)
	 * @param s
	 * @return
	 */
	 public int romanToInt(String s) {
		 
		 int result = 0;
		 
		 char[] arr = s.toCharArray();
	      
	      Map<String, Integer> romanLiterals = new HashMap<String, Integer>();
	       romanLiterals.put("M", new Integer(1000));
	       romanLiterals.put("CM", new Integer(900));
	       romanLiterals.put("D", new Integer(500));
	       romanLiterals.put("CD", new Integer(400));
	       romanLiterals.put("C", new Integer(100));
	       romanLiterals.put("XC", new Integer(90));
	       romanLiterals.put("L", new Integer(50));
	       romanLiterals.put("XL", new Integer(40));
	       romanLiterals.put("X", new Integer(10));
	       romanLiterals.put("IX", new Integer(9));
	       romanLiterals.put("V", new Integer(5));
	       romanLiterals.put("IV", new Integer(4));
	       romanLiterals.put("I", new Integer(1));
	       romanLiterals.put("", new Integer(0));
	      
	      for (int i = 0; i < arr.length; i++){
	          
	    	  //e.g : compare one or two characters at a time 
	    	  //e.g MCCXXI . find if M or MC exists
	          String temp1 = String.valueOf(arr[i]);
	          String temp2 = (i+1 < arr.length)? String.valueOf(arr[i+1]):"";
	         
	          
	         if(romanLiterals.containsKey(temp1+temp2)){
	              result += romanLiterals.get(temp1+temp2) ;
	              i++;
	          } else   if(romanLiterals.containsKey(temp1)){
	              result += romanLiterals.get(temp1);
	              
	          }
	      }     
		 
		 return result;
	 }
	        
		 
}
