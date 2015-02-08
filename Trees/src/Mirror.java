public class Mirror {

	
	/**
	 * Complexity O(n)
	 * The left and right subtrees are swapped at every node
	 * @param root
	 */
	void mirror(TreeNode root) {
		if (root == null) {
			return;
		} else {
			TreeNode temp;
			// do the subtrees
			mirror(root.left);
			mirror(root.right);
			// swap the pointers in this node
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
}
