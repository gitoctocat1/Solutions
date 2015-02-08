
public class PathSum {

	 public boolean hasPathSum(TreeNode root, int sum) {
	        
	        if(root == null){
	            return false;
	        }
	        
	        //check if leaf node
	        if(root.left ==null && root.right ==null && (sum - root.value)==0){
	            return true;
	        }
	        
	        boolean left = hasPathSum(root.left, sum - root.value);
	        
	        boolean right = hasPathSum(root.right, sum - root.value);
	        
	        return left || right;
	    }
}
