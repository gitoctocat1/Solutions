
public class TrimBST {
	
	//complexity O(n)
	//post-order traversal : recursively traverse left, right subtrees then root
	
	public TreeNode trimBST(TreeNode root, int min, int max){
		
		 // Base case: leaves' children are null
	    if (root == null)
	        return root;
	    
	    // Case: current value too small - use trimmed right subtree
	    if (root.value < min)
	        return trimBST(root.right, min, max);
	    
	    // Case: current value too large - use trimmed left subtree
	    else if (root.value > max)
	        return trimBST(root.left, min, max);
	    
	    // Case: current value in range - trim both subtrees
	    else if (min <= root.value && root.value <= max) {
	        root.left = trimBST(root.left, min, max);
	        root.right = trimBST (root.right, min, max);
	        return root;
	    }
	    // Make sure we've covered all the cases
	    // (this should be unreachable if our cases are complete)
	    throw new RuntimeException("Unhandled case in trim!");
	}

}
