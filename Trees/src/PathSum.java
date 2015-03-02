import java.util.ArrayList;
import java.util.List;


public class PathSum {

	/**
	 * Complexity O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	 public boolean hasPathSum(TreeNode root, int sum) {
	        
	        if(root == null){
	            return false;
	        }
	        
	        //check if leaf node and sum is 0
	        if(root.left ==null && root.right ==null && (sum - root.value)==0){
	            return true;
	        }
	        
	        //check if left subtree has a path
	        boolean left = hasPathSum(root.left, sum - root.value);
	        
	        //check if right subtree has a path
	        boolean right = hasPathSum(root.right, sum - root.value);
	        
	        return left || right;
	    }
	 
	 
	 
	 /**
	  * 
	  * @param root
	  * @param sum
	  * @return
	  */
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
			 
			 List<Integer> currentPath = new ArrayList<Integer>();
			 
			 getPath(root, sum, currentPath, result); 
			 
			 return result;
	        
	    }
	    
	    public void getPath(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> result ) {
		        
		        if(root == null){
		            return;
		        }
		        
		        currentPath.add(root.value);
		        
		        //check if leaf node and sum is 0
		        if(root.left ==null && root.right ==null && (sum - root.value)==0){
		            
		            //this is a valid path so add to the result
		            List<Integer> list = new ArrayList<Integer>(currentPath);    
		            result.add(list);
		        }
		        
		        //check if left subtree has a path
		        getPath(root.left, sum - root.value , currentPath, result);
		        
		        //check if right subtree has a path
		        getPath(root.right, sum - root.value, currentPath, result);
		        
		        currentPath.remove(currentPath.size()-1);
		        
		    }
}
