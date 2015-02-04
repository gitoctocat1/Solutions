
public class ValidateBST {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		
		root.left = new TreeNode(3);
		//root.right =new TreeNode(3);
		//root.right.right = new TreeNode(4);
		
		System.out.println(isValidBST(root));
	}
	
	
	//Complexity O(n) 
	//In-order traversal; keep track of previous node and compare values
	 public static boolean isValidBST(TreeNode root) {
	        
	        if (root==null){
	            return true;
	        }
	        TreeNode prev = null ;
	        
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

}
