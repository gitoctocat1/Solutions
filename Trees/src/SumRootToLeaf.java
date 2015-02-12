
public class SumRootToLeaf {

	
	 public int sumNumbers(TreeNode root) {
	        return sumNumbersUtil(root, 0);
	    }
	    
	    public int sumNumbersUtil(TreeNode root, int path) {
	        if (root == null) {
	            return 0;
	        }
	        
	        /* 
	            By passing path by value, 
	            the last digit need not be removed after subtrees are processed
	        */    
	        path = path*10 + root.value;

	        if (root.left == null && root.right == null) {
	            return path;
	        }

	        return sumNumbersUtil(root.left, path) + sumNumbersUtil(root.right, path);
	    }
}
