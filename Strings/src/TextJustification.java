import java.util.ArrayList;
import java.util.List;


public class TextJustification {
	
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		TextJustification tj = new TextJustification();
		List<String> result = tj.fullJustify(words, 16);
		System.out.println(result.size());
	}
	
	 public List<String> fullJustify(String[] words, int L) {
	        
	        List<String> result = new ArrayList<String>();
	        
	        if(words == null || words.length == 0){
	            return result;
	        }
	        StringBuilder sb = new StringBuilder ();
	        
	        for(int i = 0; i < words.length ; i++){
	             sb = sb.append(words[i]).append(" ");
	            
	            if(sb.length() >= L){
	                result.add (sb.toString());
	                sb.setLength(0);
	                continue;
	            } else
	            if(i < words.length-1 && sb.length() + words[i+1].length() > L){
	            	 //add existing line to result
	            	 result.add (sb.toString());
	            	//start new line
	            	sb.setLength(0);
	            	
	            } 
	        }
	        
	       
            	result.add(sb.toString());
           
	        return result;
	    }

}
