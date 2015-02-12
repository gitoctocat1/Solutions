import java.util.HashSet;
import java.util.Set;


public class WordBreak {
	
	
	public static void main(String[] args) {
		
		String s = "leetercode";
		
		Set<String> dict = new HashSet<String>();
		dict.add("leet"); dict.add("code");
		
		System.out.println("String can be split " + wordBreak(s, dict));
		
	}
	
	
	//Complexity O(size of string * size of dictionary)
	//t[0] = true initial condition
	//only when whole word matches , we set true at that index
	//       L    E     E     T     C    O     D     E
	//t[0] t[1]  t[2]  t[3]  t[4] t[5]  t[6]  t[7]  t[8]
	//true false false false true false false false true
	
	public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; 
 
        for(int i=0; i<s.length(); i++){
            //should continue from previous matched position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                //set index of T to be true for LEETCODE ( index 0,4 matches word leet in dictionary)
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        for(int i=0; i< s.length()+1 ; i++){
        	System.out.println("t[" +i+"]" +t[i]);
        }
        
        return t[s.length()];
    }
}
