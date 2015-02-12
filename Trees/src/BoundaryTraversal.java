public class BoundaryTraversal {

	/**
	 * Complexity O(n)
	 * @param root
	 */
	void printBoundary(TreeNode root) {

		if (root != null) {

			System.out.println(root.value);

			printLeftBoundary(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundary(root.right);
		}
	}

	private void printLeftBoundary(TreeNode left) {
		if (left != null) {
			if (left.left != null) {
				System.out.println(left.value);
				printLeftBoundary(left.left);
			} else if (left.right != null) {
				System.out.println(left.value);
				printLeftBoundary(left.right);
			}
		}
	}

	private void printRightBoundary(TreeNode right) {
		if (right != null) {
			if (right.right != null) {
				printRightBoundary(right.right);
				System.out.println(right.value);
			} else if (right.left != null) {
				printRightBoundary(right.left);
				System.out.println(right.value);
			}

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
