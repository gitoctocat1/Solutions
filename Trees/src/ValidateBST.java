
public class ValidateBST {
	
	 TreeNode prev = null ;

	
	
	//Complexity O(n) 
	//In-order traversal; keep track of previous node and compare values
	 public boolean isValidBST(TreeNode root) {
	        
	        if (root==null){
	            return true;
	        }
	       
	        
	        return isValid(root, prev);
	    }
	    
	    private static boolean isValid(TreeNode root, TreeNode prev){
	        
	        if (root==null){
	            return true;
	        }
	        
	        if (!isValid(root.left, prev)){
	            return false;
	        }
	        
	       if (prev != null && root.value <= prev.value){
	                return false;
	        }
	        prev = root;
	        
	        
	        if (!isValid(root.right, prev)){
	            return false; 
	        }
	        
	        return true;
	    }

	    
	    
	    //alternate approach to pass by reference
	    //return isValid(root, new TreeWrapper());
	    //private static boolean isValid(TreeNode root, TreeWrapper prev){
	    class TreeWrapper {
	    	TreeNode treenode;
	    }
}
