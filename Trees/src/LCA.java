
public class LCA {
	
	
	//Complexity O(n)
	//Pre-order
	/**
	 * Lowest common ancestor of binary tree
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2){
		
		if(root==null){
			return null;
		}
		
		//check if root is LCA
		if(root.value == node1.value || root.value == node2.value){
			return root;
		}
		
		//check LCA in left subtree
		TreeNode left = LCA(root.left,node1,node2);
				
		//check LCA in right subtree
		TreeNode right = LCA(root.right, node1, node2);
		
		
		//if both subtrees have LCA, then root
		if(left!=null && right!=null){
			return root;
		}
		
		return left !=null ? left : right;
		
	}

	/**
	 * Lowest common ancestor of BST
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
	    if (root == null || a == null || b == null) {
	        return null;
	    }
	    
	    if (Math.max(a.value, b.value) < root.value) { 
	        // both nodes are on the left
	        return lowestCommonAncestor(root.left, a, b);    
	    } else 
	    if (Math.min(a.value, b.value) > root.value) {
	        // both nodes are on the right
	        return lowestCommonAncestor(root.right, a, b);    
	    } else {
	        // the nodes are on separate branches
	        return root;        
	    }
	}
}
