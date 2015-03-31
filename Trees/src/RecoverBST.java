public class RecoverBST {

	TreeNode prev;
	TreeNode first, second;

	/**
	 * Complexity O(n)
	 * 
	 * @param root
	 */
	void recoverTree(TreeNode root) {

		prev = null;
		first = null;
		second = null;

		inOrder(root);

		// swap the values
		int temp;
		temp = first.value;
		first.value = second.value;
		second.value = temp;
	}

	void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		if (prev == null) {
			prev = root;
		} else {
			if (prev.value > root.value) {
				if (first == null) {
					first = prev;
				}
				second = root;
			}
			prev = root;
		}
		inOrder(root.right);

	}

};
