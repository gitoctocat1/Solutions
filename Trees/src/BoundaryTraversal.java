public class BoundaryTraversal {

	/**
	 * Complexity O(n)
	 * 
	 * @param root
	 */
	void printBoundary(TreeNode root) {

		if (root == null) {
			return;
		}

		System.out.println(root.value);

		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);

	}

	private void printLeftBoundary(TreeNode root) {
		if (root == null) {
	     return;
		}	
		
		if (root.left != null) {
			System.out.println(root.value);
			printLeftBoundary(root.left);
			
		} else if (root.right != null) {
			System.out.println(root.value);
			printLeftBoundary(root.right);
		}
		
	}

	private void printRightBoundary(TreeNode root) {
		if (root == null) {
		  return;	
		}		
			if (root.right != null) {
				printRightBoundary(root.right);
				System.out.println(root.value);
			} else if (root.left != null) {
				printRightBoundary(root.left);
				System.out.println(root.value);
			}

		
	}

	private void printLeaves(TreeNode node) {
		if (node != null) {
			if (node.left == null && node.right == null) {
				System.out.println(node.value);
			} else {
				printLeaves(node.left);
				printLeaves(node.right);
			}
		}
	}

}
