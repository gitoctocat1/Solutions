
public class LCA {
	
	
	//Complexity O(n)
	//Pre-order
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

}
