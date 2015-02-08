
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
}
