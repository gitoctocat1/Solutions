import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
	
	public static void main(String[] args) {
		int[] num = {-7,-5,5,-6,-2,1,7,3,-4,-2,-2,-4,-8,-1,8,8,-2,-7,3,2,-7,8,-3,-10,5,2,8,7,7}; 
		threeSum(num);
		
	}

	
	 public static List<List<Integer>> threeSum(int[] num) {
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        
	        List<Integer> triplet = new ArrayList<Integer>();
	        
	        if(num.length == 0){
	            return result;
	        }
	        
	        //sort the array
	        Arrays.sort(num);
	        
	        for(int i = 0; i < num.length ; i++){
	            
	            int j = i+1;
	            int k = num.length -1 ;
	            
	          while(j <= k){    
	            
	             if(num[i]+num[j]+num[k]< 0){
	               j++;
	                 
	            } else if (num[i]+num[j]+num[k] > 0){
	                k--;
	                
	            } else {
	                triplet.add(0,num[i]);
	                triplet.add(1,num[j]);
	                triplet.add(2,num[k]);
	                result.add(triplet);
	                j++; k--;
	                
	            }
	          }  
	        }
	        return result;
	    }
}
