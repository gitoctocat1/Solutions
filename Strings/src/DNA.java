import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DNA {
	
	public List<String> findRepeatedDnaSequences(String s) {  
	    List<String> result=new ArrayList<String>();  
	    HashMap<Integer,Integer> computed=new HashMap<Integer,Integer>();  
	    for(int i=0;i<=s.length()-10;i++)  
	    {  
	      String sub=s.substring(i,i+10);  
	        Integer key = Integer.valueOf(getKey(sub));
	      if(computed.containsKey(key))  
	      {  
	        computed.put(key,computed.get(key)+1);  
	        if(computed.get(key)==2)  
	          result.add(sub);  
	      }  
	      else  
	        computed.put(key,1);  
	    }  
	    return result;  
	  }  
	  
	  private static int getKey(String s) {
	      int hash=7;
	       for (int i=0; i < s.length(); i++) {
	           hash = hash*31 + s.charAt(i) * (i+1);
	       }
	       return hash;
	  }

}
