import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * Complexity O(n^3)
 * Keep four pointers and use hashset to eliminate duplicates
 *
 */
public class FourSum {

	 public List<List<Integer>> fourSum(int[] num, int target) {
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        
	        
	       HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
	       
	        if(num.length == 0){
	            return result;
	        }
	        
	        Arrays.sort(num);
	        
	        for(int i = 0; i < num.length ; i++ ){
	            
	            for (int j = i +1 ; j < num.length ; j++){
	                
	                int k = j + 1;
	                int l = num.length - 1;
	                
	                while (k < l){
	                    
	                    int sum = num[i] + num [j ] + num[k] + num[l];
	                    
	                    if(sum == target){
	                        
	                        List<Integer> list = new ArrayList<Integer>();
	                        
	                        list.add(num[i]); list.add(num[j]); list.add(num[k]); list.add(num[l]);
	                    
	                        if(!hashSet.contains(list)){
	                            hashSet.add(list);
	                            result.add(list);
	                        }
	                        
	                        k++; l--;
	                        
	                    } else if (sum < target){
	                        k++;
	                        
	                    } else if (sum > target){
	                        l--;
	                    }
	                }
	            }
	        }
	        
	        return result;
	        
	    }
}
